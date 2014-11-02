package com.shoppingcart.model;


import java.io.Serializable;

/**
 * Product representation
 */
public class Product implements Serializable, Comparable {

    private String id;
    private String name;
    private Double priceIncVat;
    private Double vatPercentage;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPriceIncVat() {
        return priceIncVat;
    }

    public void setPriceIncVat(Double priceIncVat) {
        this.priceIncVat = priceIncVat;
    }

    public Double getVatPercentage() {
        return vatPercentage;
    }

    public void setVatPercentage(Double vatPercentage) {
        this.vatPercentage = vatPercentage;
    }

    public Double getVatAmount() {
        return priceIncVat * vatPercentage;
    }

    @Override
    public int compareTo(Object product) {
       Product p = (Product) product;
       return getName().compareTo(p.getName());
    }
}
