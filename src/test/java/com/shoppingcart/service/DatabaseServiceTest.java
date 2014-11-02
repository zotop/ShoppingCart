package com.shoppingcart.service;

import com.shoppingcart.model.Product;

import org.junit.Before;
import org.junit.Test;
import java.util.List;


import static org.junit.Assert.assertEquals;

/**
 *
 */
public class DatabaseServiceTest {

    private Product product;

    @Before
    public void setup() {
        initProduct();
        DatabaseService.saveProduct(product);
    }

    private void initProduct() {
        product = new Product();
        product.setId("1");
        product.setName("Bread");
        product.setPriceIncVat(10.0);
        product.setVatPercentage(0.25);
    }

    @Test
    public void insert_product() {
        List<Product> productList = DatabaseService.getProductList();
        assertEquals(productList.size(), 1);
        assertEquals(productList.get(0).getName(), "Bread");
    }

    @Test
    public void getProduct() {
        Product product = DatabaseService.getProduct("1");
        assertEquals(product.getId(), "1");
        assertEquals(product.getName(), "Bread");
    }

    @Test
    public void update_product() {
        product.setName("Milk");
        DatabaseService.saveProduct(product);
        Product updatedProduct = DatabaseService.getProduct(product.getId());
        assertEquals(updatedProduct.getId(), "1");
        assertEquals(updatedProduct.getName(), "Milk");
    }

    @Test
    public void delete_product() {
        DatabaseService.deleteProduct(product.getId());
        List<Product> productList = DatabaseService.getProductList();
        assertEquals(productList.size(), 0);
    }

}
