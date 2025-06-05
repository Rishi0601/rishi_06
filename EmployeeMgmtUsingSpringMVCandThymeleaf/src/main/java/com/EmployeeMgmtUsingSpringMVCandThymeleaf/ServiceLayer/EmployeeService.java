package com.EmployeeMgmtUsingSpringMVCandThymeleaf.ServiceLayer;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.EmployeeMgmtUsingSpringMVCandThymeleaf.Entity.Employee;
@Repository
public interface EmployeeService {
	
	
	List<Employee> findById(int id);

	List<Employee> findByFirstname(String firstname);

	List<Employee> findByLastname(String lastname);

	void delete(int id);

	List<Employee> findAll();

	void save(Employee emp);		

}
