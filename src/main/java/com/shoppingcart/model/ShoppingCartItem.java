package com.shoppingcart.model;




import org.codehaus.jackson.annotate.JsonUnwrapped;

import java.io.Serializable;

/**
 * Representation of the products added to a cart and its quantity
 */

public class ShoppingCartItem implements Serializable {
    private String id;
    private String name;
    private Double priceIncVat;
    private Double vatPercentage;
    private Double vatAmount;
    private Double quantity;

    public ShoppingCartItem(Product product, Double quantity) {
        this.id = product.getId();
        this.name = product.getName();
        this.priceIncVat = product.getPriceIncVat();
        this.vatPercentage = product.getVatPercentage();
        this.quantity = quantity;
        this.vatAmount = this.priceIncVat * this.vatPercentage * quantity;

    }

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
        return vatAmount;
    }

    public void setVatAmount(Double vatAmount) {
        this.vatAmount = vatAmount;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }
}

