package com.talk2amar.projects.employeeservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.talk2amar.projects.employeeservice.model.Employee;
import com.talk2amar.projects.employeeservice.repo.EmployeeRepository;

@Service
public class ApplicationServiceImpl implements ApplicationService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public Employee createEmployee(Employee employee) {
		return employeeRepository.save(employee);

	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

}
