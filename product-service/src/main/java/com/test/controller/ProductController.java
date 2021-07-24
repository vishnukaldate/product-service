package com.test.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.exception.ResourceNotFoundException;
import com.test.model.Attribute;
import com.test.model.Product;
import com.test.repository.AttributeRepository;
import com.test.repository.ProductRepository;
import com.test.dto.ApiResponse;
import com.test.dto.CategoryProductAttributeInfo;
import com.test.dto.CreateProduct;
import com.test.dto.ProductInfo;
import com.test.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api")
public class ProductController {

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private AttributeRepository attributeRepository; 
	
	@Autowired
	private ProductService productService;
	
	@PostMapping("/product/create")
    public ResponseEntity<?> productCreate(@Valid @RequestBody CreateProduct createProduct) {
		 log.info("Create product req body", createProduct);
       try {
       	productService.createProduct(createProduct);
       } catch (Exception e) {
           log.error("Exception Ocurred", e);
       }
       return ResponseEntity.ok().body(new ApiResponse(true, "Product created successfully"));
    }
	
	@GetMapping("/product/{id}")
	public ResponseEntity<ProductInfo> getProductById(@PathVariable(value = "id") Long productId)
			throws ResourceNotFoundException {
		Product product = productRepository.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + productId));
		
		List<Attribute> attributeList = attributeRepository.findByCategory(product.getCategory());
		List<CategoryProductAttributeInfo> attributeInfoList = new ArrayList<>();
		for (Iterator iterator1 = attributeList.iterator(); iterator1.hasNext();) {
			Attribute attribute = (Attribute) iterator1.next();
			CategoryProductAttributeInfo attInfo = new CategoryProductAttributeInfo(attribute.getAttributeId(),attribute.getAttributeName(),attribute.getAttributeValue());
			attributeInfoList.add(attInfo);
		}	
		
		ProductInfo productInfo = new ProductInfo(product.getProductName(),product.getProductNo(),product.getCategory().getCategoryId(),product.getCategory().getCategoryName(),attributeInfoList);
		
		return ResponseEntity.ok().body(productInfo);
	}
}
