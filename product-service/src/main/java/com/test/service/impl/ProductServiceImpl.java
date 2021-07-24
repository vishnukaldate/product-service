package com.test.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.dto.CreateProduct;
import com.test.model.Category;
import com.test.model.Product;
import com.test.repository.ProductRepository;
import com.test.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Override
    @Transactional(value = "transactionManager")
    public Product createProduct(final CreateProduct createProduct) {
	
		Product product = new Product();
		product.setProductName(createProduct.getProduct_name());
		Category category = new Category();
		category.setCategoryId(createProduct.getCategory_id());
		product.setCategory(category);
		product.setProductNo(createProduct.getProduct_no());
		productRepository.save(product);
		productRepository.flush();
	    log.info("Product saved...");
		return product;
	}	
}
