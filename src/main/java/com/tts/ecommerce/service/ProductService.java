package com.tts.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tts.ecommerce.model.Product;
import com.tts.ecommerce.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public Product findById(long id) {
		Product product = productRepository.findById(id);
		return product;
	}
	
	public List<Product> findAll(){
		List<Product> products = productRepository.findAll();
		return products;
	}

	public List<String> findDistinctCategories(String category) {
		List<String> categories = productRepository.findDistinctByCategory(category);
		return categories;
	}

	public List<String> findDistinctBrands(String brand) {
		List<String> brands = productRepository.findDistinctByBrand(brand);
		return brands;
	}

	public List<Product> findByBrandAndOrCategory(String brand, String category) {
		
		if(brand == null && category == null)
			return productRepository.findAll();
		else if(category == null)
			return productRepository.findByBrand(brand);
		else if(brand == null)
			return productRepository.findByCategory(category);
		else
			return productRepository.findAllByBrandAndCategory(brand, category);
		
		
	}
	
	public void save(Product product) {
		productRepository.save(product);
		
	}
	
	public void deleteById(long id) {
		productRepository.deleteById(id);
	}

}
