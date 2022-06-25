package com.kdn.tutorials.customconstraint.validator;

import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.kdn.tutorials.customconstraint.MaxSizeConstraint;

public class MaxSizeConstraintValidator implements ConstraintValidator<MaxSizeConstraint, List<Integer>> {
	MaxSizeConstraint abc;
	public void initialize(MaxSizeConstraint constraintAnnotation) {
		abc=constraintAnnotation;
	}
    @Override
    public boolean isValid(List<Integer> values, ConstraintValidatorContext context) {
    	if (values ==null) {return true;}
        return values.size() <= 4;
    }
}