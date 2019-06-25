/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shoemanager.view;

/**
 *
 * @author kevinyeung
 */
public interface UserIO {
     void Display (String message);
     String PromptUser(String message);
     int PromptUserInt(String message);

    public void print(String foot_Locker);

    public void readInt(String string, int i, int i0);

    public String readString(String please_enter_the_Shoe_Sku_);
}
