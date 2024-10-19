package com.cjc.emsapp.app.serviceimpl;

import java.util.List;

import com.cjc.emsapp.app.daoi.EmployeeDaoI;
import com.cjc.emsapp.app.daoimpl.EmployeeDaoImpl;
import com.cjc.emsapp.app.model.Employee;
import com.cjc.emsapp.app.servicei.EmployeeServiceI;

public class EmployeeServiceImpl implements EmployeeServiceI {
	EmployeeDaoI edi=new EmployeeDaoImpl();

	@Override
	public void createEmployeeTable() {
		edi.createEmployeeTable();
		
	}

	@Override
	public void addEmployee(Employee e) {
		edi.addEmployee(e);
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> list= edi.getAllEmployees();
	
		return list;
	}

	@Override
	public List<Employee> updateEmployee(Employee e) {
		List<Employee> list=edi.updateEmployee(e);
		return list;
	}

	@Override
	public List<Employee> deleteEmployee(int eid) {
		List<Employee> list=edi.deleteEmployee(eid);
		return list;
	}

	@Override
	public void dropEmployeeTable() {
		edi.dropEmployeeTable();
		
	}

	@Override
	public Employee loginByEidandName(int eid, String name) {
		Employee e =edi.loginByEidandName(eid, name);
		return e;
	}

	@Override
	public List<Employee> SortEmployeeObject(String name) {
		return edi.SortEmployeeObject(name);
		
	}

	
	
}
