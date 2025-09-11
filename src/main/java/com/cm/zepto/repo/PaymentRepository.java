package com.cm.zepto.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cm.zepto.model.Payments;

public interface PaymentRepository extends JpaRepository<Payments,Integer>{

}
