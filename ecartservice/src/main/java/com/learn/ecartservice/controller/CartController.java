package com.learn.ecartservice.controller;

import com.learn.ecartservice.entity.Cart;
import com.learn.ecartservice.exception.InvalidcartIdException;
import com.learn.ecartservice.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/carts")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping
    public ResponseEntity<Cart> saveCart(@RequestBody Cart cart) {
        Cart savedCart = cartService.saveCart(cart);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCart);
    }

    @GetMapping("/email/{emailId}")
    public ResponseEntity<Cart> getCartByEmail(@PathVariable String emailId) {
        Cart cart = cartService.getCartByEmail(emailId);
        if (cart == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(cart);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Cart>> getAllCarts() {
        List<Cart> carts = cartService.getAllCart();
        return ResponseEntity.status(HttpStatus.OK).body(carts);
    }

    @GetMapping("/{cartId}")
    public ResponseEntity<Cart> getCartById(@PathVariable Integer cartId) throws InvalidcartIdException {
        Cart cart = cartService.getCartById(cartId);
        return ResponseEntity.status(HttpStatus.OK).body(cart);
    }
}
