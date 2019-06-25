/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine.dto;

import java.math.BigDecimal;

/**
 *
 * @author kevinyeung
 */
public enum Currency {
    DOLLAR50(new BigDecimal("50.00"), "Dollars"),
    DOLLAR20(new BigDecimal("20.00"), "Dollars"),
    DOLLAR10(new BigDecimal("10.00"), "Dollars"),
    DOLLAR5(new BigDecimal("5.00"), "Dollars"),
    DOLLAR1(new BigDecimal("1.00"), "Dollar/s"),
    QUATER(new BigDecimal("0.25"), "Quater/s"),
    DIME(new BigDecimal("0.10"), "Dime/s"),
    NICKEL(new BigDecimal("0.05"), "Nickel/s"),
    PENNY(new BigDecimal("0.01"), "Penny/ies");

    BigDecimal currencyId;
    String description;

    Currency(BigDecimal currencyId, String description) {
        this.currencyId = currencyId;
        this.description = description;
    }

    public BigDecimal getCurrencyId() {
        return currencyId;
    }

    public String getDescription() {
        return description;
    }
}
