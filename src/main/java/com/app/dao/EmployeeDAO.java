package com.app.dao;

import java.util.List;

import com.app.model.Employee;

public interface EmployeeDAO {
public int saveEmployee(Employee emp);
public List<Employee> empList() ;
public void deleteEmployee(int eId);
public Employee get(int eId);
public int updateEmployee(Employee emp);

}
