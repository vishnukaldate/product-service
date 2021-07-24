package com.test.api;

import com.test.model.Product;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api
public interface ProductApi {

	@ApiOperation(value = "Get product by product ID", response = Product.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Suceess"), @ApiResponse(code = 401, message = "Not authorized!"), @ApiResponse(code = 403, message = "Forbidden!"),
	@ApiResponse(code = 404, message = "Not found!") })
	public Product getProductById(Long productId);

	@ApiOperation(value = "Create product", response = String.class)
	public String productCreate(Product product);

}
