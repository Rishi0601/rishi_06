package com.EmployeeMgmtUsingSpringMVCandThymeleaf.ServiceLayer;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.EmployeeMgmtUsingSpringMVCandThymeleaf.DAO.EmployeeDAO;
import com.EmployeeMgmtUsingSpringMVCandThymeleaf.Entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO empDAO;

	@Override
	@Transactional
	public void save(Employee emp) {
		// TODO Auto-generated method stub
		empDAO.save(emp);
	}

	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return empDAO.findAll();
	}

	@Override
	public List<Employee> findById(int id) {
		// TODO Auto-generated method stub
		List<Employee> emp = empDAO.searchById(id);
		return emp;
	}

	@Override
	public List<Employee> findByFirstname(String firstname) {
		// TODO Auto-generated method stub
		return empDAO.searchByFirstname(firstname);
	}

	@Override
	public List<Employee> findByLastname(String lastname) {
		// TODO Auto-generated method stub
		return empDAO.searchByLastname(lastname);
	}

	@Override
	@Transactional
	public void delete(int id) {
		// TODO Auto-generated method stub
		empDAO.deleteById(id);
	}

}
