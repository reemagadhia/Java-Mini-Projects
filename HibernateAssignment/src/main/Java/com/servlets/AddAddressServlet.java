package com.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pojo.Address;
import com.pojo.UserDetails;
import com.service.UserService;
import com.service_impl.UserServiceImpl;


public class AddAddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public AddAddressServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("status")== "true"){
			UserService service = new UserServiceImpl();
			String street = request.getParameter("street");
			String city = request.getParameter("city");
			String pincode = request.getParameter("pincode");
			int userDetailsId = Integer.parseInt(request.getParameter("userDetailsId"));
			UserDetails userDetails = new UserDetails(userDetailsId);
			Address address = new Address();
			address.setStreetName(street);
			address.setCityName(city);
			address.setPincode(pincode);
			address.setUserDetails(userDetails);
			service.addAddress(address);
			session.setAttribute("status", "true");
			response.sendRedirect("AddressDetails");
		}
		else
		{
			session.setAttribute("status", "false");
		 	response.sendRedirect("index.jsp");
		}
	}

}
