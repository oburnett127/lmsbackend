package com.oburnett127.lms.services;

import com.oburnett127.MyEcomm.model.Product;

import java.util.List;

public interface ProductOperations {

	Product createProduct(Product Product);
	
	List<Product> getProducts();
	
	Product getProduct(Integer id);

	Product updateProduct(Product Product);

	void deleteProduct(Integer id);

}