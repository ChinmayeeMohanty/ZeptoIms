package com.cm.zepto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cm.zepto.model.Order;
import com.cm.zepto.model.Payments;
import com.cm.zepto.repo.OrderRepository;
import com.cm.zepto.repo.PaymentRepository;

@Service
public class PaymentsService {

	@Autowired
	private PaymentRepository paymentRepo;
	
	@Autowired
	private OrderRepository orderRepo;
	
	
	public Payments makePayment(int orderId,String method,String txnId)
	{
		Order order=orderRepo.findById(orderId).orElseThrow();
		Payments payment=new Payments();
		payment.setOrders(order);
		payment.setPaymentMethod(method);
		payment.setTransactionId(txnId);
		payment.setPaymentStatus("SUCCESS");
		payment.setPaymentDate(java.time.LocalDateTime.now());
		return paymentRepo.save(payment);
	}
}
