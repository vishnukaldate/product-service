package com.test.api;

import com.test.model.Category;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api
public interface CategoryApi {

	@ApiOperation(value = "Create category", response = String.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Suceess"), @ApiResponse(code = 401, message = "Not authorized!"), @ApiResponse(code = 403, message = "Forbidden!"),
	@ApiResponse(code = 404, message = "Not found!") })
	public String categoryCreate(Category Category);

}
