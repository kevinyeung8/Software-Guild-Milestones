/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.com.GuessTheNumber;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 *
 * @author kevinyeung
 */
@SpringBootApplication
public class App {

    public static void main(String[] args) {
        //DvdDao dvdDao = new DvdDaoFileImpl();
        //DirectorDao directorDao = new DirectorDaoFileImpl();
        //DvdService service = new DvdServiceImpl(dvdDao, directorDao);
        //UserIO io = new UserConsoleIOImpl();
        //DvdLibraryView view = new DvdLibraryView(io);
        //DvdController controller = new DvdController(view, service);

//        ApplicationContext ctx = new ClassPathXmlApplicationContext("Application-Context.xml");
//        DvdController controller = ctx.getBean("characterController", DvdController.class);
//
//        controller.Run();
        SpringApplication.run(App.class, args);
    }
}
