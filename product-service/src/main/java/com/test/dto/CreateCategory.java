package com.test.dto;

import javax.validation.constraints.NotBlank;
import lombok.Data;
 
@Data
public class CreateCategory {
	
	@NotBlank
    private String category_name;
	
}
