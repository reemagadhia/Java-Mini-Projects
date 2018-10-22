package com.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pojo.Address;
import com.pojo.User;
import com.pojo.UserDetails;
import com.service.UserService;
import com.service_impl.UserServiceImpl;

public class EditOtherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public EditOtherServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("status")== "true"){
		UserService service = new UserServiceImpl();
		String userName = request.getParameter("uname");
		String password = request.getParameter("pwd");
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		
		int userId = (Integer)session.getAttribute("userId");
		int userDetailsId = Integer.parseInt(request.getParameter("userDetailsId"));
		
		User user = new User(userId);
		user.setUserName(userName);
		user.setPassword(password);
		UserDetails userDetails = new UserDetails(fname, lname, email, mobile,user);
		userDetails.setUserDetailsId(userDetailsId);
		Address address = service.getAddressById(userDetailsId);
		List<Address> addresses = new ArrayList<Address>();
		addresses.add(address);
		userDetails.setAddress(addresses);
		user.setUserDetails(userDetails);
		service.updateUser(user);
		session.setAttribute("status", "true");
		response.sendRedirect("Display");
	}
	else
	{
		session.setAttribute("status", "false");
	 	response.sendRedirect("index.jsp");
	}
	}

}
