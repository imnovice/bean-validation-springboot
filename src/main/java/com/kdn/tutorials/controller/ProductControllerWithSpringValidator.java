package com.kdn.tutorials.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kdn.tutorials.dto.DiscountedProduct;
import com.kdn.tutorials.dto.ProductDto;

/**
 * Product controller with Spring managed bean validation.
 */
@RestController
@RequestMapping("/spring")
public class ProductControllerWithSpringValidator {

	/**
	 * With validator's groups clause. category field is mandatory for DiscountedProduct group.
	 */
	@PostMapping(path = "product", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	@ResponseBody
	public ProductDto addProduct(@RequestBody @Validated(DiscountedProduct.class) ProductDto productDto) {
		return productDto;
	}
	
	/**
	 * Without validator's groups clause. category is not a mandatory field.
	 */
	@PostMapping(path = "product2", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	@ResponseBody
	public ProductDto addProduct2(@RequestBody(required = true) @Valid  ProductDto productDto) {
		return productDto;
	}

	@GetMapping(path = "product", produces = APPLICATION_JSON_VALUE)
	@ResponseBody
	public ProductDto getProduct() {
		return new ProductDto();
	}

}
