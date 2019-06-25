/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flooringmastery;

import flooringmastery.controller.FlooringMasteryController;
import flooringmastery.dao.FlooringMasteryModes;
import flooringmastery.dao.FlooringMasteryPersistenceException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author kevinyeung
 */
public class App {
    public static void main(String[] args) throws FlooringMasteryPersistenceException {

        ApplicationContext ctx;
        FlooringMasteryModes myMode = new FlooringMasteryModes();
        String mode = myMode.loadModes();

        if (mode.equalsIgnoreCase("Prod")) {
            ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        } else if (mode.equalsIgnoreCase("Training")) {
            ctx = new ClassPathXmlApplicationContext("applicationContext2.xml");
        } else {
            System.out.println("Mode undefined!");
            ctx = null;
        }

        if (ctx != null) {
            FlooringMasteryController controller = ctx.getBean("controller", FlooringMasteryController.class);
            controller.run();
        }
    }
}
