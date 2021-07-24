package com.test.dto;

import java.util.List;

import lombok.Value;
 
@Value
public class ProductInfo {
	   private String productName;
	   private String ProductNo;
	   private Long categoryId;
	   private String categoryName;
	   private List<CategoryProductAttributeInfo> productAttributes;
	  
 }
