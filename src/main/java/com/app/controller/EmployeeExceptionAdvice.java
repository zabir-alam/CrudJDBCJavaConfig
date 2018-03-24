package com.app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.app.exception.MyException;
import com.app.model.ErrorMsg;

@ControllerAdvice
public class EmployeeExceptionAdvice {
	public EmployeeExceptionAdvice() {
System.out.println("Employee Exception");	
}
	@ExceptionHandler(MyException.class)
	public String mapException(MyException exception,ModelMap map) {
	ErrorMsg msg=new ErrorMsg(HttpStatus.INTERNAL_SERVER_ERROR.value(),exception.getMessage());
		map.addAttribute("msg", msg);
	return "employee";
	}

}
