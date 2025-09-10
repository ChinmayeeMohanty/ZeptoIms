package com.cm.zepto.service;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cm.zepto.model.Delivery;
import com.cm.zepto.model.DeliveryStatus;
import com.cm.zepto.repo.DeliveryRepository;

@Service
public class DeliveryService {

	@Autowired
	private DeliveryRepository deliveryRepo;
	
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
	
	public Delivery pickupDelivery(int deliveryId)
	{
		Optional<Delivery> deliveryOpt=deliveryRepo.findById(deliveryId);
		if(deliveryOpt.isPresent())
		{
			Delivery delivery=deliveryOpt.get();
			delivery.setStatus(DeliveryStatus.PICKED);
			delivery.setPickedTime(LocalDateTime.now());
			deliveryRepo.save(delivery);
			return delivery;
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
