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
import com.cm.zepto.service.ProductsService;

@RestController
public class ProductController {

	@Autowired
	private ProductService service ;
    @Autowired
    private ProductsService pService;
    @GetMapping("/")
    public List<Product> getAll()
    {
    	return pService.getAllItems();
    }
    
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") int id)
    {
    	return pService.getItemById(id);
    }
    
    @PostMapping("/")
    public Product addProduct(@RequestBody Product p)
    {
    	
    	return pService.saveItem(p);
    }
    
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") int id)
    {
    	pService.deleteItem(id);
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
