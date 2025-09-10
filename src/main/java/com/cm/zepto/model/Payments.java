package com.cm.zepto.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="payments")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payments {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int id;
private String paymentMethod;
private String paymentStatus;
private String transactionId;
private LocalDateTime paymentDate;
@ManyToOne
private Order orders; 
}
