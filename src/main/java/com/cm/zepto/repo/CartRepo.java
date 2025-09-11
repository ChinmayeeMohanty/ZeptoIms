package com.cm.zepto.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cm.zepto.model.Cart;

@Repository
public interface CartRepo extends JpaRepository<Cart,Integer>{
	List<Cart> findByUserUserId(int userId);
}
