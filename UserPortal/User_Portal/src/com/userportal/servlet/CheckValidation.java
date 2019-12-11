package com.userportal.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/CheckValidation")
public class CheckValidation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	
	Connection connection = null;
	PreparedStatement preparedStat = null;
	ResultSet resultSet = null;
    
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
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String userEmail = request.getParameter("email");
		
		String quary = "select * from user where email=?";
		
		try {
			dbCon();
			preparedStat = connection.prepareStatement(quary);
			preparedStat.setString(1, userEmail);
			resultSet = preparedStat.executeQuery();
			
			if(resultSet.next()) {
				out.print("<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
				out.print("This Email Address Already Exists Change This..!!");
			}else {
				response.setContentType("text/html");
				out.print("");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
