/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shoemanager;

import shoemanager.dao.ShoeDao;
import shoemanager.view.ShoeView;
import shoemanager.view.UserIO;
import shoemanager.view.UserIOConsoleImpl;

/**
 *
 * @author kevinyeung
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        UserIO myIO = new UserIOConsoleImpl();
        ShoeView myView = new ShoeView(myIO);
        ShoeDao myDao = new ShoeDaoFileImpl();
        ShoeController myController = new ShoeController(myDao, myView);
        myController.run();
    }
    
}
