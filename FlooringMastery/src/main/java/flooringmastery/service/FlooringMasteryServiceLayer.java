/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flooringmastery.service;

import flooringmastery.dao.FlooringMasteryPersistenceException;
import flooringmastery.dto.Orders;
import flooringmastery.dto.Products;
import flooringmastery.dto.Taxes;
import java.util.List;

/**
 *
 * @author kevinyeung
 */
public interface FlooringMasteryServiceLayer {

    List<Orders> getAllOrders(String date, String lastDateInserted) throws FlooringMasteryPersistenceException;
    
    List<Products> getProducts() throws FlooringMasteryPersistenceException;
    
    List<Taxes> getTaxes() throws FlooringMasteryPersistenceException;
    
    Orders addOrder(Orders order, String todayDate, String lastDateInserted) throws FlooringMasteryPersistenceException;
    
    Orders getOrderByOrderNumber(String orderNumber, String date, String lastDateInserted) throws FlooringMasteryPersistenceException;
    
    Orders updateOrder(String orderNummber, String date, Orders order) throws FlooringMasteryPersistenceException;
    
    Orders removeOrder(String orderNumber, String date) throws FlooringMasteryPersistenceException;
    
    boolean saveCurrentWork(String date) throws FlooringMasteryPersistenceException;

    Orders completeAddingNewOrder(Orders currentOrder) throws FlooringMasteryPersistenceException;
    
}
