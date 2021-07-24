package com.test.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.dto.CreateAttribute;
import com.test.model.Attribute;
import com.test.model.Category;
import com.test.repository.AttributeRepository;
import com.test.service.AttributeService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AttributeServiceImpl implements AttributeService {

	@Autowired
	private AttributeRepository attributeRepository;
	
	@Override
    @Transactional(value = "transactionManager")
    public Attribute createAttribute(final CreateAttribute createAttribute)  {
		
		Attribute attribute = new Attribute();
		attribute.setAttributeName(createAttribute.getAttribute_name());
		attribute.setAttributeValue(createAttribute.getAttribute_value());
		Category category = new Category();
		category.setCategoryId(createAttribute.getCategory_id());
		attribute.setCategory(category);
		attributeRepository.save(attribute);
		attributeRepository.flush();
	    log.info("attribute saved...");
		return attribute;
	}	
}
