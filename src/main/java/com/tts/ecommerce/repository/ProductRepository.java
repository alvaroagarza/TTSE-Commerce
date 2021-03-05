package com.tts.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tts.ecommerce.model.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
	
	Product findById(long id);
	List<Product> findAll();
	List<Product> findByBrand(String brand);
	List<Product> findByCategory(String category);
	List<Product> findAllByBrandAndCategory(String brand, String category);
	
	
	@Query("SELECT DISTINCT p.brand from Product p")
	List<String> findDistinctByBrand(String brand);
	
	@Query("SELECT DISTINCT p.category from Product p")
	List<String> findDistinctByCategory(String category);
	
	

}
