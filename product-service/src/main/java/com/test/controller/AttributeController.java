package com.test.controller;

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

import com.test.dto.ApiResponse;
import com.test.dto.CreateAttribute;
import com.test.model.Attribute;
import com.test.model.Category;
import com.test.repository.AttributeRepository;
import com.test.service.AttributeService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api")
public class AttributeController {
	
	@Autowired
	private AttributeRepository attributeRepository; 
	
	@Autowired
	private AttributeService attributeService;
	
	@PostMapping("/attribute/create")
    public ResponseEntity<?> attributeCreate(@Valid @RequestBody CreateAttribute createAttribute) {
		 log.info("Create attribute req body", createAttribute);
       try {
    	   attributeService.createAttribute(createAttribute);
       } catch (Exception e) {
           log.error("Exception Ocurred", e);
       }
       return ResponseEntity.ok().body(new ApiResponse(true, "Attribute created successfully"));
    }
	
	@GetMapping("/category/attributes/{id}")
	public List<Attribute> getCategoryById(@PathVariable(value = "id") Long categoryId)
	{
		Category category = new Category();
		category.setCategoryId(categoryId);
		List<Attribute> attributesList = attributeRepository.findByCategory(category);
		
		return attributesList;
	}
}
