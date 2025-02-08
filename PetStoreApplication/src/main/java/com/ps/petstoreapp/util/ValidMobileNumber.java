package com.ps.petstoreapp.util;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = MobileNumberValidator.class)
@Target({ ElementType.FIELD, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidMobileNumber {
    
    String message() default "Invalid mobile number. It must be exactly 10 digits.";
    
    Class<?>[] groups() default {};
    
    Class<? extends Payload>[] payload() default {};
}
