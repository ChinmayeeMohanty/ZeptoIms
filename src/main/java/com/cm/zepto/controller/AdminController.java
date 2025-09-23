package com.cm.zepto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cm.zepto.model.Product;
import com.cm.zepto.model.User;
import com.cm.zepto.service.ProductsService;
import com.cm.zepto.service.UserService;


@RequestMapping("/admin")
@Controller
public class AdminController {

		@Autowired
		private UserService userService;
	    @Autowired
	    private ProductsService pService;
	    @GetMapping("/")
	    public String adminDashBoard(Model model)
	    {
	    	List<Product> products=pService.getAllItems();
	    	List<User> users=	userService.getAllUsers(); 
	    	model.addAttribute("products",products);
	    	model.addAttribute("totalProducts",products.size());
	    	model.addAttribute("users",users);
	        return "dashBoard";
	    }
	    @GetMapping("/product/add")
	    public String showAddProductForm(Model  model)
	    {
	    	model.addAttribute("product", new Product());
	    	return "add";
	    }
	    
	    @PostMapping("/product/add")
	    public String addProduct(@ModelAttribute("product") Product p,RedirectAttributes ra)
	    {
	    	try
	    	{
	    		pService.saveItem(p);
	    		ra.addFlashAttribute("success","product added successfully");
	    	}
	    	catch(Exception e)
	    	{
	    		ra.addFlashAttribute("error","error adding product:"+e.getMessage());
	    	}
	    	return "redirect:/admin/";
	    }
//		@PostMapping("/")
//		public String addUser(@RequestBody User u)
//		{
//		   return userService.addUser(u);
//		}
//	    @DeleteMapping("/{id}")
//	    public void deleteById(@PathVariable("id") int id)
//	    {
//	    	pService.deleteItem(id);
//	    }
//	    
//	    @PutMapping("/{id}")
//	    public Product updateProduct(@PathVariable("id") int id,@RequestBody Product p)
//	    {
//	    	return pService.updateProduct(id, p);
//	    }
//	    
//	    @PatchMapping("/{id}")
//	    public Product patchProduct(@PathVariable("id") int id,@RequestBody Product p)
//	    {
//	    	return pService.patchProduct(id, p);
//	    }
}
