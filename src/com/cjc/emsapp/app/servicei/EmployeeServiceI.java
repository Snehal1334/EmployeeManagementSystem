package com.cjc.emsapp.app.servicei;

import java.util.List;

import com.cjc.emsapp.app.model.Employee;

public interface EmployeeServiceI {
	public void createEmployeeTable();
	public void addEmployee(Employee e);
	public List<Employee> getAllEmployees();
	public List<Employee> updateEmployee(Employee e);
	public List<Employee> deleteEmployee(int eid);
	public void dropEmployeeTable();
	public Employee loginByEidandName(int eid,String name);
	public List<Employee> SortEmployeeObject(String string);
	
}
