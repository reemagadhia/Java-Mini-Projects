<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.service_impl.UserServiceImpl"%>
<%@page import="com.pojo.UserDetails"%>
<%@page import="java.util.List"%>
<%@page import="com.pojo.User"%>
<%@page import="com.service.UserService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="http://localhost:8080/HibernateAssignment/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="http://localhost:8080/HibernateAssignment/css/mystyle.css" />
<script src="http://localhost:8080/HibernateAssignment/js/jquery.min.js"></script>
<script src="http://localhost:8080/HibernateAssignment/js/bootstrap.min.js"></script>
</head>
<body>
<%
	String status = (String)session.getAttribute("status");
	if(status == null || status == "false"){
		session.setAttribute("status", "false");
		response.sendRedirect("index.jsp");
	}
	else
	{
		session.setAttribute("status", "true");
	}
%>
	
	<center>
		<div class="container-fluid">
			<div class="header">
				<h2>Home</h2>
				<div class="menu">
					<a href="Display" class="btn btn-menu" role="button">Home</a>
					<a href="" class="btn btn-menu" role="button">Edit Profile</a>
				</div>
				<div class="menu-logout">
					<a href="LogoutServlet" class="btn btn-logout" role="button">Logout</a>
				</div>
			</div>
		</div>
		<table class="table table-bordered" id ="userTable">

			<%
			try{
				UserService service = new UserServiceImpl();
				int roleId = (Integer) session.getAttribute("roleId");
				session.setAttribute("status", "true");
				if (roleId == 1) {
					
			%>
			
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Email</th>
				<th>Mobile No.</th>
				<th colspan="3">Actions</th>
			</tr>
			<%
			ArrayList<User> list = (ArrayList<User>)service.getUsers();
			if(list!=null){
				for (User user : list) {
			%>
			<tr>
				<td><%=user.getUserDetails().getFirstName()%></td>
				<td><%=user.getUserDetails().getLastName()%></td>
				<td><%=user.getUserDetails().getEmail()%></td>
				<td><%=user.getUserDetails().getMobileNo()%></td>
				<td colspan="3"><a href="AddressDetails?id=<%=user.getUserDetails().getUserDetailsId()%>" class="btn btn-address btn-sm" role="button">Address</a>
				<a href="EditAdmin?uid=<%=user.getUserId()%>&udid=<%=user.getUserDetails().getUserDetailsId()%>" class="btn btn-edit btn-sm" role="button">Edit</a>
				<a href="DeleteServlet?uid=<%=user.getUserId()%>" class="btn btn-delete btn-sm" role="button">Delete</a></td>
			</tr>
			<%
				}
				}
			%> 
			<tr>
				<td colspan="7"><a href="Register">+ Add New User</a></td>
			</tr>	
			<%}else {
					int userId = (Integer) session.getAttribute("userId");
					User user = service.getUsersById(userId);
			%>
			<tr>
				<th>User Name</th>
				<th>Password</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Email</th>
				<th>Mobile No.</th>
				<th colspan="3">Actions</th>
			</tr>
			<tr>
				<td><%=user.getUserName()%></td>
				<td><%=user.getPassword()%></td>
				<td><%=user.getUserDetails().getFirstName()%></td>
				<td><%=user.getUserDetails().getLastName()%></td>
				<td><%=user.getUserDetails().getEmail()%></td>
				<td><%=user.getUserDetails().getMobileNo()%></td>
				<td colspan="3"><a href="AddressDetails?id=<%=user.getUserDetails().getUserDetailsId()%>" class="btn btn-edit btn-sm" role="button">Address</a>
				<a href="EditOther?uid=<%=user.getUserId()%>&udid=<%=user.getUserDetails().getUserDetailsId()%>" class="btn btn-edit btn-sm" role="button">Edit</a></td>
			</tr>
			<%
				}
			}
			catch(Exception E){
				session.setAttribute("status", "false");
				response.sendRedirect("index.jsp");
			}
			%>
		</table>
	</center>
</body>
</html>