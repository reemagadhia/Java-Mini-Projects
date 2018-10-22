package com.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.service.UserService;
import com.service_impl.UserServiceImpl;

public class DeleteAddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public DeleteAddressServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int addressId = Integer.parseInt(request.getParameter("id"));
		int userDetailsId =(Integer) session.getAttribute("userDetailsId");
		session.setAttribute("userDetailsId", userDetailsId);
		UserService service = new UserServiceImpl();
		service.deleteAddress(addressId);
		response.sendRedirect("AddressDetails");
	}

}
