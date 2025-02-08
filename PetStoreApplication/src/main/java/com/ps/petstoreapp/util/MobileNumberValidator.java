package com.ps.petstoreapp.util;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class MobileNumberValidator implements ConstraintValidator<ValidMobileNumber, String> {

    @Override
    public boolean isValid(String mobileNo, ConstraintValidatorContext context) {
        if (mobileNo == null) {
            return false; // Null values are invalid
        }
        return mobileNo.matches("\\d{10}"); // Ensures exactly 10 digits
    }
}
