package com.ps.petstoreapp.entity;

import java.time.Instant;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.ps.petstoreapp.util.PasswordMatches;
import com.ps.petstoreapp.util.ValidMobileNumber;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
@Entity
@PasswordMatches
@EntityListeners(AuditingEntityListener.class)
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer c_id;

	@NotNull(message = "First name cannot be null")
	@Size(min = 3, message = "First name must have at least 3 characters")
	private String firstName;

	@NotNull(message = "Last name cannot be null")
	@Size(min = 3, message = "Last name must have at least 3 characters")
	private String lastName;

	@NotNull(message = "Email cannot be null")
	@Email(message = "Invalid email format")
	private String email;

	@NotNull(message = "Password cannot be null")
	@Size(min = 6, max = 20, message = "Password must be between 6 and 20 characters")
	@Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Password must be alphanumeric")
	private String password;

	@NotNull(message = "Confirm password cannot be null")
	@Size(min = 6, max = 20, message = "Confirm password must be between 6 and 20 characters")
	@Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Confirm password must be alphanumeric")
	private String confirmPassword;

	@NotNull(message = "Mobile number cannot be null")
	@NotEmpty(message = "Mobile number cannot be empty")
	@ValidMobileNumber
	private String mobileNo;

	@Min(value = 10000, message = "Salary must be at least 10,000")
	@Max(value = 50000, message = "Salary must be at most 50,000")
	private Double salary;
	
	@CreatedDate

	private Instant CreatedAt;

	@LastModifiedDate

	private Instant ModifiedAt;

	public Integer getC_id() {
		return c_id;
	}

	public void setC_id(Integer c_id) {
		this.c_id = c_id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}
	

	public Instant getCreatedAt() {
		return CreatedAt;
	}

	public void setCreatedAt(Instant createdAt) {
		CreatedAt = createdAt;
	}

	public Instant getModifiedAt() {
		return ModifiedAt;
	}

	public void setModifiedAt(Instant modifiedAt) {
		ModifiedAt = modifiedAt;
	}

	@Override
	public String toString() {
		return "Customer [c_id=" + c_id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + ", confirmPassword=" + confirmPassword + ", mobileNo=" + mobileNo
				+ ", salary=" + salary + "]";
	}

}
