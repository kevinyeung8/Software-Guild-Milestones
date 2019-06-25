    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flooringmastery.dao;

import flooringmastery.dto.Orders;
import flooringmastery.dto.Products;
import flooringmastery.dto.Taxes;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author kevinyeung
 */
public class FlooringMasteryStubImpl implements FlooringMasteryDao {

    public Orders currentOrder;
    public Taxes tax;
    public Products pr;
    
    private Map<String, Orders> ordersMap = new HashMap<>();
    private Map<String, Products> productsMap = new HashMap<>();
    private Map<String, Taxes> taxesMap = new HashMap<>();
    
    @Override
    public List<Orders> getAllOrders(String date, String lastDateInserted) throws FlooringMasteryPersistenceException {
        return ordersMap.values().stream().collect(Collectors.toList());
    }

    @Override
    public List<Products> getProducts() throws FlooringMasteryPersistenceException {
        if (productsMap.size() <= 0)
            createProducts();
        
        return productsMap.values().stream().collect(Collectors.toList());
    }

    @Override
    public List<Taxes> getTaxes() throws FlooringMasteryPersistenceException {
        if (taxesMap.size() <= 0)
            createTaxes();
        
        return taxesMap.values().stream().collect(Collectors.toList());
    }

    @Override
    public Products getProductByName(String name) throws FlooringMasteryPersistenceException {
        if (productsMap.size() <= 0)
            createProducts();
        
        List<Products> myList = productsMap.values()
                .stream()
                .filter(s -> s.getProductType().equalsIgnoreCase(name))
                .collect(Collectors.toList());

        Products thisProduct;
        if (myList.size() > 0) {
            thisProduct = myList.get(0);
        } else {
            thisProduct = null;
        }
        return thisProduct;
    }

    @Override
    public Taxes getTaxesByState(String state) throws FlooringMasteryPersistenceException {
        if (taxesMap.size() <= 0)
            createTaxes();
        
        List<Taxes> myList = taxesMap.values()
                .stream()
                .filter(s -> s.getState().equalsIgnoreCase(state))
                .collect(Collectors.toList());

        Taxes thisRecord;
        if (myList.size() > 0) {
            thisRecord = myList.get(0);
        } else {
            thisRecord = null;
        }
        return thisRecord;
    }

    @Override
    public Orders addOrder(String orderNumber, Orders order) throws FlooringMasteryPersistenceException {
        Orders orders = ordersMap.put(orderNumber, order);
        return orders;
    }

    @Override
    public Orders getOrderByOrderNumber(String orderNumber, String date, String lastDateInserted) throws FlooringMasteryPersistenceException {
        List<Orders> myList = ordersMap.values()
                .stream()
                .filter(s -> s.getOrderNumber().equalsIgnoreCase(orderNumber))
                .collect(Collectors.toList());

        Orders thisOrder;
        if (myList.size() > 0) {
            thisOrder = myList.get(0);
        } else {
            thisOrder = null;
        }
        return thisOrder;
    }

    @Override
    public Orders updateOrder(String orderNummber, String date, Orders order) throws FlooringMasteryPersistenceException {
        Orders orders = ordersMap.put(orderNummber, order);
        return orders;
    }

    @Override
    public Orders removeOrder(String orderNumber, String date) throws FlooringMasteryPersistenceException {
        Orders orders = ordersMap.remove(orderNumber);
        return orders;
    }

    @Override
    public boolean saveCurrentWork(String date) throws FlooringMasteryPersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void createTaxes(){
        tax = new Taxes();
        tax.setState("PA");
        tax.setTaxRate(new BigDecimal("6.75"));
        
        taxesMap.put(tax.getState(), tax);
        
        tax = new Taxes();
        tax.setState("OH");
        tax.setTaxRate(new BigDecimal("6.25"));
        
        taxesMap.put(tax.getState(), tax);
        
        tax = new Taxes();
        tax.setState("MI");
        tax.setTaxRate(new BigDecimal("5.75"));
        
        taxesMap.put(tax.getState(), tax);
    }
    
    public void createProducts(){
        pr = new Products();
        pr.setProductType("Wood");
        pr.setCostPerSquareFoot(new BigDecimal("5.75"));
        pr.setLaborCostPerSquareFoot(new BigDecimal("4.75"));
        
        productsMap.put(pr.getProductType(), pr);
        
        pr = new Products();
        pr.setProductType("Carpet");
        pr.setCostPerSquareFoot(new BigDecimal("2.25"));
        pr.setLaborCostPerSquareFoot(new BigDecimal("2.10"));
        
        productsMap.put(pr.getProductType(), pr);
        
        pr = new Products();
        pr.setProductType("Tile");
        pr.setCostPerSquareFoot(new BigDecimal("3.50"));
        pr.setLaborCostPerSquareFoot(new BigDecimal("4.15"));
        
        productsMap.put(pr.getProductType(), pr);
    }
}
