package com.kdn.tutorials.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.kdn.tutorials.customconstraint.MaxSizeConstraint;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@JsonPropertyOrder
public class ProductDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5846224719139241136L;

	@NotNull(message = "Please enter id")
	@Min(value = 10, message = "Value should be greater than 10")
	@Max(value = 100, message = "Value should be less than 100")
	private Long id;

	@NotNull(groups = DiscountedProduct.class, message = "Category is mandatory for Discounted Product type")
	private String category;

	@NotNull
	@NotBlank(message = "Title is a mandatory field")

	private String title;

	// @NotNull
	@NotBlank(message = "Description is a mandatory field")
	private String desc;

	@NotEmpty(message = "Type is a mandatory field")
	@MaxSizeConstraint
	private List<Integer> type;

	private Date createdTs;

	@NotNull(message = "Enter product price")
	@Positive
	@Min(value = 5, message = "Value should be greater than 5")
	@Max(value = 10, message = "Value should be less than 10")
	private Double price;

	@Size(min = 3, max = 3, message = "Tag must be 3 char longs")
	private String tag;

}
