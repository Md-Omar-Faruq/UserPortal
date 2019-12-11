package com.userportal.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.userportal.java.EncDenc;
import com.userportal.model.User;


@WebServlet("/login_form")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	Connection connection = null;
	PreparedStatement preparedStat = null;
	ResultSet resultSet = null;
	String id = null;

	private static String email,password;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
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

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String email,password;
		
		email = request.getParameter("email");
		password = request.getParameter("pass");
		String dePass = EncDenc.encrypt(password);
		if(email.equals("admin@localhost.local") && password.equals("admin")) {
			response.sendRedirect("HomeController");
			
		}else if(!password.equals("admin")) {
			
			try {
				dbCon();
				String quary = "select * from user where email=? && pass=?";
				
				preparedStat = connection.prepareStatement(quary);
				
				preparedStat.setString(1, email);
				preparedStat.setString(2, dePass);
				resultSet = preparedStat.executeQuery();
				
				if(resultSet.next()) {
					
					int id = resultSet.getInt("id");
					String firstName = resultSet.getString("firstName");
					String lastName = resultSet.getString("lastName");
					String address = resultSet.getString("address");
					String phone = resultSet.getString("phone");
					String emails = resultSet.getString("email");
					String birthDate = resultSet.getString("birthDate");
					String pass = EncDenc.decrypt(resultSet.getString("pass"));
					
					User user = new User(id, firstName, lastName, address, phone, emails, birthDate, pass);
					response.sendRedirect("profile.jsp");	
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}else {
			   out.println("<script type='text/javascript'>");
			   out.println("alert('User or password incorrect');");
			   out.println("location='login.jsp';");
			   out.println("</script>");
		}
		
		
	}


}
