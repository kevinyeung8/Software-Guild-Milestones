/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shoemanager.view;

import java.util.List;
import shoemanager.dto.Shoe;

/**
 *
 * @author kevinyeung
 */
public class ShoeView {
    private UserIO io;
    public int printShoeAndSelection;
    
    public ShoeView(UserIO io) {
        this.io = io;
    }

    public ShoeView() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int printShoeAndSelection() {
        io.print("Main Menu");
        io.print("1. Create Shoe");
        io.print("2. Remove Shoe");
        io.print("3. Edit Shoe");
        io.print("4. List Shoe");
        io.print("5. View Shoe by Sku Number");
        io.print("6. Get Shoe by Name");
        io.print("7. Exit");
        
        return.io.readInt("Please select from the" + "above choices.", 1, 7);
    }
    
    public Shoe getNewShoeInfo() {
        
        String shoeSku = io.readString("Please enter the Shoe Sku ");
        String shoeName = io.readString("Please enter the Shoe Name ");
        String releaseDate = io.readString("Please enter the Shoe Release Year ");
        String shoeStyle = io.readString("Please enter the style of the Shoe (Running, Basketball or Casual)");
        String shoeBrand = io.readString("Please enter the brand of the Shoe ");
        Shoe currentShoe = new Shoe(shoeSku);
        currentShoe.setShoeName(shoeName);
        currentShoe.setReleaseDate(releaseDate);
        currentShoe.setShoeStyle(shoeStyle);
        currentShoe.setShoeBrand(shoeBrand);
        return currentShoe;
}
    
    public void displayCreateShoeBanner() {
        
       
    }

    public void displayCreateShoeBanner() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void displayCreateSuccessBanner() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void displayRemoveShoeBanner() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getShoeSkuChoice() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void displayRemoveShoeSuccessBanner() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void displayEditShoeBanner() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void displayEditShoeSuccessBanner() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void displayAllBanner() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void displayShoeList(List<Shoe> shoeList) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void displayShoeBySkuBanner() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void displayShoe(Shoe shoe) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void displayShoeByNameBanner() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getShoeNameChoice() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void displayUnknownCommandBanner() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void displayExitBanner() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void displayCreateShoeBanner() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
