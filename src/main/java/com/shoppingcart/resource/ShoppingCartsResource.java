package com.shoppingcart.resource;


import com.shoppingcart.model.CartItemDto;
import com.shoppingcart.model.Product;
import com.shoppingcart.model.ShoppingCart;
import com.shoppingcart.model.ShoppingCartItem;
import com.shoppingcart.service.DatabaseService;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.ObjectMapper;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.io.IOException;
import java.net.URI;
import java.util.List;

/**
 *
 */

@Path("carts")
public class ShoppingCartsResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getShoppingCartList() throws IOException {
        return new ObjectMapper().writeValueAsString(DatabaseService.getShoppingCartList());
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createCart(ShoppingCart shoppingCart, @Context UriInfo uriInfo) {
        DatabaseService.saveShoppingCart(shoppingCart);
        URI uri = uriInfo.getAbsolutePathBuilder().path(shoppingCart.getId()).build();
        return Response.created(uri).build();
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteCart(@PathParam("id") String cartId) {
        if(DatabaseService.getShoppingCart(cartId) == null) {
            throw new NotFoundException();
        }
        DatabaseService.deleteShoppingCart(cartId);

        return Response.ok().build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getCart(@PathParam("id") String cartId) throws IOException {
        ShoppingCart shoppingCart = DatabaseService.getShoppingCart(cartId);
        if(shoppingCart == null) {
            throw new NotFoundException();
        }
        return new ObjectMapper().writeValueAsString(shoppingCart);
    }


    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addCartItem(@PathParam("id") String cartId, CartItemDto cartItemDto, @Context UriInfo uriInfo) throws IOException {
        if(DatabaseService.getShoppingCart(cartId) == null) {
            throw new NotFoundException();
        }
        DatabaseService.updateShoppingCart(cartId, cartItemDto);
        URI uri = uriInfo.getAbsolutePathBuilder().path(cartId).build();
        return Response.noContent().location(uri).build();
    }
}
