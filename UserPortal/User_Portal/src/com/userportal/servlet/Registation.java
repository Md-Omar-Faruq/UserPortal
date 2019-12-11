package com.userportal.servlet;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.*;
import java.time.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.userportal.java.CalculationAge;
import com.userportal.java.EncDenc;


@WebServlet("/register")
public class Registation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Connection connection = null;
	PreparedStatement preparedStat = null;
	
	
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

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		
		
		String firstName,lastName,address,phone,email,birthDate,password;
		
		firstName = request.getParameter("first_name");
		lastName = request.getParameter("last_name");
		address = request.getParameter("adds");
		phone = request.getParameter("phone");
		email = request.getParameter("email");
		birthDate = request.getParameter("birth");
		password = EncDenc.encrypt(request.getParameter("pass"));
		
		
		
		String ageArr[] = birthDate.split("-");
		
		
		int years = Integer.parseInt(ageArr[0]);
		int month = Integer.parseInt(ageArr[1]);
		int day = Integer.parseInt(ageArr[2]);
	    int currentAge = CalculationAge.getAge(day, month, years);
		
		try {
			
			dbCon();
			String quary = "INSERT INTO user(firstName,lastName,address,phone,email,birthDate,pass,age) VALUES(?,?,?,?,?,?,?,?)";
			
			preparedStat = connection.prepareStatement(quary);
			preparedStat.setString(1, firstName);
			preparedStat.setString(2, lastName);
			preparedStat.setString(3, address);
			preparedStat.setString(4, phone);
			preparedStat.setString(5, email);
			preparedStat.setString(6, birthDate);
			preparedStat.setString(7, password);
			preparedStat.setInt(8, currentAge);
			
			preparedStat.executeUpdate();
			
			RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
			rd.forward(request, response);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
