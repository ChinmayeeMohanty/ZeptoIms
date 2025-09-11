package com.cm.zepto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cm.zepto.model.Cart;
import com.cm.zepto.repo.CartRepo;

@Service
public class CartService  {
	
	@Autowired
	private CartRepo cartRepo ;
	
	public Cart addToCart(Cart cart)
	{
		return cartRepo.save(cart);
	}
	
	public List<Cart> getUserCart(int userId) {
	    return cartRepo.findByUserUserId(userId);
	}

	public void removeFromCart(int cartId)
	{
		cartRepo.deleteById(cartId);
	}
}
