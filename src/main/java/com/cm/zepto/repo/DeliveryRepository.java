package com.cm.zepto.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cm.zepto.model.Delivery;
@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, Integer> {

}
