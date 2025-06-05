package com.EmployeeMgmtUsingSpringMVCandThymeleaf.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.EmployeeMgmtUsingSpringMVCandThymeleaf.Entity.Employee;


@Repository
public interface EmployeeDAO extends JpaRepository<Employee, Integer>{
		
	List<Employee> searchByFirstname(String fname);

	List<Employee> searchByLastname(String lname);

	List<Employee> searchById(int id);
		
}
