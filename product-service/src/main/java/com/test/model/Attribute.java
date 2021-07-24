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
@Table(name = "attribute")
public class Attribute {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attribute_id")
	@ApiModelProperty(hidden = true)
    private Long attributeId;
 
    @Column(name = "attribute_name")
    @ApiModelProperty(example = "color", required = true)
    private String attributeName;
    
    @Column(name = "attribute_value")
    @ApiModelProperty(example = "Red", required = true)
    private String attributeValue;
    
    @ApiModelProperty(example = "1", required = true)
    @ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "category_id")
    private Category category;
}
