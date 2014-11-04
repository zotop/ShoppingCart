package com.shoppingcart.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Shopping Cart
 */

public class ShoppingCart implements Serializable {

    private String id;
    private Double totalPriceIncVatAmount;
    private Double totalVatAmount;
    private List<ShoppingCartItem> rows = new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getTotalVatAmount() {
        totalVatAmount = 0.0;
        for(ShoppingCartItem shoppingCartItem : rows) {
            totalVatAmount += shoppingCartItem.getQuantity() * shoppingCartItem.getProduct().getVatAmount() ;
        }

        return totalVatAmount;
    }


    public Double getTotalPriceIncVatAmount() {
        totalPriceIncVatAmount = 0.0;
        for(ShoppingCartItem shoppingCartItem : rows) {
            totalPriceIncVatAmount += shoppingCartItem.getQuantity() * shoppingCartItem.getProduct().getPriceIncVat();
        }
        return totalPriceIncVatAmount;
    }

    public List<ShoppingCartItem> getRows() {
        return rows;
    }

    public void addItem(ShoppingCartItem shoppingCartItem) {
        rows.add(shoppingCartItem);
    }

}
