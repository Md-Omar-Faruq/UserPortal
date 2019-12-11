package com.userportal.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.userportal.controller.*;
import com.userportal.java.EncDenc;
import com.userportal.model.User;


@WebServlet("/passChange")
public class ChangePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Connection connection = null;
	PreparedStatement preparstat = null;
	
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
		
		int id = User.getId();
		String email = User.getEmail();
		String pass = User.getPass();
		
		String previousPass = request.getParameter("previouspass");
		String newPass = request.getParameter("newpass");
		String conPass = request.getParameter("conpass");
		
		if(pass.equals(previousPass)) {
			
			try {
					if(newPass.equals(conPass)) {
						
					dbCon();
					String quary = "update user set pass=? where id = ?";
					preparstat = connection.prepareStatement(quary);
					//preparstat.setString(1, newPass);
					preparstat.setString(1, EncDenc.encrypt(newPass));
					preparstat.setInt(2, id);
					
					preparstat.executeUpdate();
					
					User.setPass(newPass);
					
					 out.println("<script type='text/javascript'>");
					
					 out.println("alert('Password Change Successfull..');");
					 out.println("location='changePassword.jsp';");
					 out.println("</script>");
					
					
				}else {
					   out.println("<script type='text/javascript'>");
					   out.println("alert('Not equal New and Confirm Password..!');");
					   out.println("location='changePassword.jsp';");
					   out.println("</script>");
				}	
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}else {
			
			   out.println("<script type='text/javascript'>");
			   out.println("alert('Previous Password is Incorrect..!');");
			   out.println("location='changePassword.jsp';");
			   out.println("</script>");
		}
		
	}

}
