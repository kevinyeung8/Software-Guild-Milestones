/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shoemanager.controller;

import shoemanager.dao.ShoeDao;
import shoemanager.dao.ShoeDaoImpl;
import shoemanager.dto.Shoe;
import shoemanager.view.ShoeView;
import shoemanager.view.UserIO;
import shoemanager.view.UserIOConsoleImpl;

/**
 *
 * @author kevinyeung
 */
public class ShoeController {
    
    private final ShoeView view = new ShoeView();
    private final UserIO io = new UserIOConsoleImpl();
    private final ShoeDao dao = new ShoeDaoImpl();
    
    
    public void Run() {
        
        boolean keepGoing = true; 
        int shoeSelection = 0;
        
        while (keepGoing) {
            shoeSelection = getShoeSelection();
            
        switch (shoeSelection) {
            
            case 1:
                createShoe();
                break;
            case 2:
                removeShoe();
                break;
            case 3:
                editShoe();
                break;
            case 4:
                listShoe();
                break;
            case 5:
                viewShoeById();
                break;
            case 6: 
                viewShoeByName();
                break;
            case 7:
                keepGoing = false;
                break;
            default:
                unknownCommand();
                                  
        }
            
        }
        exitMessage();
    }

    private int getShoeSelection() {
        return view.printShoeAndSelection();
    }

    private void createShoe() {
        
        view.displayCreateShoeBanner();
        Shoe newShoe = view.getNewShoeInfo();
        dao.addShoe(newShoe.getShoeName(), newShoe);
        view.displayCreateSuccessBanner();
    }

    private void removeShoe() {
        view.displayRemoveShoeBanner();
        String removeShoe = view.getShoeSkuChoice();
        dao.removeShoe(removeShoe);
        view.displayRemoveShoeSuccessBanner();
        
        
    }

    private void editShoe() {
        view.displayEditShoeBanner();
        Shoe editShoe = view.getNewShoeInfo();
        dao.editShoe(editShoe);
        view.displayEditShoeSuccessBanner();
    }

    private void listShoe() {
        view.displayAllBanner();
        List<Shoe> shoeList = dao.getAllShoes();
        view.displayShoeList(shoeList);
        
    }

    private void viewShoeBySku() {
        view.displayShoeBySkuBanner();
        String shoeSku = view.getShoeSkuChoice();
        Shoe shoe = dao.getDiskBySku(shoeSku);
        view.displayShoe(shoe);
    }

    private void viewShoeByName() {
        view.displayShoeByNameBanner();
        String shoeName = view.getShoeNameChoice();
        Shoe shoe = dao.getDiskByName(shoeName);
        view.displayShoe(shoe);
    }

    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }
    
    public ShoeController(ShoeDao dao, ShoeView view) {
        this.dao = dao;
        this.view = view;
    }
}
