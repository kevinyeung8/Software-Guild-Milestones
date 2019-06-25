/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine.dao;

import java.util.List;
import vendingmachine.dto.VendingMachine;

/**
 *
 * @author kevinyeung
 */
public interface VendingMachineDao {

    //CRUD
    //Create
    //Read All
    //Read By Name
    //Update
    //Delete
    boolean updateItem(String itemID)
            throws VendingMachinePersistenceException;

    List<VendingMachine> getAllItems() throws VendingMachinePersistenceException;

    VendingMachine getItem(String itemID) throws VendingMachinePersistenceException;
}
