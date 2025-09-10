package com.cm.zepto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cm.zepto.model.Product;
import com.cm.zepto.repo.ProductsRepository;

@Service
public class ProductsService {
 
	@Autowired
	private ProductsRepository pRepo;
	
	public Product saveItem(Product p)
	{ 
		return pRepo.save(p);
	}
	public List<Product> getAllItems()
	{ 
		return pRepo.findAll();
	}
	public Product getItemById(int id)
	{ 
		return pRepo.findById(id).orElse(null);
	}
	public void deleteItem(int id)
	{
		pRepo.deleteById(id);
	}
	
}
