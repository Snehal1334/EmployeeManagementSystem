package com.cjc.emsapp.app.client;

import java.util.List;
import java.util.Scanner;

import com.cjc.emsapp.app.model.Employee;
import com.cjc.emsapp.app.servicei.EmployeeServiceI;
import com.cjc.emsapp.app.serviceimpl.EmployeeServiceImpl;

public class TestUI {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		EmployeeServiceI esi=new EmployeeServiceImpl();
		while(true)
		{
			System.out.println("******EMSAPP******");
			System.out.println("0.Login");
			System.out.println("1.AddEmployee");
			System.out.println("2.viewEmployee");
			System.out.println("3.updateEmployee");
			System.out.println("4.deleteEmployee");
			System.out.println("5.createEmployeeTable");
			System.out.println("6.DropEmployeeTable");
			System.out.println("7.Sort by employee name");
			System.out.println("Enter your choice: ");
			int ch=sc.nextInt();
			
			if(ch==0) {
				System.out.println("Enter ID");
				int eid=sc.nextInt();
				System.out.println("Enter name");
				String name=sc.next();
				Employee e1=esi.loginByEidandName(eid, name);
				if(e1!=null) {
					System.out.println(e1.getEid());
					System.out.println(e1.getEname());
					System.out.println(e1.getSalary());
					System.out.println(e1.getEmailId());
				}
				else {
					System.out.println("Invalid Creatial....");
				}
			}
			else {
			if(ch==1) {
				Employee e=new Employee();
				System.out.println("Enter ID");
				e.setEid(sc.nextInt());
				System.out.println("Enter Name");
				e.setEname(sc.next());
				System.out.println("Enter Salary");
				e.setSalary(sc.nextDouble());
				System.out.println("Enter EmailID");
				e.setEmailId(sc.next());
				esi.addEmployee(e);
			}
			else if(ch==2)
			{
				List<Employee> list =esi.getAllEmployees();
				for (Employee e : list) {
					System.out.println(e.getEid());
					System.out.println(e.getEname());
					System.out.println(e.getSalary());
					System.out.println(e.getEmailId());
				}
			}
			else if(ch==3)
			{
				Employee e=new Employee();
				System.out.println("******Update Details*******");
				System.out.println("Enter Name");
				e.setEname(sc.next());
				System.out.println("Enter Salary");
				e.setSalary(sc.nextDouble());
				System.out.println("Enter EmailID");
				e.setEmailId(sc.next());
				System.out.println("Enter the id for update employee objects.");
				e.setEid(sc.nextInt());
				
				List<Employee> list= esi.updateEmployee(e);
				
				System.out.println("Updated Details...");
				for (Employee e1 : list) {
					System.out.println(e1.getEid());
					System.out.println(e1.getEname());
					System.out.println(e1.getSalary());
					System.out.println(e1.getEmailId());
				}
			}
			else if(ch==4)
			{
				System.out.println("*******Delete Employee*******");
				System.out.println("Enter the id for delete Employee objects.");
				int empId=sc.nextInt();
				List<Employee> list =esi.deleteEmployee(empId);
				System.out.println("Updated Details...");
				for (Employee e1 : list) {
					System.out.println(e1.getEid());
					System.out.println(e1.getEname());
					System.out.println(e1.getSalary());
					System.out.println(e1.getEmailId());
				}
			}
			else if(ch==5)
			{
				System.out.println("*******Create Table*******");
				esi.createEmployeeTable();
				
			}
			else if(ch==6)
			{
				System.out.println("*******Drop Table********");
				esi.dropEmployeeTable();
			}
			else if(ch==7)
			{
				List<Employee> list=null;
				System.out.println("*******Sort By Employee Name********");
				System.out.println("Enter 'asc' for ascending or 'desc' for decending order:");
				String sortOrder=sc.next();
				if(sortOrder.equals("asc"))
				{
					list=esi.SortEmployeeObject("ASC");
					
				}else {
					if(sortOrder.equals("desc")) {
						list=esi.SortEmployeeObject("DESC");
					}
				}
				
				list.forEach(s->{
					System.out.println(s.getEid());
					System.out.println(s.getEname());
					System.out.println(s.getSalary());
					System.out.println(s.getEmailId());
				});
			}
			else {
				System.out.println("Invalid Input!");
			}
			}
		}
		
	}

}
