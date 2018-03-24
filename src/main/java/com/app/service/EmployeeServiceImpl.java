package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.EmployeeDAO;
import com.app.exception.MyException;
import com.app.model.Employee;
@Service
public class EmployeeServiceImpl implements EmployeeService{
@Autowired
	private EmployeeDAO dao;
	
	@Override
	public String saveEmployee(Employee emp) throws MyException {
		String msg="";
		try {
	int id=	dao.saveEmployee(emp);
	
	if(id>0)
		msg="Employee Details save Successfully";
	else
		msg="Employee Details  not save";
		}
		catch(Exception e) {
			throw new MyException("Please Enter the Employee Details details");
		}
		return msg;
	}

	@Override
	public List<Employee> empList() {
		
		return dao.empList();
	}

	@Override
	public void deleteEmployee(int eId) {
		dao.deleteEmployee(eId);
		}
	@Override
		public Employee getEmp(int eId) {
			
			return dao.get(eId);
		}

	@Override
	public int updateEmployee(Employee emp) {
		return dao.updateEmployee(emp);
	}

}
