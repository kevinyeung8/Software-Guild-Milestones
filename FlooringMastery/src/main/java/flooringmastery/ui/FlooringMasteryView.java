/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flooringmastery.ui;

import flooringmastery.dto.Orders;
import flooringmastery.dto.Products;
import flooringmastery.dto.Taxes;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author kevinyeung
 */
public class FlooringMasteryView {

     // Dependency injection
    private UserIO io;

    public FlooringMasteryView(UserIO io) {
        this.io = io;
    }

    // =============================== GENERAL =================================
    // Menu List
    public int printMenuAndGetSelection() {
        io.print("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
        io.print("*  <<Flooring Program>>");
        io.print("* 1. Display Orders");
        io.print("* 2. Add an Order");
        io.print("* 3. Edit an Order");
        io.print("* 4. Remove an Order");
        io.print("* 5. Save Current Work");
        io.print("* 6. Quit");
        io.print("*");
        io.print("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");

        return io.readInt("Please, select from the choices above: ", 1, 6);
    }

    // Exit
    public void displayExitBanner() {
        io.print("GOOD BYE!!!!");
    }

    // Unknown Command
    public void displayUnknownCommandBanner() {
        io.print("*** unknown command ***");
    }

    // Error messages
    public void displayErrorMessage(String errorMsg) {
        io.print("*** ERROR ***");
        io.print(errorMsg);
    }

    public void displaySuccessBanner(String msg) {
        io.readString(msg + "Please hit enter to continue");
    }

    public String confirmationMsg(String msg) {
        return io.readString(msg);
    }
    // *************************************************************************

    // =========================== DISPLAY LISTS ===============================
    public void ordersBanner(String msg) {
        io.print(msg);
    }

    public String getDate() {
        return io.readString("Enter the date (MMDDYYYY): ");
    }

    public String getOrderNumber() {
        return io.readString("Enter the Order Number: ");
    }

    // Display DVD Collection
    public void displayAllOrders(List<Orders> orderList) {
        for (Orders currentOrder : orderList) {
            io.print("* * * * * * * * * * * * * * * * * * * * * * * * * * * *");
            io.print(" ");
            io.print("OrderNumber: " + currentOrder.getOrderNumber() + " \n"
                    + "Customer: " + currentOrder.getCustomerName() + " \n"
                    + "State: " + currentOrder.getState()
                    + ". Tax Rate: " + currentOrder.getTaxRate()
                    + ". Product: " + currentOrder.getProductType()
                    + ". Area: " + currentOrder.getArea() + " \n"
                    + "Cost Per Square Foot: " + currentOrder.getCostPerSquareFoot()
                    + ". Labor Cosrt Per Square Foot: " + currentOrder.getLaborCostPerSquareFoot() + " \n"
                    + "Material Cost: " + currentOrder.getMaterialCost()
                    + ". Labor Cost: " + currentOrder.getLaborCost()
                    + ". Tax: " + currentOrder.getTax()
                    + ". Total: " + currentOrder.getTotal()
            );

            io.print(" ");
        };
    }

    public void displayAllProducts(List<Products> productsList) {
        io.print("* * * * * * * * * * * * * * * * * * * * * * * * * * * *");
        io.print(" ");
        for (Products currentProduct : productsList) {
            io.print("Product Type: " + currentProduct.getProductType() + " \n"
                    + "Cost Per Square Foot: " + currentProduct.getCostPerSquareFoot()
                    + ". Labor Cost Per Square Foot: " + currentProduct.getLaborCostPerSquareFoot()
            );

            io.print(" ");
        };
    }

    public void displayAllTaxes(List<Taxes> taxesList) {
        io.print("* * * * * * * * * * * * * * * * * * * * * * * * * * * *");
        io.print(" ");
        for (Taxes currentTax : taxesList) {
            io.print("State: " + currentTax.getState()
                    + ". Tax Rate: " + currentTax.getTaxRate()
            );
        };
        io.print(" ");
    }

    public void displayCurrentOrder(Orders currentOrder) {
        io.print("* * * * * * * * * * * * * * * * * * * * * * * * * * * *");
        io.print(" ");
        io.print("OrderNumber: " + currentOrder.getOrderNumber() + " \n"
                + "Customer: " + currentOrder.getCustomerName() + " \n"
                + "State: " + currentOrder.getState()
                + ". Tax Rate: " + currentOrder.getTaxRate()
                + ". Product: " + currentOrder.getProductType()
                + ". Area: " + currentOrder.getArea() + " \n"
                + "Cost Per Square Foot: " + currentOrder.getCostPerSquareFoot()
                + ". Labor Cosrt Per Square Foot: " + currentOrder.getLaborCostPerSquareFoot() + " \n"
                + "Material Cost: " + currentOrder.getMaterialCost()
                + ". Labor Cost: " + currentOrder.getLaborCost()
                + ". Tax: " + currentOrder.getTax()
                + ". Total: " + currentOrder.getTotal()
        );

        io.print(" ");
    }
    // *************************************************************************

    // =========================== ADD NEW ORDER ===============================
    // Add New DVD item to the collection
    public Orders getNewOrderDetails(List<Products> pList, List<Taxes> tList) {
        boolean rs = false;
        String state;
        String productType;
        
        String costumerName = io.readString("Please enter Costumer Name: ");

        this.displayAllTaxes(tList);
        do{
            state = io.readString("Please enter State: ");
            rs = insertState(tList, state);
        } while (rs == false);
        
        this.displayAllProducts(pList);
        do{
            productType = io.readString("Please enter Product Type: ");
            rs = insertProductType(pList, productType);
        } while (rs == false);

        String area = io.readString("Please enter Area (how much) you want to purchase: ");

        // Set values
        Orders thisOrder = new Orders("");
        thisOrder.setCustomerName(costumerName);
        thisOrder.setState(state);
        thisOrder.setProductType(productType);
        thisOrder.setArea(new BigDecimal(area));

        return thisOrder;
    }
    
    public boolean insertState(List<Taxes> tList, String rs){
        boolean result = false;
        for (Taxes lT : tList){
           if (lT.getState().equalsIgnoreCase(rs)){
               result = true;
               break;
           }else{
               result = false;
           }
        }
        return result;
    }
    
    public boolean insertProductType(List<Products> pList, String rs){
        boolean result = false;
        for (Products lT : pList){
           if (lT.getProductType().equalsIgnoreCase(rs)){
               result = true;
               break;
           }else{
               result = false;
           }
        }
        return result;
    }
    // *************************************************************************

    // =========================== EDIT ORDER ===============================
    public void editExistingOrder(Orders currentOrder) {
        // Ask for the user to re enter only the main fields.
        String name = io.readString("Enter Costumer Name (" + currentOrder.getCustomerName() + "):");
        if (!"".equals(name)) {
            currentOrder.setCustomerName(name);
        }

        String state = io.readString("Enter State (" + currentOrder.getState() + "):");
        if (!"".equals(state)) {
            currentOrder.setState(state);
        }

        String productType = io.readString("Enter Product Type (" + currentOrder.getProductType() + "):");
        if (!"".equals(productType)) {
            currentOrder.setProductType(productType);
        }

        String area = io.readString("Enter Area (" + currentOrder.getArea() + "):");
        if (!"".equals(area)) {
            currentOrder.setArea(new BigDecimal(area));
        }
    }
}
