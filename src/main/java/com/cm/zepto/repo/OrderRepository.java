package com.cm.zepto.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cm.zepto.model.Order;
@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

}
