/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine.dto;

import java.math.BigDecimal;

/**
 *
 * @author kevinyeung
 */
public class VendingMachine {
    private String itemID;
    private String itemName;
    private BigDecimal itemCost;
    private int inventory;
    
    public VendingMachine(String itemID){
        this.itemID = itemID;
    }

    public String getItemID() {
        return itemID;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public BigDecimal getItemCost() {
        return itemCost;
    }

    public void setItemCost(BigDecimal itemCost) {
        this.itemCost = itemCost;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }
}
    
//    @Override
//    public String toString() {
//        return "ID: " + itemID + " |ItemName: " + itemName + " |Cost: "
//                + itemCost + " |Inventory: " + inventory;
//    }
//}