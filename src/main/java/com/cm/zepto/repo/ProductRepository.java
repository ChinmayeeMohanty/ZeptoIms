package com.cm.zepto.repo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.cm.zepto.model.Product;
@Repository
public class ProductRepository {

	List<Product> products=new ArrayList<Product>(
			Arrays.asList(
					new Product(1,"Milk","dairy",12,85.00),
					new Product(2,"Paneer","dairy",15,150.00),
					new Product(3,"Curd","dairy",17,40.00),
					new Product(4,"Cheese","dairy",19,62.00)
					)
			);
	
	int idCounter=5;
	
	public List<Product> findAll()
	{
		return products;
	}
	public void addProduct(Product product)
	{
	   product.setProductId(idCounter++);
	   products.add(product);
	}
	
	public Product findById(int id) {
		return products.stream().filter(p -> p.getProductId()==id).findFirst().orElse(null);
	}
	
	public String updateProduct(int pid,Product updatedProduct)
	{
		boolean found = products.stream()
				.filter(p -> p.getProductId()==pid)
				.peek(p -> {
					p.setProductName(updatedProduct.getProductName());
					p.setCategory(updatedProduct.getCategory());
					p.setPrice(updatedProduct.getPrice());
					p.setQuantity(updatedProduct.getQuantity());
				})
				.findFirst()
				.isPresent();
		return found ? "product updated":"product not found";
	}
	
	public String removeProduct(int pid)
	{
		boolean removed=products.removeIf(p -> p.getProductId()== pid);
		return removed?"product deleted":"product not found";	
	}
	
	public Product patchProduct(int id,Product partialUpdate)
	{
		return products.stream().filter(p -> p.getProductId()== id).findFirst()
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
				  if (partialUpdate.getQuantity()>0)
				  {
					  p.setQuantity(partialUpdate.getQuantity());
				  }
				 return p;
					}).orElse(null);
			
	}
	
	
}
