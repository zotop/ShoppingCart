package com.shoppingcart.model;

import com.shoppingcart.service.DatabaseService;
import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonUnwrapped;

import java.io.Serializable;

/**
 *
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class ShoppingCartItem implements Serializable {


    private final Product product;

    private final Double quantity;


    public ShoppingCartItem(Product product, Double quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    @JsonProperty("product")
    @JsonUnwrapped
    public Product getProduct() {
        return product;
    }

    @JsonProperty("quantity")
    public Double getQuantity() {
        return quantity;
    }

    @JsonProperty("priceIncVatAmount")
    public Double getPriceIncVatAmount()
    {
        return quantity * product.getPriceIncVat();
    }

    @JsonProperty("vatAmount")
    public Double getVatAmount() {
        return quantity * product.getVatAmount();
    }
}
