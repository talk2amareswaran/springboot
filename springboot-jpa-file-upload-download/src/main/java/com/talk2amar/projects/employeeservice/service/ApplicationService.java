package com.talk2amar.projects.employeeservice.service;

import java.util.List;

import com.talk2amar.projects.employeeservice.model.Employee;

public interface ApplicationService {

	Employee createEmployee(Employee employee);

	List<Employee> getAllEmployees();
}
