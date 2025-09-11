package com.cm.zepto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cm.zepto.model.Cart;
import com.cm.zepto.service.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {

   @Autowired
   private CartService cartService;
   
   @PostMapping("/add")
   public Cart addToCart(@RequestBody Cart cart)
   {
	   return cartService.addToCart(cart);
   }
   
   @GetMapping("/user/{userId}")
   public List<Cart> getCartItems(@PathVariable int userId)
   {
	   return cartService.getUserCart(userId);
   }
   
   
}
