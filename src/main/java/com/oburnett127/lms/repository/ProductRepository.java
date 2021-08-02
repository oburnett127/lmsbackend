package com.oburnett127.lms.repository;

import com.oburnett127.MyEcomm.model.Product;

import java.util.List;

public interface ProductRepository {

	Product createProduct(Product product);
	
	List<Product> getProducts();

	Product getProduct(Integer id);

	Product updateProduct(Product product);

	void deleteProduct(Integer id);
}