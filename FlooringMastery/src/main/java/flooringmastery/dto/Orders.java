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
public class Orders {
    private String OrderNumber;
    private String CustomerName;
    private String State;
    private BigDecimal TaxRate;
    private String ProductType;
    private BigDecimal Area;
    private BigDecimal CostPerSquareFoot;
    private BigDecimal LaborCostPerSquareFoot;
    private BigDecimal MaterialCost;
    private BigDecimal LaborCost;
    private BigDecimal Tax;
    private BigDecimal Total;
    
    public Orders(String OrderNumber) {
        this.OrderNumber = OrderNumber;
    }

    public String getOrderNumber() {
        return OrderNumber;
    }
    
    public void setOrderNumber(String OrderNumber){
        this.OrderNumber = OrderNumber;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String CustomerName) {
        this.CustomerName = CustomerName;
    }

    public String getState() {
        return State;
    }

    public void setState(String State) {
        this.State = State;
    }

    public BigDecimal getTaxRate() {
        return TaxRate;
    }

    public void setTaxRate(BigDecimal TaxRate) {
        this.TaxRate = TaxRate;
    }

    public String getProductType() {
        return ProductType;
    }

    public void setProductType(String ProductType) {
        this.ProductType = ProductType;
    }

    public BigDecimal getArea() {
        return Area;
    }

    public void setArea(BigDecimal Area) {
        this.Area = Area;
    }

    public BigDecimal getCostPerSquareFoot() {
        return CostPerSquareFoot;
    }

    public void setCostPerSquareFoot(BigDecimal CostPerSquareFoot) {
        this.CostPerSquareFoot = CostPerSquareFoot;
    }

    public BigDecimal getLaborCostPerSquareFoot() {
        return LaborCostPerSquareFoot;
    }

    public void setLaborCostPerSquareFoot(BigDecimal LaborCostPerSquareFoot) {
        this.LaborCostPerSquareFoot = LaborCostPerSquareFoot;
    }

    public BigDecimal getMaterialCost() {
        return MaterialCost;
    }

    public void setMaterialCost(BigDecimal MaterialCost) {
        this.MaterialCost = MaterialCost;
    }

    public BigDecimal getLaborCost() {
        return LaborCost;
    }

    public void setLaborCost(BigDecimal LaborCost) {
        this.LaborCost = LaborCost;
    }

    public BigDecimal getTax() {
        return Tax;
    }

    public void setTax(BigDecimal Tax) {
        this.Tax = Tax;
    }

    public BigDecimal getTotal() {
        return Total;
    }

    public void setTotal(BigDecimal Total) {
        this.Total = Total;
    }
    
    @Override
    public String toString() {
        return "OrderNumber: " + OrderNumber + " |CostumerName: " + CustomerName +
                " |State: " + State + " |ProductType: " + ProductType + " |Area: " + Area +
                " |Tax: " + Tax +" |Total: " + Total;
    }
}