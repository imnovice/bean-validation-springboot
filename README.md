### Beans (DTO) validation in Spring Boot using starter-validation

__Dependencies__

```
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-web</artifactId>
</dependency>
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-validation</artifactId>
</dependency>
```


For different needs there are lots of PRE defined validation annotations are present
* __@NotNull__  validates that the annotated property value is not null.
* __@AssertTrue__  validates that the annotated property value is true.
* __@Size__  validates that the annotated property value has a size between the attributes min and max; can be applied to String, Collection, Map, and array properties.
* __@Min__  validates that the annotated property has a value no smaller than the value attribute.
* __@Max__  validates that the annotated property has a value no larger than the value attribute.
* __@Email__  validates that the annotated property is a valid email address.
* __@NotEmpty__  validates that the property is not null or empty; can be applied to String, Collection, Map or Array values.
* __@NotBlank__  can be applied only to text values and validates that the property is not null or whitespace.
* __@Positive__  and  __@PositiveOrZero__  apply to numeric values and validate that they are strictly positive, or positive including 0.
* __@Negative__   and  __@NegativeOrZero__  apply to numeric values and validate that they are strictly negative, or negative including 0.
* __@Past__  and  __@PastOrPresent__  validate that a date value is in the past or the past including the present; can be applied to date types including those added in Java 8.
* __@Future__  and  __@FutureOrPresent__  validate that a date value is in the future, or in the future including the present.


__Note__ : Still you can define your custom validation annotation as per your business needs.

 


__To create custom annotation & validator__
***
_An annotation interface:_

```
@Constraint(validatedBy = MaxSizeConstraintValidator.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface MaxSizeConstraint {
	String message() default "The input list cannot contain more than 4 items.";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
```

_A validation class:_

```
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
```


In this tutorials there two Product Controllers are defined

* ProductControllerWithSpringValidator - Based on @Validated and/or @Valid annotation
* ProductControllerWithCustomValidator - Bean validaiton is done programatically i.e., you defined  Validator and invoke validator.validate(...)


