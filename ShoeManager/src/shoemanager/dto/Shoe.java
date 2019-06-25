/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shoemanager.dto;

/**
 *
 * @author kevinyeung
 */
public class Shoe {
    private int id;
    private final String shoeSku;
    private String releaseDate;

    public Shoe(String shoeSku) {
        this.shoeSku = shoeSku;

    public String getShoeSku() {
        return shoeSku;
    }

    public void setShoeSku(String shoeSku) {
        this.shoeSku = shoeSku;
    }
    
    public String getReleaseDate() {
        String releaseDate = null;
        return releaseDate;
    }
    
    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }
    
    public String getShoeBrand();
        return shoeBrand;
    
    public String getShoeStyle();
        return shoeStyle;
}
