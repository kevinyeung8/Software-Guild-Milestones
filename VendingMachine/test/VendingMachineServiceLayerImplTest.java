/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import vendingmachine.dao.VendingMachineDao;
import vendingmachine.dao.VendingMachineDaoStubImpl;
import vendingmachine.dao.VendingMachinePersistenceException;
import vendingmachine.dto.VendingMachine;


/**
 *
 * @author kevinyeung
 */
public class VendingMachineServiceLayerImplTest {
    
      VendingMachineDao dao;
    
    public VendingMachineServiceLayerImplTest() throws VendingMachinePersistenceException {
        dao = new VendingMachineDaoStubImpl();
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
     * Test of updateItem method, of class VendingMachineDaoFileImpl.
     */
    @Test
    public void testUpdateItem() throws Exception {
        VendingMachine item1 = dao.getItem("A1");
        int before = item1.getInventory() - 1;
        dao.updateItem(item1.getItemID());
        assertEquals(before, item1.getInventory());
    }

    /**
     * Test of getAllItems method, of class VendingMachineDaoFileImpl.
     */
    @Test
    public void testGetAllItems() throws Exception {
        assertEquals(2, dao.getAllItems().size());
    }

    /**
     * Test of getItem method, of class VendingMachineDaoFileImpl.
     */
    @Test
    public void testGetItem() throws Exception {
        VendingMachine item1 = dao.getItem("A1");
        VendingMachine item2 = dao.getItem("A1");
        assertEquals(item1.getItemID(), item2.getItemID());
    }
    
}

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
