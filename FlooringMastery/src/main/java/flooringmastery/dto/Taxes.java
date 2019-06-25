/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flooringmastery.dto;

import java.math.BigDecimal;

/**
 *
 * @author kevinyeung
 */
public class Taxes {
    
    private String State;
    private BigDecimal TaxRate;

    public String getState() {
        return State;
    }

    public BigDecimal getTaxRate() {
        return TaxRate;
    }

    public void setState(String State) {
        this.State = State;
    }

    public void setTaxRate(BigDecimal TaxRate) {
        this.TaxRate = TaxRate;
    }
}
