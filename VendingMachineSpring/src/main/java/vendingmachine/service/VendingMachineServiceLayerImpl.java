/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine.service;

import java.math.BigDecimal;
import java.util.List;
import vendingmachine.dao.VendingMachineAuditDao;
import vendingmachine.dao.VendingMachineDao;
import vendingmachine.dao.VendingMachinePersistenceException;
import vendingmachine.dto.VendingMachine;

/**
 *
 * @author kevinyeung
 */
public class VendingMachineServiceLayerImpl implements VendingMachineServiceLayer {

    VendingMachineDao dao;
    VendingMachineAuditDao audit;

    public VendingMachineServiceLayerImpl(VendingMachineDao dao, VendingMachineAuditDao audit) {
        this.dao = dao;
        this.audit = audit;
    }

    @Override
    public String purchaseItem(VendingMachine item, BigDecimal cash)
            throws VendingMachinePersistenceException {

        String rs = "";

        // Update Inventory in the File
        if (dao.updateItem(item.getItemID())) {
            // Get change
            Change cg = new Change();
            rs = cg.getChange(item.getItemCost(), cash.subtract(item.getItemCost()));
            // Return change as a string
            return rs;
        } else {
            return "Purchase not made.";
        }

    }

    @Override
    public List<VendingMachine> getAllItems() throws VendingMachinePersistenceException {
        // Get all items from inventory, on DAO java class
        return dao.getAllItems();
    }

    @Override
    public VendingMachine getItem(String itemID) throws VendingMachinePersistenceException {
        // Get one item from inventory, on DAO java class
        return dao.getItem(itemID);
    }

    @Override
    public String validateInventory(VendingMachine item) throws NoItemInventoryException {
        // Validate Inventory
        
          if (item.getInventory() == 0) {
                throw new NoItemInventoryException(
                        "ERROR: No Items Available in Inventory.");

        }
        return "";
        
    }

    @Override
    public String validateFunds(VendingMachine item, BigDecimal cash) throws InsufficientFundsException {
        // Validation of insuficient Funds
        try {
            // Ask if the cost of the item is greater than the cash inserted
            if (item.getItemCost().compareTo(cash) > 0) {
                throw new InsufficientFundsException(
                        "ERROR: Insuficient Funds. The item costs $"
                        + item.getItemCost() + " and you entered $" + cash
                        + " in the Vending Machine");
            } else {
                return "";
            }
        } catch (InsufficientFundsException e) {
            // Catch exception and print message
            System.out.println(e.getMessage());
            return "Purchase not made.";
        }
    }

}
