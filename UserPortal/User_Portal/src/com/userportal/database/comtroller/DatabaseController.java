package com.userportal.database.comtroller;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.jws.soap.SOAPBinding.Use;
import javax.sql.DataSource;

import com.userportal.model.UserList;

public class DatabaseController {

	private DataSource dataSource;
	
	Connection connection = null;
	Statement statement = null;
	ResultSet resultSet = null;
	PreparedStatement preparedStat = null;
	
	int id;
	String email,pass;
	
	public void dbCon() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/user_portal","root","");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public DatabaseController(DataSource theDataSource) {
		dataSource = theDataSource;
	}
	
	public List<UserList> getUser() throws Exception{
		
		List<UserList> user = new ArrayList<>();		

		try {
			
			dbCon();
			String quary = "select * from user order by firstName";
			statement = connection.createStatement();
			resultSet = statement.executeQuery(quary);
			
			while(resultSet.next()) {
				
				String firstName = resultSet.getString("firstName");
				String lastName = resultSet.getString("lastName");
				String phone = resultSet.getString("phone");
				String email = resultSet.getString("email");
				int age = resultSet.getInt("age");
				
				UserList u = new UserList(firstName, lastName, phone, email, age);
				user.add(u);
			}
			
			return user;
		}finally {
			connection.close();
			resultSet.close();
			statement.close();
		}
		
		
	}
	
	
	public List<UserList> getSearchUser(String name) throws Exception{
		
		List<UserList> user = new ArrayList<>();
		
		try {
			
			dbCon();
			String quary = "SELECT * FROM user WHERE firstName='"+name+"' OR lastName='"+name+"' OR email='"+name+"'";
			preparedStat = connection.prepareStatement(quary);
			resultSet = preparedStat.executeQuery(quary);
			
			while(resultSet.next()) {
				
				
				String firstName = resultSet.getString("firstName");
				String lastName = resultSet.getString("lastName");
				String phone = resultSet.getString("phone");
				String email = resultSet.getString("email");
				int age = resultSet.getInt("age");
				
				UserList u = new UserList(firstName, lastName, phone, email, age);
				user.add(u);
			}
		
			
			return user;
		}finally {
			connection.close();
			resultSet.close();
			preparedStat.close();
		}
		
		
		
	}
	
}
