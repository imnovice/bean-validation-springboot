package com.kdn.tutorials.customconstraint;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.kdn.tutorials.customconstraint.validator.MaxSizeConstraintValidator;

@Constraint(validatedBy = MaxSizeConstraintValidator.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface MaxSizeConstraint {
	String message() default "The input list cannot contain more than 4 items.";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}