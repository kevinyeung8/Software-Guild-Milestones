/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine.service;

import java.math.BigDecimal;
import static junit.framework.Assert.assertEquals;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import vendingmachine.dao.VendingMachineAuditDao;
import vendingmachine.dao.VendingMachineDao;
import vendingmachine.dto.VendingMachine;

/**
 *
 * @author kevinyeung
 */
public class VendingMachineServiceLayerImplTest {
    
    VendingMachineServiceLayer service;
    VendingMachineDao dao;
    VendingMachineAuditDao audit;

    public VendingMachineServiceLayerImplTest() {
        
        /*dao = new VendingMachineDaoStubImpl();
        audit = new VendingMachineAuditDaoFileImpl();
        service = new VendingMachineServiceLayerImpl(dao, audit);*/
        
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        service = ctx.getBean("serviceLayer", VendingMachineServiceLayer.class);
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of purchaseItem method, of class VendingMachineServiceLayerImpl.
     */
    @Test
    public void testPurchaseItem() throws Exception {
        
        // CASE 1: Purchase success
        
        VendingMachine item = service.getItem("A1");
        BigDecimal cash = new BigDecimal("10");
        
        String expResult = "\n5 Dollars Bills : 1"
                + "\n1 Dollar Bills : 3"
                + "\nQuater/s : 3"
                + "\nDime/s : 1"
                + "\nNickel/s : 1"
                + "\nPenny/ies : 1";
        
        String result = service.purchaseItem(item, cash);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getAllItems method, of class VendingMachineServiceLayerImpl.
     */
    @Test
    public void testGetAllItems() throws Exception {
        assertEquals(2, service.getAllItems().size());
    }

    /**
     * Test of getItem method, of class VendingMachineServiceLayerImpl.
     */
    @Test
    public void testGetItem() throws Exception {
        VendingMachine item1 = service.getItem("A1");
        assertNotNull(item1);

        VendingMachine item2 = service.getItem("A3");
        assertNull(item2);
    }

}
    

