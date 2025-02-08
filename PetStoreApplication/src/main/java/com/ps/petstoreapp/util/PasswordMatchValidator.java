package com.ps.petstoreapp.util;

import com.ps.petstoreapp.entity.Customer;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordMatchValidator implements ConstraintValidator<PasswordMatches, Customer> {
    @Override
    public boolean isValid(Customer customer, ConstraintValidatorContext context) {
        return customer.getPassword().equals(customer.getConfirmPassword());
    }
}
