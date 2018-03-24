package com.app.dao;

import java.sql.ResultSet;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.model.Employee;
import com.app.utill.SQLConstant;

/**
 * @author alam This class used for communicate with DB to get data and save
 *         update and delete data
 *
 */
@Repository
@Transactional
public class EmployeeDAOImpl implements EmployeeDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
/*public EmployeeDAOImpl(DataSource ds) {
	jdbcTemplate=new JdbcTemplate(ds);
}*/

	@Override
	public int saveEmployee(Employee emp) {
		System.out.println("DAO  " + emp.getId() + " " + emp.getName() + " " + emp.getDept() + " " + emp.getAge());
		System.out.println(emp.getId() + " " + emp.getName() + " " + emp.getDept() + " " + emp.getAge());
		return jdbcTemplate.update(SQLConstant.SQL_SAVE_EMPLYEE, emp.getId(), emp.getName(), emp.getDept(),
				emp.getAge());
	}

	@Override
	public List<Employee> empList() {
		System.out.println("Employee List Employee DAO ");
		return jdbcTemplate.query(SQLConstant.SQL_ALL_EMPLYEE, (ResultSet rs, int ronum) -> {
			Employee emp = new Employee();
			emp.setId(rs.getInt(1));
			emp.setName(rs.getString(2));
			emp.setDept(rs.getString(3));
			emp.setAge(rs.getInt(4));
			return emp;
		});
	}

	@Override
	public void deleteEmployee(int eId) {
		jdbcTemplate.update(SQLConstant.SQL_DELETE_EMPLYEE, eId);

	}

	@Override
	public Employee get(int eId) {

		return jdbcTemplate.queryForObject(SQLConstant.SQL_GET_EMPLYEE, (rs, rowNum) -> {
			Employee emp = new Employee();
			emp.setId(rs.getInt(1));
			emp.setName(rs.getString(2));
			emp.setDept(rs.getString(3));
			emp.setAge(rs.getInt(4));
			return emp;
		}, eId);

	}

	@Override
	public int updateEmployee(Employee emp) {

		return jdbcTemplate.update(SQLConstant.SQL_UPDATE_EMPLYEE, 
				emp.getName(), emp.getDept(), emp.getAge(),emp.getId());

	}

}
