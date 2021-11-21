package com.oburnett127.lms.services;

import com.oburnett127.MyEcomm.model.Product;
import com.oburnett127.MyEcomm.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("productService")
public class ProductService implements com.oburnett127.MyEcomm.service.ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public Product createProduct(Product product) {
		return productRepository.createProduct(product);
	}
	
	@Override
	public Product getProduct(Integer id) {
		return productRepository.getProduct(id);
	}
	
	@Override
	public List<Product> getProducts() {
		return productRepository.getProducts();
	}
	
	@Override
	public Product updateProduct(Product product) {
		return productRepository.updateProduct(product);
	}
	
	@Override
	public void deleteProduct(Integer id) {
		productRepository.deleteProduct(id);
	}
}