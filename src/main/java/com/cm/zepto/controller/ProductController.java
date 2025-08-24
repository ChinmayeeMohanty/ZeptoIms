package com.cm.zepto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cm.zepto.model.Product;
import com.cm.zepto.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService service ;

    @GetMapping("/")
    public List<Product> getAll()
    {
    	return service.getAllProducts();
    }
    
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") int id)
    {
    	return service.getById(id);
    }
    
    @PostMapping("/")
    public Product addProduct(@RequestBody Product p)
    {
    	service.addProduct(p);
    	return service.getById(p.getProductId());
    }
    
    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable("id") int id)
    {
    	return service.deleteProduct(id);
    }
    
    @PutMapping("/{id}")
    public String updateProduct(@PathVariable("id") int id,@RequestBody Product p)
    {
    	return service.updateProduct(id, p);
    }
    
    @PatchMapping("/{id}")
    public Product patchProduct(@PathVariable("id") int id,@RequestBody Product p)
    {
    	return service.patchProduct(id, p);
    }
}
