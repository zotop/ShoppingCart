package com.shoppingcart.model;


import java.io.Serializable;

/**
 * Product representation
 */

public class Product implements Serializable {
    private String id;
    private String name;
    private Double priceIncVat;
    private Double vatPercentage;
    private Double vatAmount;


    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getPriceIncVat() {
        return priceIncVat;
    }

    public Double getVatPercentage() {
        return vatPercentage;
    }

    public Double getVatAmount() {
        return priceIncVat * vatPercentage;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPriceIncVat(Double priceIncVat) {
        this.priceIncVat = priceIncVat;
    }

    public void setVatPercentage(Double vatPercentage) {
        this.vatPercentage = vatPercentage;
    }

}
