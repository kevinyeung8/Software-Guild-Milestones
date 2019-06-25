
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine.dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Integer.parseInt;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import vendingmachine.dto.VendingMachine;

/**
 *
 * @author kevinyeung
 */
public class VendingMachineDaoFileImpl implements VendingMachineDao {

    public final static String ITEMS_FILE = "inventory.txt";
    public static final String DELIMITER = "::";
    private Map<String, VendingMachine> machineInventory = new HashMap<>();

    public VendingMachineDaoFileImpl() throws VendingMachinePersistenceException {
        // Load items from file
        loadInventory();
    }

    @Override
    public boolean updateItem(String itemID) throws VendingMachinePersistenceException {
        try {
            // Create a new object with that particular item from the list
            VendingMachine currentItem = machineInventory.get(itemID);
            // Recude inventory by 1
            currentItem.setInventory(currentItem.getInventory() - 1);
            // Write changes on file
            writeInventory();
            return true;
        } catch (VendingMachinePersistenceException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    /**
     *
     * @return
     * @throws VendingMachinePersistenceException
     */
    @Override
    public List<VendingMachine> getAllItems() throws VendingMachinePersistenceException {
        // return list filtered
        return machineInventory.values().stream().collect(Collectors.toList());
    }

    @Override
    public VendingMachine getItem(String itemID) throws VendingMachinePersistenceException {
        //Retrieve data from HasMap using Lambdas to a List
        List<VendingMachine> myList = machineInventory.values()
                .stream()
                .filter(s -> s.getItemID().equalsIgnoreCase(itemID))
                .collect(Collectors.toList());

        VendingMachine thisItem;
        if (myList.size() > 0) {
            //If the list is not empty, assign the first and only row to the object thisItem
            thisItem = myList.get(0);
        } else {
            thisItem = null;
        }
        return thisItem;
    }

    private void loadInventory() throws VendingMachinePersistenceException {
        Scanner scanner;

        try {
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(ITEMS_FILE)));
        } catch (FileNotFoundException e) {
            throw new VendingMachinePersistenceException(
                    "-_- Could not load Vending Machine Inventory into memory.", e);
        }

        String currentLine;
        String[] currentTokens;

        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentTokens = currentLine.split(DELIMITER);
            VendingMachine currentItem = new VendingMachine(currentTokens[0]);
            currentItem.setItemName(currentTokens[1]);
            currentItem.setItemCost(new BigDecimal(currentTokens[2]));
            currentItem.setInventory(parseInt(currentTokens[3]));

            machineInventory.put(currentItem.getItemID(), currentItem);
        }
        scanner.close();
    }

    private void writeInventory() throws VendingMachinePersistenceException {
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(ITEMS_FILE));
        } catch (IOException e) {
            throw new VendingMachinePersistenceException(
                    "Could not save inventory data.", e);
        }

        List<VendingMachine> itemsList = this.getAllItems();
        for (VendingMachine currentItem : itemsList) {
            out.println(currentItem.getItemID() + DELIMITER
                    + currentItem.getItemName() + DELIMITER
                    + currentItem.getItemCost() + DELIMITER
                    + currentItem.getInventory());
            out.flush();
        }
        out.close();
    }
}
    
