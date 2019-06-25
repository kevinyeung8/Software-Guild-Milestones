/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flooringmastery.dao;

import flooringmastery.dto.Orders;
import flooringmastery.dto.Products;
import flooringmastery.dto.Taxes;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author kevinyeung
 */
public class FlooringMasteryLoadingFiles {

     public void loadAllOrders(String FILENAME, String DELIMITER, Map ordersMap) throws FlooringMasteryPersistenceException, FileNotFoundException {
        Scanner scanner;

        try {
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(FILENAME)));
        } catch (FileNotFoundException e) {
            throw new FlooringMasteryPersistenceException(
                    "-_- Could not load Orders into memory.", e);
        }

        String currentLine;
        String[] currentTokens;

        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentTokens = currentLine.split(DELIMITER);
            Orders currentOrder = new Orders(currentTokens[0]);
            currentOrder.setCustomerName(currentTokens[1]);
            currentOrder.setState(currentTokens[2]);
            currentOrder.setTaxRate(new BigDecimal(currentTokens[3]));
            currentOrder.setProductType(currentTokens[4]);
            currentOrder.setArea(new BigDecimal(currentTokens[5]));
            currentOrder.setCostPerSquareFoot(new BigDecimal(currentTokens[6]));
            currentOrder.setLaborCostPerSquareFoot(new BigDecimal(currentTokens[7]));
            currentOrder.setMaterialCost(new BigDecimal(currentTokens[8]));
            currentOrder.setLaborCost(new BigDecimal(currentTokens[9]));
            currentOrder.setTax(new BigDecimal(currentTokens[10]));
            currentOrder.setTotal(new BigDecimal(currentTokens[11]));

            ordersMap.put(currentOrder.getOrderNumber(), currentOrder);
        }
        scanner.close();
    }
    
    public void loadAllProducts(String FILENAME, String DELIMITER, Map productsMap) throws FlooringMasteryPersistenceException {
        Scanner scanner;

        try {
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(FILENAME)));
        } catch (FileNotFoundException e) {
            throw new FlooringMasteryPersistenceException(
                    "-_- Could not load Products into memory.", e);
        }

        String currentLine;
        String[] currentTokens;

        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentTokens = currentLine.split(DELIMITER);
            Products currentProduct = new Products();
            currentProduct.setProductType(currentTokens[0]);
            currentProduct.setCostPerSquareFoot(new BigDecimal(currentTokens[1]));
            currentProduct.setLaborCostPerSquareFoot(new BigDecimal(currentTokens[2]));

            productsMap.put(currentProduct.getProductType(), currentProduct);
        }
        scanner.close();
    }
    
    public void loadAllTaxes(String FILENAME, String DELIMITER, Map taxesMap) throws FlooringMasteryPersistenceException {
        Scanner scanner;

        try {
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(FILENAME)));
        } catch (FileNotFoundException e) {
            throw new FlooringMasteryPersistenceException(
                    "-_- Could not load Taxes into memory.", e);
        }

        String currentLine;
        String[] currentTokens;

        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentTokens = currentLine.split(DELIMITER);
            Taxes currentTax = new Taxes();
            currentTax.setState(currentTokens[0]);
            currentTax.setTaxRate(new BigDecimal(currentTokens[1]));

            taxesMap.put(currentTax.getState(), currentTax);
        }
        scanner.close();
    }
}
