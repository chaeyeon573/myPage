package com.example.myPage.Controller;

import com.example.myPage.Entity.CartItems;
import com.example.myPage.Service.CartItemsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users/carts")
public class CartItemsController {
    private final CartItemsService cartItemsService;

    public CartItemsController(CartItemsService cartItemsService) {
        this.cartItemsService = cartItemsService;
    }

    @GetMapping("/{userId}")
    public List<CartItems> getCartItemsByUserId(@PathVariable Long userId) {
        return cartItemsService.getCartItemsByUserId(userId);
    }
}

