//package com.ps.customermngsystem.entity;
//
//import javax.validation.constraints.Email;
//import javax.validation.constraints.Max;
//import javax.validation.constraints.Min;
//import javax.validation.constraints.NotEmpty;
//import javax.validation.constraints.Size;
//
//import org.antlr.v4.runtime.misc.NotNull;
//import org.hibernate.annotations.processing.Pattern;
//
//import jakarta.persistence.Column;
//
//@SuppressWarnings("deprecation")
//public class Test {ppppppppppppp. dswc sa 
//
//	@NotNull(message = "First name cannot be null") 
//	@Size(min = 3, message = "First name must contain at least 3 characters") 
//	private String firstName;
//
//	@NotNull(message = "Email cannot be null") 
//	@Email(message = "Email should be valid")
//	 private String email;
//
//	@Size(min = 6, max = 20, message = "Password must be between 6 and 20 characters") 
//	@Pattern(regexp = "^[a-zA-Z0-9]*$", message = "Password must be alphanumeric") 
//	private String password;
//
//	@NotNull(message = "Mobile number cannot be null") 
//	@NotEmpty(message = "Mobile number cannot be empty") 
//	@Pattern(regexp = "^[0-9]{10}$", message = "Mobile number must be a 10-digit number") 
//	@Column(unique = true)
//	private String mobileNumber;
//
//	@NotNull(message = "Salary cannot be null") 
//	@Min(value = 10000, message = "Salary must be at least 10,000") 
//	@Max(value = 50000, message = "Salary must be less than or equal to 50,000") 
//	private Integer salary;
//
//}
