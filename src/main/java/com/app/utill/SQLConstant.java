package com.app.utill;

public class SQLConstant {
	public static final String SQL_SAVE_EMPLYEE="INSERT INTO EMPLOYEE (id, name, dept, age) VALUES(?,?,?,?)";
	public static final String SQL_UPDATE_EMPLYEE = "UPDATE EMPLOYEE SET name=?, dept=?, age=?  WHERE id=?";
	public static final String SQL_ALL_EMPLYEE="SELECT * FROM EMPLOYEE";
	public static final String SQL_DELETE_EMPLYEE="DELETE FROM EMPLOYEE WHERE ID=?";
	public static final String SQL_GET_EMPLYEE="SELECT * FROM EMPLOYEE WHERE ID=?";

}
