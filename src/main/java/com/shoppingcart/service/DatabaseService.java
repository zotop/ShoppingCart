package com.shoppingcart.service;


import com.shoppingcart.model.CartItemDto;
import com.shoppingcart.model.Product;
import com.shoppingcart.model.ShoppingCart;
import com.shoppingcart.model.ShoppingCartItem;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.ObjectMapper;
import org.mapdb.DBMaker;
import org.mapdb.HTreeMap;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentNavigableMap;

/**
 * Service for manipulating the Products and Shopping Carts
 */
public class DatabaseService {

    private static HTreeMap<String, Product> productMap = DBMaker.newTempHashMap();
    private static HTreeMap<String, ShoppingCart> shoppingCartMap = DBMaker.newTempHashMap();

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

    public static void saveShoppingCart(ShoppingCart shoppingCart) {
        shoppingCartMap.put(shoppingCart.getId(), shoppingCart);
    }

    public static void deleteShoppingCart(String shoppingCartId) {
        shoppingCartMap.remove(shoppingCartId);
    }

    public static List<ShoppingCart> getShoppingCartList() {
        return new ArrayList<>(shoppingCartMap.values());
    }

    public static ShoppingCart getShoppingCart(String shoppingCartId) {
        return shoppingCartMap.get(shoppingCartId);
    }

    public static void updateShoppingCart(String shoppingCartId, CartItemDto cartItemDto) throws IOException {
        ShoppingCart shoppingCart = getShoppingCart(shoppingCartId);
        Product product = DatabaseService.getProduct(cartItemDto.getProductId());
        Double quantity = cartItemDto.getQuantity();
        shoppingCart.addItem(new ShoppingCartItem(product, quantity));
        shoppingCartMap.put(shoppingCartId, shoppingCart);
    }
}
