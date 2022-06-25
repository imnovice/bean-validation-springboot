package com.kdn.tutorials.controller;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kdn.tutorials.dto.ProductDto;

/**
 * Product controller with custom managed bean validation.
 */
@RestController
@RequestMapping("/custom")
public class ProductControllerWithCustomValidator {

	@Autowired
	private Validator validator;

	/**
	 * Custom bean validation
	 */
	@PostMapping(path = "product", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ProductDto addProduct(@RequestBody ProductDto productDto) {
		Set<ConstraintViolation<ProductDto>> constraintViolation = validator.validate(productDto);
		if (!constraintViolation.isEmpty()) {
			throw new ConstraintViolationException(constraintViolation);
		}
		return productDto;
	}

	@GetMapping(path = "product", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ProductDto getProduct() {
		return new ProductDto();
	}

}
