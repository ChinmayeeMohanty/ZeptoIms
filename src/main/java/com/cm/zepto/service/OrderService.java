package com.cm.zepto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cm.zepto.model.Cart;
import com.cm.zepto.model.Order;
import com.cm.zepto.repo.CartRepo;
import com.cm.zepto.repo.OrderRepository;

@Service
public class OrderService {
@Autowired
private OrderRepository orderRepository;
@Autowired
private CartRepo cartRepo;

public Order placeOrder(int uid)
{
	List<Cart> cartItems= cartRepo.findAll().stream().filter(c->c.getUser().getUserId()==uid).toList();
	double total=cartItems.stream().mapToDouble(c->c.getProduct().getPrice()*c.getQuantity()).sum();
	Order order=new Order();
	order.setUser(cartItems.get(0).getUser());
	order.setAmount(total);
	order.setStatus("PENDING");
	order.setOrderDate(java.time.LocalDateTime.now());
	return orderRepository.save(order);
	
}

}
