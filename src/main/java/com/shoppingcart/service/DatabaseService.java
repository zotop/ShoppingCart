package com.shoppingcart.service;

import com.shoppingcart.model.Product;
import org.mapdb.DBMaker;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentNavigableMap;

/**
 * Service for manipulating the Products and Shopping Carts
 */
public class DatabaseService {

    private static ConcurrentNavigableMap<String, Product> productMap = DBMaker.newTempTreeMap();

    //insert or overwrite existing product
    public static void saveProduct(Product product) {
        productMap.put(product.getId(), product);
    }

    public static Product getProduct(String productId) {
        return productMap.get(productId);
    }

    public static void deleteProduct(String productId) {
        productMap.remove(productId);
    }

    public static List<Product> getProductList() {
        return new ArrayList<>(productMap.values());
    }

}
