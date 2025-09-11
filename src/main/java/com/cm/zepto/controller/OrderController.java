package com.cm.zepto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cm.zepto.model.Order;
import com.cm.zepto.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@PostMapping("/place/{userId}")
	public Order placeOrder(@PathVariable int userId)
	{
		return orderService.placeOrder(userId);
	}
	
}
