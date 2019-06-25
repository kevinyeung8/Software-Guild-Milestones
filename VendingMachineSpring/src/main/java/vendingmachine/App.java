/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import vendingmachine.controller.VendingMachineController;
import vendingmachine.dao.VendingMachineDao;
import vendingmachine.dao.VendingMachineDaoFileImpl;
import vendingmachine.service.InsufficientFundsException;
import vendingmachine.service.NoItemInventoryException;
import vendingmachine.dao.VendingMachinePersistenceException;
import vendingmachine.service.VendingMachineServiceLayer;
import vendingmachine.service.VendingMachineServiceLayerImpl;
import vendingmachine.ui.UserIO;
import vendingmachine.ui.UserIOConsoleImpl;
import vendingmachine.ui.VendingMachineView;

/**
 *
 * @author kevinyeung
 */
public class App {

    /**
     * @param args the command line arguments
     * @throws vendingmachine.dao.VendingMachinePersistenceException
     * @throws vendingmachine.service.InsufficientFundsException
     * @throws vendingmachine.service.NoItemInventoryException
     */
    public static void main(String[] args) throws
            VendingMachinePersistenceException, InsufficientFundsException, NoItemInventoryException {

//        UserIO myIo = new UserIOConsoleImpl();
//        VendingMachineView myView = new VendingMachineView(myIo);
//        VendingMachineDao myDao = new VendingMachineDaoFileImpl();
//        VendingMachineServiceLayer myService = new VendingMachineServiceLayerImpl(myDao);
//        VendingMachineController controller = new VendingMachineController(myView, myService);
//        controller.run();   
        
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        VendingMachineController controller = ctx.getBean("controller", VendingMachineController.class);
        controller.run();
    }
}   
