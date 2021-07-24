package com.test.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.dto.CreateCategory;
import com.test.model.Category;
import com.test.repository.CategoryRepository;
import com.test.service.CategoryService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
    @Transactional(value = "transactionManager")
    public Category createCategory(final CreateCategory createCategory) {
		
		Category category = new Category();
		category.setCategoryName(createCategory.getCategory_name());
		categoryRepository.save(category);
		categoryRepository.flush();
	    log.info("category saved...");
		return category;
	}	
}
