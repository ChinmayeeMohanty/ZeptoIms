package com.cm.zepto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cm.zepto.model.Cart;
import com.cm.zepto.model.Product;
import com.cm.zepto.model.User;
import com.cm.zepto.repo.CartRepo;
import com.cm.zepto.repo.ProductRepository;
import com.cm.zepto.repo.ProductsRepository;
import com.cm.zepto.repo.UserRepository;

@Service
public class CartService  {
	
	@Autowired
	private CartRepo cartRepo ;
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private ProductsRepository productRepo;
	
	public Cart addToCart(int userId,int productId,int quantity )
	{
		User user=userRepo.findById(userId).orElseThrow(()->new RuntimeException("User not found"));
		Product product=productRepo.findById(productId).orElseThrow(()->new RuntimeException("Product not found"));
		Cart cart=new Cart();
		cart.setUser(user);
		cart.setProduct(product);
		cart.setQuantity(quantity);
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
