package com.shoppingcart.resource;

import com.shoppingcart.model.Product;
import com.shoppingcart.model.ShoppingCart;
import com.shoppingcart.service.DatabaseService;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static org.junit.Assert.assertEquals;

/**
 *
 */
public class ShoppingCartsResourceTest extends JerseyTest {

    @Override
    protected Application configure() {
        return new ResourceConfig(ShoppingCartsResource.class);
    }

    @Test
    public void create_shopping_cart() {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setId("1");
        DatabaseService.saveShoppingCart(shoppingCart);
        Response response = target().path("products").request().get();
        assertEquals(response.getStatus(), 200);

    }
}
