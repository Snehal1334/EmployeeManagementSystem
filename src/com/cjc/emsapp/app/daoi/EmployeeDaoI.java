package com.cjc.emsapp.app.daoi;

import java.util.List;

import com.cjc.emsapp.app.model.Employee;

public interface EmployeeDaoI {
	public void addEmployee(Employee e);
	public List<Employee> getAllEmployees();
	public List<Employee> updateEmployee(Employee e);
	public List<Employee> deleteEmployee(int eid);
	public void createEmployeeTable();
	public void dropEmployeeTable();
	public Employee loginByEidandName(int eid,String name);
	public List<Employee> SortEmployeeObject(String string);

}
