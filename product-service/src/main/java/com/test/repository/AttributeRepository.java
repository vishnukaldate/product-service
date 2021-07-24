package com.test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.model.Attribute;
import com.test.model.Category;


@Repository
public interface AttributeRepository extends JpaRepository<Attribute, Long>{

	boolean existsByAttributeName(String attributeName);
	
	List<Attribute> findByCategory(Category category);
}
