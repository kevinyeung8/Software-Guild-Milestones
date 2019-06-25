/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flooringmastery.controller;

import flooringmastery.dao.FlooringMasteryPersistenceException;
import flooringmastery.dto.Orders;
import flooringmastery.dto.Products;
import flooringmastery.dto.Taxes;
import flooringmastery.service.FlooringMasteryServiceLayer;
import flooringmastery.ui.FlooringMasteryView;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 *
 * @author kevinyeung
 */
public class FlooringMasteryController {

    private FlooringMasteryView view;
    private FlooringMasteryServiceLayer service;

    private String lastDateInserted = "", newDateInserted = "", OrderNumber = "";
    private List<Products> productsList;
    private List<Taxes> taxesList;

    public FlooringMasteryController(FlooringMasteryView view, FlooringMasteryServiceLayer service) throws FlooringMasteryPersistenceException {
        this.view = view;
        this.service = service;

        productsList = this.service.getProducts();
        taxesList = this.service.getTaxes();
    }

    public void run() throws FlooringMasteryPersistenceException {
        boolean keepGoing = true;
        int menuSelection = 0;
        

        while (keepGoing) {
            menuSelection = getMenuSelection();

            switch (menuSelection) {
                case 1:
                    displayAllOrders();
                    break;
                case 2:
                    addNewOrder();
                    break;
                case 3:
                    editOrder();
                    break;
                case 4:
                    removeOrder();
                    break;
                case 5:
                    saveCurrentWork();
                    break;
                case 6:
                    view.displayExitBanner();
                    keepGoing = false;
                    break;
                default:
                    unknownCommand();
            }
        }
    }
    
    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }


    private void displayAllOrders() throws FlooringMasteryPersistenceException {
        view.ordersBanner("*** Display All Orders ***");
        newDateInserted = view.getDate();
        List<Orders> myList = service.getAllOrders(newDateInserted, lastDateInserted);
        if (myList.size() <= 0) {
            view.displaySuccessBanner("ERROR: No Orders Registered for this particular Date");
            lastDateInserted = "";
        } else {
            view.displayAllOrders(myList);
            view.displaySuccessBanner("");
            lastDateInserted = newDateInserted;
        }
    }

    private void addNewOrder() throws FlooringMasteryPersistenceException {
       DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMddyyyy");
        LocalDate ld = LocalDate.now();
        newDateInserted = ld.format(formatter);
        
        view.ordersBanner("*** Add New Order ***");
        Orders currentOrder = view.getNewOrderDetails(productsList, taxesList);
        service.addOrder(currentOrder, newDateInserted, lastDateInserted);
        view.displayCurrentOrder(currentOrder);
        if (view.confirmationMsg("Do you want to proceed adding this Order #" +
                    currentOrder.getOrderNumber() + "? (y/n)").equalsIgnoreCase("y")){
            service.completeAddingNewOrder(currentOrder);
            view.displaySuccessBanner("Order Successfuly Added. ");
            lastDateInserted = newDateInserted;
        }else{
            view.displaySuccessBanner("Add New Order Discarded. ");
            lastDateInserted = "";
        }
    }

    private void editOrder() throws FlooringMasteryPersistenceException {
        view.ordersBanner("*** Edit Order ***");
        newDateInserted = view.getDate();
        OrderNumber = view.getOrderNumber();
        Orders currentOrder = service.getOrderByOrderNumber(OrderNumber, newDateInserted, lastDateInserted);
        if (currentOrder != null) {
            view.displayCurrentOrder(currentOrder);
            view.editExistingOrder(currentOrder);
            service.updateOrder(OrderNumber, newDateInserted, currentOrder);
            view.displaySuccessBanner("Order Successfuly updated. ");
            lastDateInserted = newDateInserted;
        } else {
            view.displaySuccessBanner("ERROR: No Orders Registered for this particular Date");
            lastDateInserted = "";
        }

    }

    private void removeOrder() throws FlooringMasteryPersistenceException {
        view.ordersBanner("*** Remove Order ***");
        newDateInserted = view.getDate();
        OrderNumber = view.getOrderNumber();
        Orders currentOrder = service.getOrderByOrderNumber(OrderNumber, newDateInserted, lastDateInserted);
        if (currentOrder != null) {
            view.displayCurrentOrder(currentOrder);
            if (view.confirmationMsg("Are you sure you want to delete Order #"
                    + currentOrder.getOrderNumber() + "? (y/n)").equalsIgnoreCase("y")) {
                service.removeOrder(OrderNumber, newDateInserted);
                view.displaySuccessBanner("Order Successfuly removed. ");
                lastDateInserted = newDateInserted;
            }
        } else {
            view.displaySuccessBanner("ERROR: No Orders Registered for this particular Date");
            lastDateInserted = "";
        }
    }

    private void saveCurrentWork() throws FlooringMasteryPersistenceException {
          view.ordersBanner("*** Save Current Work ***");
        //System.out.println(lastDateInserted);
        if (service.saveCurrentWork(lastDateInserted))
            view.displaySuccessBanner("Data Successfuly saved. ");
    
    }
}