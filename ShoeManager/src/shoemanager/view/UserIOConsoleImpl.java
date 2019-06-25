/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shoemanager.view;

import java.util.Scanner;


public class UserIOConsoleImpl implements UserIO {

    @Override
    public void Display(String message) {
        System.out.println("message");
    }

    @Override
    public String PromptUser(String message) {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    @Override
    public int PromptUserInt(String message) {
        String userInput = PromptUser(message);     
        return Integer.parseInt(userInput);
        
    }
    
}
