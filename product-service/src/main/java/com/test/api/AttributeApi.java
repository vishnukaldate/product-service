package com.test.api;

import com.test.model.Attribute;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api
public interface AttributeApi {

	@ApiOperation(value = "Get category attributes by category ID", response = Attribute.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Suceess"), @ApiResponse(code = 401, message = "Not authorized!"), @ApiResponse(code = 403, message = "Forbidden!"),
	@ApiResponse(code = 404, message = "Not found!") })
	public Attribute getAttributeById(Long attributeId);

	@ApiOperation(value = "Create category attributes", response = String.class)
	public String attributeCreate(Attribute attribute);

}
