package com.cm.zepto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cm.zepto.model.Cart;
import com.cm.zepto.model.Order;
import com.cm.zepto.model.Payments;
import com.cm.zepto.model.Product;
import com.cm.zepto.repo.CartRepo;
import com.cm.zepto.repo.OrderRepository;
import com.cm.zepto.repo.PaymentRepository;
import com.cm.zepto.repo.ProductsRepository;

import jakarta.transaction.Transactional;

@Service
public class PaymentsService {

	@Autowired
	private PaymentRepository paymentRepo;
	
	@Autowired
	private OrderRepository orderRepo;
	
	@Autowired
	private CartRepo cartRepo;
	
	@Autowired
	private ProductsRepository productRepo;
	
	@Transactional
	public Payments makePayment(int orderId,String method,String txnId)
	{
		Order order=orderRepo.findById(orderId).orElseThrow();
		Payments payment=new Payments();
		payment.setOrders(order);
		payment.setPaymentMethod(method);
		payment.setTransactionId(txnId);
		payment.setPaymentStatus("SUCCESS");
		payment.setPaymentDate(java.time.LocalDateTime.now());
		Payments savedPayment= paymentRepo.save(payment);
		
		//Order Placed Successfully
		order.setStatus("PAID");
		orderRepo.save(order);
		
		//Reduce Stocks
		List<Cart> cartItems=cartRepo.findByUserUserId(order.getUser().getUserId());
		
		for(Cart  cart:cartItems)
		{
			Product product =cart.getProduct();
			int newStock=product.getStocks()-cart.getQuantity();
			
			if(newStock<0)
			{
				throw new RuntimeException("Out of stock"+product.getProductName());
			}
			product.setStocks(newStock);
			System.out.println("Before save: " + product.getProductName() + " stock=" + product.getStocks());
			productRepo.save(product);
			System.out.println("After save: " + productRepo.findById(product.getProductId()).get().getStocks());

			
		}
		//payment successful
		return savedPayment;
	}
}
