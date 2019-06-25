/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flooringmastery.dao;

import flooringmastery.dto.Orders;
import flooringmastery.dto.Products;
import flooringmastery.dto.Taxes;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 *
 * @author kevinyeung
 */
public class FlooringMasteryDaoOnMemoryImpl implements FlooringMasteryDao {

    public final static String ORDERS_FILE = "Orders_";
    public final static String PRODUCTS_FILE = "Products.txt";
    public final static String TAXES_FILE = "Taxes.txt";
    public static final String DELIMITER = ",";

    private Map<String, Orders> ordersMap = new HashMap<>();
    private Map<String, Products> productsMap = new HashMap<>();
    private Map<String, Taxes> taxesMap = new HashMap<>();

    FlooringMasteryLoadingFiles files = new FlooringMasteryLoadingFiles();

    private void loadOrders(String date) throws FlooringMasteryPersistenceException, FileNotFoundException {
        try {
           files.loadAllOrders(ORDERS_FILE + date + ".txt", DELIMITER, ordersMap);
        } catch (FlooringMasteryPersistenceException e) {
        }
    }

    private void loadProducts() throws FlooringMasteryPersistenceException {
        files.loadAllProducts(PRODUCTS_FILE, DELIMITER, productsMap);
    }

    private void loadTaxes() throws FlooringMasteryPersistenceException {
        files.loadAllTaxes(TAXES_FILE, DELIMITER, taxesMap);
    }

    @Override
    public List<Orders> getAllOrders(String date, String lastDateInserted) throws FlooringMasteryPersistenceException {
        try {
            loadOrders(date);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FlooringMasteryDaoOnMemoryImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ordersMap.values().stream().collect(Collectors.toList());
    }

    @Override
    public List<Products> getProducts() throws FlooringMasteryPersistenceException {
        loadProducts();
        return productsMap.values().stream().collect(Collectors.toList());
    }

    @Override
    public List<Taxes> getTaxes() throws FlooringMasteryPersistenceException {
        loadTaxes();
        return taxesMap.values().stream().collect(Collectors.toList());
    }

    @Override
    public Products getProductByName(String name) throws FlooringMasteryPersistenceException {
        if (productsMap.size() <= 0) {
            loadProducts();
        }

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
        if (taxesMap.size() <= 0) {
            loadTaxes();
        }

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
        try {
            loadOrders(date);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FlooringMasteryDaoOnMemoryImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        System.out.println("Operation not supported in Training Mode. Data saved in Memory.");
        return false;
    }
}
