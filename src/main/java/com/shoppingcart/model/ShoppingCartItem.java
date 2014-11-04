package com.shoppingcart.model;




import java.io.Serializable;

/**
 *
 */

public class ShoppingCartItem implements Serializable {
    private final Product product;
    private final Double quantity;

    public ShoppingCartItem(Product product, Double quantity) {
        this.product = product;
        this.quantity = quantity;
    }

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
