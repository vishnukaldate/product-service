package com.test.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.dto.ApiResponse;
import com.test.dto.CreateCategory;
import com.test.service.CategoryService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@PostMapping("/category/create")
    public ResponseEntity<?> categoryCreate(@Valid @RequestBody CreateCategory createCategory) {
		 log.info("Create category req body", createCategory);
       try {
    	   categoryService.createCategory(createCategory);
       } catch (Exception e) {
           log.error("Exception Ocurred", e);
       }
       return ResponseEntity.ok().body(new ApiResponse(true, "Category created successfully"));
    }
}
