package com.cm.zepto.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
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
   public Cart addToCart(@RequestBody Map<String,Object> payLoad)
   {
	   int userId=(int)payLoad.get("userId");
	   int productId=(int)payLoad.get("productId");
	   int quantity=(int)payLoad.get("quantity");
	   return cartService.addToCart(userId,productId,quantity);
   }
   
   @GetMapping("/user/{userId}")
   public List<Cart> getCartItems(@PathVariable int userId)
   {
	   return cartService.getUserCart(userId);
   }
   
   @DeleteMapping("/{cartId}")
   public String removeCart(@PathVariable int cartId)
   {
	   cartService.removeFromCart(cartId);
	   return "Cart delete successfully";
   }
   
}
