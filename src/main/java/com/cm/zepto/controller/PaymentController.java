package com.cm.zepto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cm.zepto.model.Payments;
import com.cm.zepto.service.PaymentsService;

@RestController
@RequestMapping("/payment")
public class PaymentController {

	@Autowired
	private PaymentsService paymentService;
	
	
	@PostMapping("/pay/{orderId}")
	public Payments pay(@PathVariable int orderId,@RequestParam String method,@RequestParam String txnId )
	{
		return paymentService.makePayment(orderId, method, txnId);
	}
	
}