package com.userportal.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.userportal.database.comtroller.DatabaseController;
import com.userportal.model.UserList;


@WebServlet("/HomeController")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	String searchName;
	private DatabaseController dataController;
	@Resource(name="jdbc/user_portal")
	private DataSource dataSource;

	
	public void init() throws ServletException{
		super.init();
		
		try {
			dataController = new DatabaseController(dataSource);
		}catch (Exception e) {
			
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		searchName = request.getParameter("search");
		System.out.print(searchName);
		
		String command = request.getParameter("searchCommand");
		System.out.print(command);
		
		if(command == null) {
			command = "userList";
			}
		
		if(command.equals("userList")) {
			
			try {
				getAllUser(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("serachUser")){
			
			try {
				getSearchUser(request, response);
			} catch (Exception e) {
			e.printStackTrace();
			}
		}
		
		
		
	}

	private void getAllUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		List<UserList> user = dataController.getUser();
		request.setAttribute("user_list", user);
		request.setAttribute("adminLog", "adminlog");
		
		RequestDispatcher dis = request.getRequestDispatcher("/adminPanel.jsp");
		dis.forward(request, response);
		
	}
	
	private void getSearchUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<UserList> user = dataController.getSearchUser(searchName);
		request.setAttribute("search_user_list", user);
		request.setAttribute("adminLog", "search");
		
		RequestDispatcher dis = request.getRequestDispatcher("/adminPanel.jsp");
		dis.forward(request, response);
	}
}
