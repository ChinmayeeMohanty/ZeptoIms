package com.cm.zepto.controller;

import java.util.List;
import java.util.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cm.zepto.model.Delivery;
import com.cm.zepto.service.DeliveryService;

@RestController
@RequestMapping("/delivery")
public class DeliveryController {

	@Autowired
	private DeliveryService deliveryService;
	
	@PostMapping("/schedule")
	public Delivery schedule(@RequestBody Delivery delivery)
	{
		return deliveryService.scheduleDelivery(delivery);
	}
	
	@PutMapping("/pickup/{id}")
	public Delivery pickup(@PathVariable("id") int id)
	{
		return deliveryService.pickupDelivery(id);
	}
	
	@PutMapping("/completed/{id}")
	public Delivery complete(@PathVariable("id") int id)
	{
		return deliveryService.completeDelivery(id);
	}
	@GetMapping("/scheduled")
	public Queue<Delivery> getScheduled()
	{
		return deliveryService.getScheduleDeliveries();
	}
	
	@GetMapping("/all")
	public List<Delivery> getDeliveries()
	{
		return deliveryService.getAllDelivery();
	}
}
