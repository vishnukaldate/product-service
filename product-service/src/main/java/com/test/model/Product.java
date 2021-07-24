package com.test.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "product")
public class Product {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(hidden = true)
	@Column(name = "product_id")
    private Long productId;
 
	@ApiModelProperty(example = "1hy26msd8h9", required = true)
	@Column(name = "product_no")
    private String productNo;
	
	@ApiModelProperty(example = "red stripes pontic shirt", required = true)
	@Column(name = "product_name")
    private String productName;
    
	@ApiModelProperty(example = "1", required = true)
    @ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "category_id")
    private Category category;
}
