package com.tts.ecommerce.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.tts.ecommerce.model.Product;
import com.tts.ecommerce.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@GetMapping("/product/{id}")
	public String show(@PathVariable int id, Model model) {
		Product product = productService.findById(id);
		model.addAttribute(product);
		
		
		return "product";
	}

}
