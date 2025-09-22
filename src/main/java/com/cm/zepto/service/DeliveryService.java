package com.cm.zepto.service;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cm.zepto.model.Delivery;
import com.cm.zepto.model.DeliveryStatus;
import com.cm.zepto.model.Order;
import com.cm.zepto.repo.DeliveryRepository;
import com.cm.zepto.repo.OrderRepository;

@Service
public class DeliveryService {

	@Autowired
	private DeliveryRepository deliveryRepo;
	
	@Autowired
	private OrderRepository orderRepo;
	
	private Queue<Delivery> deliveryQueue=new LinkedList<>();
	

	public List<Delivery> getAllDelivery()
	{
		return deliveryRepo.findAll();
	}
	
	public Delivery scheduleDelivery(Delivery delivery)
	{
		delivery.setStatus(DeliveryStatus.SCHEDULED);
		delivery.setScheduleTime(LocalDateTime.now().plusMinutes(30));
		deliveryQueue.add(delivery);
		return deliveryRepo.save(delivery);
	}
	
	public Map<String,Object> pickupDelivery(int deliveryId)
	{
		Optional<Delivery> deliveryOpt=deliveryRepo.findById(deliveryId);
		if(deliveryOpt.isPresent())
		{
			Delivery delivery=deliveryOpt.get();
			delivery.setStatus(DeliveryStatus.PICKED);
			delivery.setPickedTime(LocalDateTime.now());
			deliveryRepo.save(delivery);
//			Order order=delivery.getOrder();
//			
//			List<Map<String,Object>> products = order.getCarts().stream().map(c -> {
//			    Map<String,Object> productInfo = new LinkedHashMap<>();
//			    productInfo.put("productName", c.getProduct().getProductName());
//			    productInfo.put("quantity", c.getQuantity());
//			    productInfo.put("price", c.getProduct().getPrice());
//			    return productInfo;
//			}).toList();

			Map<String,Object> response=new LinkedHashMap<>();
			response.put("deliveryId",delivery.getId());
//			response.put("customerName",order.getUser().getUserName());
//			response.put("amount",order.getAmount());
			response.put("status",delivery.getStatus());
//			response.put("products",products);
			return response;
		}  
		throw new RuntimeException("Delivery not found");
		
	}
	
	public Delivery completeDelivery(int deliveryId)
	{
		Optional<Delivery> deliveryOpt=deliveryRepo.findById(deliveryId);
		if(deliveryOpt.isPresent())
		{
			Delivery delivery=deliveryOpt.get();
			delivery.setStatus(DeliveryStatus.DELIVERED);
			delivery.setDeliveryTime(LocalDateTime.now());
			deliveryQueue.remove(delivery);
			deliveryRepo.save(delivery);
			return delivery;
		}
		throw new RuntimeException("Delivery not found");

	}
	
	public Queue<Delivery> getScheduleDeliveries()
	{
		return deliveryQueue;
	}
	
	
}
