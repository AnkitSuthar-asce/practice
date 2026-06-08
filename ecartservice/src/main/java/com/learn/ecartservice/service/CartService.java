package com.learn.ecartservice.service;

import com.learn.ecartservice.entity.Cart;
import com.learn.ecartservice.exception.InvalidcartIdException;
import java.util.List;

public interface CartService {

    Cart saveCart(Cart cart);
    Cart getCartByEmail(String emailId);
    List<Cart> getAllCart();
    Cart getCartById(Integer cartId) throws InvalidcartIdException;
}
