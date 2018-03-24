package com.app.service;

import java.util.List;

import com.app.exception.MyException;
import com.app.model.Employee;

public interface EmployeeService {
	public String saveEmployee(Employee emp) throws MyException;
	public int updateEmployee(Employee emp);

	public List<Employee> empList() ;
	public void deleteEmployee(int eId);
	public Employee getEmp(int eId);




}
