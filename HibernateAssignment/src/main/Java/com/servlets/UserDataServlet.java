package com.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pojo.Address;
import com.pojo.Role;
import com.pojo.User;
import com.pojo.UserDetails;
import com.service.UserService;
import com.service_impl.UserServiceImpl;


public class UserDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public UserDataServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserService service = new UserServiceImpl();
		HttpSession session = request.getSession();
		
		String userName = request.getParameter("uname");
		String password = request.getParameter("pwd");
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		String street = request.getParameter("street");
		String city = request.getParameter("city");
		String pincode = request.getParameter("pincode");
		
		Role role = new Role();
		String roleType = request.getParameter("role"); 
		if("Admin".equals(roleType)){
			role.setRoleId(1);
			role.setRole("Admin");
		}
		else if("Buyer".equals(roleType)){
			role.setRoleId(2);
			role.setRole("Buyer");
		}
		
		User user = new User(userName, password, role);
		session.setAttribute("user", user);

		
		UserDetails userDetails = new UserDetails(fname, lname, email, mobile, user);
		
		Address address = new Address(street, city, pincode, userDetails);
		
		List<Address> addresses = new ArrayList<Address>();
		addresses.add(address);
		userDetails.setAddress(addresses);
		user.setUserDetails(userDetails);
		service.addUser(user);
		String message = "Registered Successfully";
 		session.setAttribute("registerMessage", message);
		response.sendRedirect("index.jsp");
	}

}
