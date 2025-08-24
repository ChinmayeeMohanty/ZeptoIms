package com.cm.zepto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cm.zepto.model.Product;
import com.cm.zepto.repo.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repo;
    
	public List<Product> getAllProducts()
	{
		return repo.findAll();
	}
	
	public Product getById(int id)
	{
		return repo.findById(id);
	}
	
	public String addProduct(Product p)
	{
		 repo.addProduct(p);
		 return "Product added successfully";
	}
	
	public String updateProduct(int id,Product updatedProduct)
	{
		return repo.updateProduct(id, updatedProduct);
		
	}
	
	public String deleteProduct(int id)
	{
		return repo.removeProduct(id);
	}
	public Product patchProduct(int id, Product updatePartial)
	{
		return repo.patchProduct(id, updatePartial);
	}
}
