package com.cjc.emsapp.app.daoimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.SortOrder;

import com.cjc.emsapp.app.daoi.EmployeeDaoI;
import com.cjc.emsapp.app.model.Employee;
import com.cjc.emsapp.app.util.JDBCConnectivity;

public class EmployeeDaoImpl implements EmployeeDaoI{

	@Override
	public void addEmployee(Employee e) {
		
		try {
			Connection con=JDBCConnectivity.getConnection();
			String sql="insert into employee values(?,?,?,?)";
			PreparedStatement ps= con.prepareStatement(sql);
			ps.setInt(1, e.getEid());
			ps.setString(2, e.getEname());
			ps.setDouble(3, e.getSalary());
			ps.setString(4, e.getEmailId());
			ps.execute();
			System.out.println("Employee data added....");
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> list=new ArrayList<Employee>();
		try {
			Connection con=JDBCConnectivity.getConnection();
			String sql="select * from employee";
			PreparedStatement ps= con.prepareStatement(sql);
			ResultSet rs= ps.executeQuery();
			while(rs.next())
			{
				Employee e=new Employee();
				e.setEid(rs.getInt(1));
				e.setEname(rs.getString(2));
				e.setSalary(rs.getDouble(3));
				e.setEmailId(rs.getString(4));
				list.add(e);
			}
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Employee> updateEmployee(Employee e) {
		try {
			Connection con=JDBCConnectivity.getConnection();
			String sql="update employee set name=?,salary=?,email=? where eid=?";
			PreparedStatement ps= con.prepareStatement(sql);
			ps.setString(1, e.getEname());
			ps.setDouble(2, e.getSalary());
			ps.setString(3, e.getEmailId());
			ps.setInt(4, e.getEid());
			
			ps.execute();
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		List<Employee> list=this.getAllEmployees();
		return list;
	}

	@Override
	public List<Employee> deleteEmployee(int eid) {
		try {
			Connection con=JDBCConnectivity.getConnection();
			String sql="delete from employee where eid=?";
			PreparedStatement ps= con.prepareStatement(sql);
			ps.setInt(1, eid);
			
			ps.execute();
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return this.getAllEmployees();
	}

	@Override
	public void createEmployeeTable() {
		try {
			Connection con=JDBCConnectivity.getConnection();
			String sql="create table employee(eid int,name varchar(45),salary double,email varchar(45))";
			Statement smt=con.createStatement();
			smt.execute(sql);
			System.out.println("Table created..Succesfully");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

	@Override
	public void dropEmployeeTable() {
		try {
			Connection con=JDBCConnectivity.getConnection();
			String sql="drop table if exists employee;";
			Statement smt=con.createStatement();
			smt.execute(sql);
			System.out.println("Table dropped..Succesfully");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

	@Override
	public Employee loginByEidandName(int eid, String name) {
		Connection con=JDBCConnectivity.getConnection();
		//String sql="select * from employee where username=? and password=?";
		String sql="select * from employee where eid=? and name=?";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, eid);
			ps.setString(2, name);
			
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				Employee e= new Employee();
				e.setEid(rs.getInt(1));
				e.setEname(rs.getString(2));
				e.setSalary(rs.getDouble(3));
				e.setEmailId(rs.getString(4));
				return e;
			}
			else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Employee> SortEmployeeObject(String string) {
		List<Employee> list=new ArrayList<Employee>();
		Connection con=JDBCConnectivity.getConnection();
		String sql="select * from employee order by name "+string;
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs= ps.executeQuery();
			while(rs.next())
			{
				Employee e=new Employee();
				e.setEid(rs.getInt(1));
				e.setEname(rs.getString(2));
				e.setSalary(rs.getDouble(3));
				e.setEmailId(rs.getString(4));
				list.add(e);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
