package com.example.mockbus.annotations;

import com.example.mockbus.constraints.EmailUniqueValidator;
import com.example.mockbus.constraints.PasswordValidater;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = EmailUniqueValidator.class)
@Documented
public @interface UniqueEmail {
    String message() default " Email already exists";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
