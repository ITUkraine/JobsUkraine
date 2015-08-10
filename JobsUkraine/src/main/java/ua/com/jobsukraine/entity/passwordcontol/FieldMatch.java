package ua.com.jobsukraine.entity.passwordcontol;

import javax.validation.Constraint;
import javax.validation.Payload;

import java.lang.annotation.Documented;
import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.TYPE;
import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Target;

@Target({ TYPE, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = FieldMatchValidator.class)
@Documented
public @interface FieldMatch {
	@Target({ TYPE, ANNOTATION_TYPE })
	@Retention(RUNTIME)
	@Documented
	@interface List {
		FieldMatch[]value();
	}

	String first();

	Class<?>[]groups() default {};

	String message() default "{constraints.fieldmatch}";

	Class<? extends Payload>[]payload() default {};

	String second();
}