/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import vendingmachine.dto.VendingMachine;

/**
 *
 * @author kevinyeung
 */
public class VendingMachineDaoStubImpl implements VendingMachineDao {

    public VendingMachine item;
    public List<VendingMachine> itemsList = new ArrayList<>();

    @Override
    public boolean updateItem(String itemID) throws VendingMachinePersistenceException {
        if (itemsList.size() == 0) {
            createItems();
        }

        List<VendingMachine> myList = itemsList
                .stream()
                .filter(s -> s.getItemID().equalsIgnoreCase(itemID))
                .collect(Collectors.toList());

        VendingMachine currentItem;
        if (myList.size() > 0) {
            currentItem = myList.get(0);
            currentItem.setInventory(currentItem.getInventory() - 1);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<VendingMachine> getAllItems() throws VendingMachinePersistenceException {
        if (itemsList.size() == 0) {
            createItems();
        }
        return itemsList;
    }

    @Override
    public VendingMachine getItem(String itemID) throws VendingMachinePersistenceException {
        if (itemsList.size() == 0) {
            createItems();
        }

        List<VendingMachine> myList = itemsList
                .stream()
                .filter(s -> s.getItemID().equalsIgnoreCase(itemID))
                .collect(Collectors.toList());

        VendingMachine thisItem;
        if (myList.size() > 0) {
            thisItem = myList.get(0);
        } else {
            thisItem = null;
        }
        return thisItem;
    }

    public void createItems() {
        item = new VendingMachine("A1");
        item.setItemName("SPARKLING WATER");
        item.setItemCost(new BigDecimal("1.09"));
        item.setInventory(10);

        itemsList.add(item);

        item = new VendingMachine("A2");
        item.setItemName("WATER");
        item.setItemCost(new BigDecimal("0.99"));
        item.setInventory(20);

        itemsList.add(item);
    }
}
