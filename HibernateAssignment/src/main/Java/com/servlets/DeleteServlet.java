package com.servlets;

import java.io.IOException;
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

public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DeleteServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		int roleId = (Integer) session.getAttribute("roleId");
		session.setAttribute("roleId", roleId);
		UserService service = new UserServiceImpl();
		
		int userId = Integer.parseInt(request.getParameter("uid"));
		session.setAttribute("userId", userId);
		service.deleteUser(userId);
		response.sendRedirect("Display");
	}

}
