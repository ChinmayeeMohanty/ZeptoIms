package com.cm.zepto.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cm.zepto.model.Product;

@Repository
public interface ProductsRepository extends JpaRepository<Product, Integer> {

}
