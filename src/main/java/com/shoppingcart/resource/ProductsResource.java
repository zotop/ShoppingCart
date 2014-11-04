package com.shoppingcart.resource;

import com.shoppingcart.model.Product;
import com.shoppingcart.service.DatabaseService;
import com.sun.jmx.remote.internal.Unmarshal;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.ObjectMapper;

import javax.ws.rs.*;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.io.IOException;
import java.net.URI;
import java.util.List;

/**
 * Products resource
 */

@Path("products")
public class ProductsResource {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createProduct(Product product, @Context UriInfo uriInfo) {
        DatabaseService.saveProduct(product);
        URI uri = uriInfo.getAbsolutePathBuilder().path(product.getId()).build();
        return Response.created(uri).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getProductList() throws IOException {
        return new ObjectMapper().writeValueAsString(DatabaseService.getProductList());
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getProduct(@PathParam("id") String productId) throws IOException {
        Product product = DatabaseService.getProduct(productId);
        if(product == null) {
            throw new NotFoundException();
        }

        return new ObjectMapper().writeValueAsString(product);
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateProduct(@PathParam("id") String productId, Product product, @Context UriInfo uriInfo) {
        if(DatabaseService.getProduct(productId) == null) {
            throw new NotFoundException();
        }
        DatabaseService.saveProduct(product);
        URI uri = uriInfo.getAbsolutePathBuilder().path(productId).build();
        return Response.noContent().location(uri).build();
    }


    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteProduct(@PathParam("id") String productId) {
        if(DatabaseService.getProduct(productId) == null) {
            throw new NotFoundException();
        }
        DatabaseService.deleteProduct(productId);
        return Response.ok().build();
    }

}
