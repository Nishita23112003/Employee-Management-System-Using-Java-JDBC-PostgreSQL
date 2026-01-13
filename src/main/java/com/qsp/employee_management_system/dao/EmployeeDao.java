package com.qsp.employee_management_system.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.qsp.employee_management_system.connection.GetConnection;
import com.qsp.employee_management_system.entity.Employee;

public class EmployeeDao {
	Connection con=GetConnection.getConnectionObject();
	public boolean saveEmployee(Employee emp) {
		String insertQuery="insert into employee values(?,?,?,?,?)";
		try {
			PreparedStatement pstm=con.prepareStatement(insertQuery);
			pstm.setInt(1, emp.getEmpid());
			pstm.setString(2, emp.getEname());
			pstm.setString(3, emp.getEmail());
			pstm.setDouble(4, emp.getSalary());
			pstm.setInt(5, emp.getAge());
			int row=pstm.executeUpdate();
			con.close();
			return row>0;
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public List<Employee> getAllEmployee(){
		String selectQuery="select * from employee";
		List<Employee>empList=new ArrayList<Employee>();
		try {
			PreparedStatement pstm=con.prepareStatement(selectQuery);
			ResultSet res=pstm.executeQuery();
			while(res.next()) {
				int empid=res.getInt("empid");
				String ename=res.getString("ename");
				String email=res.getString("email");
				double salary=res.getDouble("salary");
				int age=res.getInt("age");
				
				Employee emp=new Employee();
				emp.setEmpid(empid);
				emp.setEname(ename);
				emp.setEmail(email);
				emp.setSalary(salary);
				emp.setAge(age);
				
				empList.add(emp);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return empList;
	}
	
	public Employee getEmployeeById(int id) {
		String sql="select * from employee where empid=?";
		try {
			PreparedStatement pstm=con.prepareStatement(sql);
			pstm.setInt(1, id);
			ResultSet set=pstm.executeQuery();
			if(set.next()) {
				int empid=set.getInt("empid");
				String name=set.getString("ename");
				String email=set.getString("email");
				double salary =set.getDouble("salary");
				int age=set.getInt("age");
				
				//bind data into object
				Employee e=new Employee();
				e.setEmpid(empid);
				e.setEname(name);
				e.setEmail(email);
				e.setSalary(salary);
				e.setAge(age);
				
				return e;
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean deleteEmployeeById(int id) {
		String sql="delete from employee where empid=?";
		
		try {
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setInt(1, id);
			int row=pstm.executeUpdate();
			return row>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean updateEmployeeById(int id,String name) {
		String sql="update employee set ename=? where empid=?";
		try {
			PreparedStatement pstm=con.prepareStatement(sql);
			pstm.setString(1, name);
			pstm.setInt(2, id);
			int row=pstm.executeUpdate();
			return row>0;
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
