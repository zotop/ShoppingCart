package com.shoppingcart.model;




import org.codehaus.jackson.annotate.JsonUnwrapped;

import java.io.Serializable;

/**
 * Representation of the products added to a cart and its quantity
 */

public class ShoppingCartItem implements Serializable {
    private final Product product;
    private final Double quantity;

    public ShoppingCartItem(Product product, Double quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    @JsonUnwrapped
    public Product getProduct() {
        return product;
    }

    public Double getQuantity() {
        return quantity;
    }

    public Double getPriceIncVatAmount()
    {
        return quantity * product.getPriceIncVat();
    }

    public Double getVatAmount() {
        return quantity * product.getVatAmount();
    }
}
