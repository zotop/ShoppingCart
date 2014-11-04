package com.shoppingcart.model;



import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 */

public class CartItemDto {


    private String productId;

    private Double quantity;


    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }


    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }
}
