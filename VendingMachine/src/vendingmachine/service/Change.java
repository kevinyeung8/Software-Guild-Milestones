/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine.service;

import java.math.BigDecimal;
import java.math.MathContext;
import vendingmachine.dto.Currency;

/**
 *
 * @author kevinyeung
 */
public class Change {

    public String getChange(BigDecimal itemCost, BigDecimal cash) {

        BigDecimal cashBack = new BigDecimal(cash.toString());
        MathContext mc = new MathContext(4); // 2 precision

        String rs = "";
        int dollar50 = 0, dollar20 = 0, dollar10 = 0, dollar5 = 0, dollar1 = 0,
                quater = 0, dime = 0, nickel = 0, penny = 0;

        do {
            if (cashBack.compareTo(Currency.DOLLAR50.getCurrencyId()) > 0) {

                cashBack = cashBack.remainder(Currency.DOLLAR50.getCurrencyId(), mc);
                dollar50++;

            } else if (cashBack.compareTo(Currency.DOLLAR20.getCurrencyId()) > 0) {

                cashBack = cashBack.subtract(Currency.DOLLAR20.getCurrencyId(), mc);
                dollar20++;

            } else if (cashBack.compareTo(Currency.DOLLAR10.getCurrencyId()) > 0) {

                cashBack = cashBack.subtract(Currency.DOLLAR10.getCurrencyId(), mc);
                dollar10++;

            } else if (cashBack.compareTo(Currency.DOLLAR5.getCurrencyId()) > 0) {

                cashBack = cashBack.remainder(Currency.DOLLAR5.getCurrencyId(), mc);
                dollar5++;

            } else if (cashBack.compareTo(Currency.DOLLAR1.getCurrencyId()) > 0
                    || cashBack.compareTo(Currency.DOLLAR1.getCurrencyId()) == 0) {

                cashBack = cashBack.subtract(Currency.DOLLAR1.getCurrencyId(), mc);
                dollar1++;

            } else if (cashBack.compareTo(Currency.QUATER.getCurrencyId()) > 0) {

                cashBack = cashBack.subtract(Currency.QUATER.getCurrencyId(), mc);
                quater++;

            } else if (cashBack.compareTo(Currency.DIME.getCurrencyId()) > 0) {

                cashBack = cashBack.subtract(Currency.DIME.getCurrencyId(), mc);
                dime++;

            } else if (cashBack.compareTo(Currency.NICKEL.getCurrencyId()) > 0) {

                cashBack = cashBack.remainder(Currency.NICKEL.getCurrencyId(), mc);
                nickel++;

            } else if (cashBack.compareTo(Currency.PENNY.getCurrencyId()) > 0
                    || cashBack.compareTo(Currency.PENNY.getCurrencyId()) == 0) {

                cashBack = cashBack.subtract(new BigDecimal("0.01"));
                penny++;

            }

        } while (cashBack.compareTo(new BigDecimal("0")) > 0);

        //Return change
        if (dollar50 != 0) {
            rs += "50 Dollars Bills : " + dollar50;
        }
        if (dollar20 != 0) {
            rs += "\n20 Dollars Bills : " + dollar20;
        }
        if (dollar10 != 0) {
            rs += "\n10 Dollars Bills : " + dollar10;
        }
        if (dollar5 != 0) {
            rs += "\n5 Dollars Bills : " + dollar5;
        }
        if (dollar1 != 0) {
            rs += "\n1 Dollar Bills : " + dollar1;
        }
        if (quater != 0) {
            rs += "\nQuater/s : " + quater;
        }
        if (dime != 0) {
            rs += "\nDime/s : " + dime;
        }
        if (nickel != 0) {
            rs += "\nNickel/s : " + nickel;
        }
        if (penny != 0) {
            rs += "\nPenny/ies : " + penny;
        }

        return rs;
    }
}
