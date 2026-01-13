package com.qsp.employee_management_system.controller;

import java.util.*;
import java.util.Scanner;

import com.qsp.employee_management_system.dao.EmployeeDao;
import com.qsp.employee_management_system.entity.Employee;

public class EmployeeController {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		EmployeeDao dao=new EmployeeDao();
		while(true) {
			System.out.println("**************** WELCOME TO EMPLOYEE MANAGEMENT SYSTEM *******************");
			System.out.println("1. Insert Employee Details!!");
			System.out.println("2. Display Employee Details!!");
			System.out.println("3. Fetch Employee Record Based on Employee ID!!");
			System.out.println("4. Delete Employee based on ID!!");
			System.out.println("5. Update Employee Details based on ID!!");
			System.out.println("6. Exit");
			System.out.println("Please select choice!!");
			int choice=sc.nextInt();
			
			switch(choice) {
				case 1:{
					System.out.println("Enter Employee ID: ");
					int empid=sc.nextInt();
					
					sc.nextLine();
					
					System.out.println("Enter Employee Name: ");
					String ename=sc.nextLine();
					
					System.out.println("Enter Employee Email: ");
					String email=sc.nextLine();
					
					System.out.println("Enter Employee Salary: ");
					double salary=sc.nextDouble();
					
					System.out.println("Enter Employee Age: ");
					int age=sc.nextInt();
					
					Employee emp=new Employee();
					emp.setEmpid(empid);
					emp.setEname(ename);
					emp.setEmail(email);
					emp.setSalary(salary);
					emp.setAge(age);
					
					
					boolean b=dao.saveEmployee(emp);
					if(b)
						System.out.println("Data is inserted Successfully!!!!!!!!!!!!!!!!!");
					else
						System.out.println("Data is not inserted");
				}
				break;
				case 2:{
					System.out.println("**************Employee Details***************");
	
					List<Employee> emp=dao.getAllEmployee();
					if(emp!=null) {
						for(Employee e:emp) {
							System.out.println(e.getEmpid());
							System.out.println(e.getEname());
							System.out.println(e.getEmail());
							System.out.println(e.getSalary());
							System.out.println(e.getAge());
							System.out.println("-------------------------------------");
						}
					}else {
						System.out.println("Table is empty!!!!!!");
					}
					
				}
				break;
				case 3:{
					
					System.out.println("Please provide Empid to fetch record");
					int empid=sc.nextInt();
					Employee emp=dao.getEmployeeById(empid);
					
					if(emp!=null) {
						System.out.println("Empid: "+emp.getEmpid());
						System.out.println("Name: "+emp.getEname());
						System.out.println("Email: "+emp.getEmail());
						System.out.println("Salary: "+emp.getSalary());
						System.out.println("Age: "+emp.getAge());
					}else {
						System.err.println("given id is not found");
					}
				}
				break;
				case 4:{
					System.out.println("Please provide Employee ID to delete record");
					int empid=sc.nextInt();
					boolean b=dao.deleteEmployeeById(empid);
					if(b) {
						System.out.println("Record is deleted!!");
					}
					else {
						System.err.println("given id not found!!");
					}
					
				}
				break;
				case 5:{
					System.out.println("Please provide Employee id");
					int empid=sc.nextInt();
					sc.nextLine();
					System.out.println("Enter the name to be updated");
					String ename=sc.nextLine();
					boolean b=dao.updateEmployeeById(empid, ename);
					if(b)
						System.out.println("Record is updated!!");
					else
						System.err.println("given id not found!!");
				}
				break;
				case 6:{
					System.out.println("Sucessfully Exited!!");
					System.exit(0);
				}
				break;
				default:System.err.println("Enter valid Choice");
			}
		}
	}
}


