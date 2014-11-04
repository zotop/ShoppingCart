package com.shoppingcart.resource;

import com.shoppingcart.model.Product;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.type.TypeFactory;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Testing of the Products resource
 */
public class ProductsResourceTest extends JerseyTest {

    @Override
    protected Application configure() {
        return new ResourceConfig(ProductsResource.class);
    }

    @Test
    public void create_product() {
        Product product = initProduct();
        Response response = createProduct(product);
        assertEquals(response.getStatus(), 201);
    }

    @Test
    public void get_product() {
        Product product = initProduct();
        createProduct(product);
        Product productResponse = target().path("products/1").request().get().readEntity(Product.class);
        assertEquals(productResponse.getName(), "Bread");
    }

    @Test
    public void update_product() {
        Product product = initProduct();
        createProduct(product);
        product.setName("Milk");
        Entity<Product> productEntity = Entity.entity(product, MediaType.APPLICATION_JSON_TYPE);
        target().path("products/1").request().put(productEntity);
        Product productResponse = target().path("products/1").request().get().readEntity(Product.class);
        assertEquals(productResponse.getName(), "Milk");

    }

    @Test
    public void delete_product() throws IOException {
        Product product = initProduct();
        createProduct(product);
        product.setId("2");
        createProduct(product);
        target().path("products/1").request().delete();
        String jsonResponse = target().path("products").request().get().readEntity(String.class);
        ObjectMapper mapper = new ObjectMapper();
        List<Product> productList = mapper.readValue(jsonResponse, TypeFactory.defaultInstance().constructCollectionType(List.class, Product.class));
        assertEquals(productList.size(), 1);
        assertEquals(productList.get(0).getId(), "2");

    }

    @Test
    public void get_product_list() throws IOException {
        Product product = initProduct();
        createProduct(product);
        product.setId("2");
        createProduct(product);
        String jsonResponse = target().path("products").request().get().readEntity(String.class);
        ObjectMapper mapper = new ObjectMapper();
        List<Product> productList = mapper.readValue(jsonResponse, TypeFactory.defaultInstance().constructCollectionType(List.class, Product.class));
        assertEquals(productList.size(), 2);
        assertEquals(productList.get(0).getId(), "1");
        assertEquals(productList.get(1).getId(), "2");
    }

    private Response createProduct(Product product) {
        Entity<Product> productEntity = Entity.entity(product, MediaType.APPLICATION_JSON_TYPE);
        return target().path("products").request().post(productEntity);
    }

    private Product initProduct() {
        Product product = new Product();
        product.setId("1");
        product.setName("Bread");
        product.setPriceIncVat(10.0);
        product.setVatPercentage(0.25);
        return product;
    }
}
