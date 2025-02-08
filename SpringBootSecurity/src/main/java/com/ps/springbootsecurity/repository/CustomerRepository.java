package com.ps.springbootsecurity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ps.springbootsecurity.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>
{
	public List<Customer> findByCustEmailContaining(String z);
	
	//public List<Customer> findByCustIdGreaterThanEqual(int x);
	
	@Query(nativeQuery = true, value = "SELECT * FROM customer where custid>=?1 order by custname desc")
	public List<Customer> itvFindById(int x);
	
	public List<Customer> findByCustName(String z);
	
	
	@Query(nativeQuery = true, value = "SELECT distinct cust_gender FROM customer")
	public List<String> getAllGenders();

	public List<Customer> findByCustGender(String searchGender);

	public List<Customer> findByCustNameAndCustGender(String a,String b);
}