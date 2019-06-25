/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flooringmastery.service;

import flooringmastery.dao.FlooringMasteryAuditDao;
import flooringmastery.dao.FlooringMasteryDao;
import flooringmastery.dao.FlooringMasteryPersistenceException;
import flooringmastery.dto.Orders;
import flooringmastery.dto.Products;
import flooringmastery.dto.Taxes;
import static java.lang.Integer.parseInt;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author kevinyeung
 */
public class FlooringMasteryServiceLayerImpl implements FlooringMasteryServiceLayer {

    private FlooringMasteryAuditDao audit;
    private FlooringMasteryDao dao;

    public FlooringMasteryServiceLayerImpl(FlooringMasteryAuditDao audit, FlooringMasteryDao dao) {
        this.audit = audit;
        this.dao = dao;
    }

     @Override
    public List<Orders> getAllOrders(String date, String lastDateInserted) throws FlooringMasteryPersistenceException {
        return dao.getAllOrders(date, lastDateInserted);
    }

    @Override
    public List<Products> getProducts() throws FlooringMasteryPersistenceException {
        return dao.getProducts();
    }

    @Override
    public List<Taxes> getTaxes() throws FlooringMasteryPersistenceException {
        return dao.getTaxes();
    }

    @Override
    public Orders addOrder(Orders order, String todayDate, String lastDateInserted) throws FlooringMasteryPersistenceException {
        
        // Check the last order ID from today.
        List<Orders> myList = dao.getAllOrders(todayDate, lastDateInserted);
        if(myList.size() > 0){
            Orders thisOrder = myList.get(myList.size()-1);
            int num = parseInt(thisOrder.getOrderNumber());
            num ++;
            order.setOrderNumber(Integer.toString(num));
        }else{
            order.setOrderNumber("1");
        }
        
        // Set tax rate
        Taxes myTax = dao.getTaxesByState(order.getState());
        order.setTaxRate(myTax.getTaxRate());
        
        //can get null, need to validate.
        
        // Set fields that depeneds on ProductType
        Products myProduct = dao.getProductByName(order.getProductType());
        order.setCostPerSquareFoot(myProduct.getCostPerSquareFoot());
        order.setLaborCostPerSquareFoot(myProduct.getLaborCostPerSquareFoot());
        
        // Calculate material, labor, tax and total
        order.setMaterialCost(order.getArea().multiply(order.getCostPerSquareFoot()));
        order.setLaborCost(order.getArea().multiply(order.getLaborCostPerSquareFoot()));
        
        BigDecimal totalBeforeTaxes = order.getMaterialCost().add(order.getLaborCost());
        order.setTax(totalBeforeTaxes.multiply(order.getTaxRate().divide(new BigDecimal("100"))));
        
        order.setTotal(totalBeforeTaxes.add(order.getTax()));
        
        return order;
    }
    
    @Override
    public Orders getOrderByOrderNumber(String orderNumber, String date, String lastDateInserted) throws FlooringMasteryPersistenceException {
        return dao.getOrderByOrderNumber(orderNumber, date, lastDateInserted);
    }

    @Override
    public Orders updateOrder(String orderNummber, String date, Orders order) throws FlooringMasteryPersistenceException {
        
        // Set tax rate
        Taxes myTax = dao.getTaxesByState(order.getState());
        order.setTaxRate(myTax.getTaxRate());
        
        // Set fields that depeneds on ProductType
        Products myProduct = dao.getProductByName(order.getProductType());
        order.setCostPerSquareFoot(myProduct.getCostPerSquareFoot());
        order.setLaborCostPerSquareFoot(myProduct.getLaborCostPerSquareFoot());
        
        // Calculate material, labor, tax and total
        order.setMaterialCost(order.getArea().multiply(order.getCostPerSquareFoot()));
        order.setLaborCost(order.getArea().multiply(order.getLaborCostPerSquareFoot()));
        
        BigDecimal totalBeforeTaxes = order.getMaterialCost().add(order.getLaborCost());
        order.setTax(totalBeforeTaxes.multiply(order.getTaxRate().divide(new BigDecimal("100"))));
        
        order.setTotal(totalBeforeTaxes.add(order.getTax()));
        
        return dao.updateOrder(orderNummber, date, order);
    }

    @Override
    public Orders removeOrder(String orderNumber, String date) throws FlooringMasteryPersistenceException {
        return dao.removeOrder(orderNumber, date);
    }

    @Override
    public boolean saveCurrentWork(String date) throws FlooringMasteryPersistenceException {
        return dao.saveCurrentWork(date);
    }

    @Override
    public Orders completeAddingNewOrder(Orders currentOrder) throws FlooringMasteryPersistenceException {
        return dao.addOrder(currentOrder.getOrderNumber(), currentOrder);
    }
}
