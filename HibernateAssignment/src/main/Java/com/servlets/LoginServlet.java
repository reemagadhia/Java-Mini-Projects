package com.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pojo.Role;
import com.pojo.User;
import com.service.UserService;
import com.service_impl.UserServiceImpl;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		UserService service = new UserServiceImpl();
		String luname = request.getParameter("luname");
		String lpwd = request.getParameter("lpwd");
		String status = "true";
		User user = new User();
		user.setUserName(luname);
		user.setPassword(lpwd);
		
		int userId=0,roleId=0;
		userId= service.checkUser(user);
		
		user = service.getUsersById(userId);
		try{
		roleId = user.getRole().getRoleId();
		session.setAttribute("userId", userId);
		if(userId>0 &&( roleId==1 || roleId ==2)){
			session.setAttribute("status", status);
			session.setAttribute("roleId", roleId);
			response.sendRedirect("Display");
		}
		}
		catch(Exception e)
		{	
			String message = "Incorrect username or password. Please try again.";
	 		session.setAttribute("loginMessage", message);
			session.setAttribute("status","false");
		 	response.sendRedirect("index.jsp");
		}
	}

}
