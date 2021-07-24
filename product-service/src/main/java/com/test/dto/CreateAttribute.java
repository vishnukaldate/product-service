package com.test.dto;

import javax.validation.constraints.NotBlank;
import lombok.Data;
 
@Data
public class CreateAttribute {
	
	@NotBlank
    private String attribute_name;
	
	@NotBlank
    private String attribute_value;
	
	private Long category_id;
}
