/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shoemanager.dao;

import java.util.List;
import shoemanager.dto.Shoe;

/**
 *
 * @author kevinyeung
 */
public interface ShoeDao {
    //CRRUD 
    
//    //Create
//    public Shoe create(Shoe shoe);
//    //ReadAll
//    public List<Shoe> readAll(); //array list
//    //ReadById
//    public Shoe readById(int id);
//    //Update
//    public void update(int id, Shoe shoe);
//    //Delete
//    public void delete(int id);
    
    

    public void removeShoe(String removeShoe);

    public void editShoe(Shoe editShoe);

    public List<Shoe> getAllShoes();

    public Shoe getDiskBySku(String shoeSku);

    public Shoe getDiskByName(String shoeName);
    
}
