package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.exception.MyException;
import com.app.model.Employee;
import com.app.service.EmployeeService;

@Controller
public class EemployeeController{
	@Autowired
	private EmployeeService service;
	@RequestMapping("/showPage")
	 public String showPage(ModelMap map) {
		List<Employee> list=service.empList();
		map.addAttribute("list", list);
		 return "employee";
	 }
	@RequestMapping(value="/saveEmp",method=RequestMethod.POST)
	public String saveEmployee(@ModelAttribute("employee") Employee employee) throws MyException {
		try {
			Employee emp=service.getEmp(employee.getId());
		if(emp.getId()==employee.getId()) {
			service.updateEmployee(employee);
		}
		} catch(Exception exp) {
			service.saveEmployee(employee);
		}
		return "redirect:showPage";
	}
	@RequestMapping("/editEmp")
public String getEmployee(@RequestParam("id") int  id,ModelMap map) {
	Employee emp=service.getEmp(id);
	map.addAttribute("emp", emp);
	return "employee";
	}
	@RequestMapping("/deleteEmp")
	public String deleteEmployee(@RequestParam("id") int  id) {
		service.deleteEmployee(id);
		return "redirect:showPage";
	
	}
	
}