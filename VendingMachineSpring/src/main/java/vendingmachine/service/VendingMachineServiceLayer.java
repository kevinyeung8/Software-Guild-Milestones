/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine.service;

import vendingmachine.dao.VendingMachinePersistenceException;
import java.math.BigDecimal;
import java.util.List;
import vendingmachine.dto.VendingMachine;

/**
 *
 * @author kevinyeung
 */

  public interface VendingMachineServiceLayer {

    String purchaseItem(VendingMachine item, BigDecimal cash) throws
            VendingMachinePersistenceException;

    List<VendingMachine> getAllItems() throws VendingMachinePersistenceException;

    VendingMachine getItem(String itemID) throws VendingMachinePersistenceException;
    
    String validateInventory(VendingMachine item) throws NoItemInventoryException;
    
    String validateFunds(VendingMachine item, BigDecimal cash) throws InsufficientFundsException;

}

