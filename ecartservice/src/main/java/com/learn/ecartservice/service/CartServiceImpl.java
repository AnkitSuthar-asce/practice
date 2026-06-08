package com.learn.ecartservice.service;

import com.learn.ecartservice.entity.Cart;
import com.learn.ecartservice.exception.InvalidcartIdException;
import com.learn.ecartservice.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Override
    public Cart saveCart(Cart cart) {
        return cartRepository.save(cart);
    }

    @Override
    public Cart getCartByEmail(String emailId) {
        return cartRepository.findByEmailId(emailId).orElse(null);
    }

    @Override
    public List<Cart> getAllCart() {
        return cartRepository.findAll();
    }

    @Override
    public Cart getCartById(Integer cartId) throws InvalidcartIdException {
        return cartRepository.findById(String.valueOf(cartId))
                .orElseThrow(() -> new InvalidcartIdException("invalid cart id"));
    }
}
