package com.shoppingcart.model;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 *
 */
public class CartItemDto {


    private String productId;

    private Double quantity;

    @JsonProperty("productId")
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    @JsonProperty("quantity")
    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }
}
