/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine.ui;

import static java.lang.Integer.parseInt;
import java.util.Scanner;

/**
 *
 * @author kevinyeung
 */
public class UserIOConsoleImpl implements UserIO {
    Scanner mySc = new Scanner(System.in);
    
    @Override
    public void print(String message) {
        System.out.println(message);
    }

    @Override
    public double readDouble(String prompt) {
        double number;
        System.out.println(prompt);
        number = parseInt(mySc.nextLine());
        return number;
    }

    @Override
    public double readDouble(String prompt, double min, double max) {
        double number;
        System.out.println(prompt+" Number entered must be between "+min+" and "+max);
        do{
          number = parseInt(mySc.nextLine());  
        }while(number < min && number > max);
        return number;
    }

    @Override
    public float readFloat(String prompt) {
        float number;
        System.out.println(prompt);
        number = parseInt(mySc.nextLine());
        return number;
    }

    @Override
    public float readFloat(String prompt, float min, float max) {
        float number;
        System.out.println(prompt+" Number entered must be between "+min+" and "+max);
        do{
          number = parseInt(mySc.nextLine());  
        }while(number < min && number > max);
        return number;
    }

    @Override
    public int readInt(String prompt) {
        int number;
        System.out.println(prompt);
        number = parseInt(mySc.nextLine());
        return number;
    }

    @Override
    public int readInt(String prompt, int min, int max) {
        int number;
        System.out.println(prompt+" Number entered must be between "+min+" and "+max);
        do{
          number = parseInt(mySc.nextLine());  
        }while(number < min && number > max);
        return number;
    }

    @Override
    public long readLong(String prompt) {
        long number;
        System.out.println(prompt);
        number = parseInt(mySc.nextLine());
        return number;
    }

    @Override
    public long readLong(String prompt, long min, long max) {
        long number;
        System.out.println(prompt+" Number entered must be between "+min+" and "+max);
        do{
          number = parseInt(mySc.nextLine());  
        }while(number < min && number > max);
        return number;
    }

    @Override
    public String readString(String prompt) {
        String cadena;
        System.out.println(prompt);
        cadena = mySc.nextLine();
        return cadena;
    }
}