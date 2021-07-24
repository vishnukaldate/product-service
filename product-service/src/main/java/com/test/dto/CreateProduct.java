package com.test.dto;

import javax.validation.constraints.NotBlank;
import lombok.Data;
 
@Data
public class CreateProduct {
	
	@NotBlank
    private String product_name;
	
	@NotBlank
    private String product_no;
	
	private Long category_id;
	
}
