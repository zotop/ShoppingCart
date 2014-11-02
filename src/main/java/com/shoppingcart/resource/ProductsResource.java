package com.shoppingcart.resource;

import com.shoppingcart.model.Product;
import com.shoppingcart.service.DatabaseService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Products resource
 */

@Path("products")
public class ProductsResource {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String createProduct(Product product) {
        DatabaseService.saveProduct(product);
        return "Product Created";
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> getProductList() {
        return DatabaseService.getProductList();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Product getProduct(@PathParam("id") String productId) {
        return DatabaseService.getProduct(productId);
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateProduct(@PathParam("id") String productId, Product product) {
        DatabaseService.saveProduct(product);
    }


    @DELETE
    @Path("{id}")
    public void deleteProduct(@PathParam("id") String productId) {
        DatabaseService.deleteProduct(productId);
    }

}
