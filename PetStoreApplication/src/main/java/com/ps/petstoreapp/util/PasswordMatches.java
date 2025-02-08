package com.ps.petstoreapp.util;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PasswordMatchValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface PasswordMatches {
    String message() default "Password and Confirm Password do not match";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
