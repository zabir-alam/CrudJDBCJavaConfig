package com.app.model;

import java.io.Serializable;

public class Employee implements Serializable {
 /**
	 * 
	 */
	private static final long serialVersionUID = -7461821632702920934L;
	
private Integer id;
 private String name;
 private Integer age;
 private String dept;
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Integer getAge() {
	return age;
}
public void setAge(Integer age) {
	this.age = age;
}
public String getDept() {
	return dept;
}
public void setDept(String dept) {
	this.dept = dept;
}
public Employee(Integer id, String name, Integer age, String dept) {
	super();
	this.id = id;
	this.name = name;
	this.age = age;
	this.dept = dept;
}
@Override
public String toString() {
	return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", dept=" + dept + "]";
}
public Employee() {
	super();
}

}
