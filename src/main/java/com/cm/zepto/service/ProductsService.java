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
	public Product updateProduct(int pid,Product updatedProduct)
	{
		
		return pRepo.findById(pid).map(existing ->{
			existing.setProductName(updatedProduct.getProductName());
			existing.setCategory(updatedProduct.getCategory());
			existing.setPrice(updatedProduct.getPrice());
			existing.setStocks(updatedProduct.getStocks());
			return pRepo.save(existing);
			
		}).orElse(null);
	}
	
	public Product patchProduct(int id,Product partialUpdate)
	{
		return pRepo.findById(id)
			.map(
					p ->{
				  if (partialUpdate.getProductName()!=null)
				  {
					  p.setProductName(partialUpdate.getProductName());
				  }
				  if (partialUpdate.getCategory()!=null)
				  {
					  p.setCategory(partialUpdate.getCategory());
				  }
				  if (partialUpdate.getPrice()>0.0)
				  {
					  p.setPrice(partialUpdate.getPrice());
				  }
				  if (partialUpdate.getStocks()>0)
				  {
					  p.setStocks(partialUpdate.getStocks());
				  }
				 return pRepo.save(p);
					}).orElse(null);
			
	}
	

	
}
