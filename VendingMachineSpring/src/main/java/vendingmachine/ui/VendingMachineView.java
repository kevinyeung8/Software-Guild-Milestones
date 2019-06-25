/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine.ui;

import java.math.BigDecimal;
import java.util.List;
import vendingmachine.dto.VendingMachine;

/**
 *
 * @author kevinyeung
 */

public class VendingMachineView {

    // Dependency injection
    private UserIO io;

   
    public VendingMachineView(UserIO io) {
        this.io = io;
    }

    public void displayGreeting() {
        io.print("**************************************");
        io.print("      GREETINGS    \nITEMS CATALOGUE:");
    }

    public void displayAllItemsInInventory(List<VendingMachine> items) {
        for (VendingMachine m : items) {
            if (m.getInventory() > 0) {
                io.print(m.getItemID() + "- " + m.getItemName() + "  --> $" + m.getItemCost());
            }
        }
        io.print("0 - Exit");
    }

    public void displayInsertCashBanner() {
        io.print("\n====== INSERT CASH ======");
    }

    public BigDecimal insertCash(BigDecimal cash) {
        cash = new BigDecimal(io.readDouble("Cash: "));
        return cash;
    }

    public void displayChooseItemBanner() {
        io.print("\n====== CHOOSE ITEM FROM CATALOGUE ======");
    }

    public void displayPurchaseSuccess(BigDecimal change, String rs) {
        io.print("Purchase made successfully.");
        io.print("Here is your change: " + change.toString()
                + "\n" + rs);
    }

    // Exit
    public void displayExitBanner() {
        io.print("Good Bye!!!!");
    }

    // Error messages
    public void displayErrorMessage(String errorMsg) {
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }

    public void displayUnknownCommandBanner() {
        io.print("UNKNOWN COMMAND!!!");
    }
}
