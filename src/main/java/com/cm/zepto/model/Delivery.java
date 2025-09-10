package com.cm.zepto.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="delivery")
@Data
@NoArgsConstructor
@AllArgsConstructor


public class Delivery {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int orderId;
	private String customerName;
	private String address;
	@Enumerated(EnumType.STRING)
	private DeliveryStatus status;
	private LocalDateTime scheduleTime;
	private LocalDateTime deliveryTime;
	private LocalDateTime pickedTime;
	
	
}
