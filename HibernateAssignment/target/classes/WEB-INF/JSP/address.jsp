<%@page import="java.util.ArrayList"%>
<%@page import="com.pojo.Address"%>
<%@page import="com.service_impl.UserServiceImpl"%>
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
		<table class="table table-bordered" id="addressTable">
		
			<tr>
				<th>Street</th>
				<th>City</th>
				<th>Pincode</th>
				<th colspan="2">Actions</th>
			</tr>
		<%
		int userDetailsId = 0;
			UserService service = new UserServiceImpl();
			try{
				userDetailsId = Integer.parseInt(request.getParameter("id"));
				session.setAttribute("userDetailsId",userDetailsId);
				session.setAttribute("status", "true");
			}catch(Exception e){
				userDetailsId =(Integer) session.getAttribute("userDetailsId");
			}
			%>
			<%
			ArrayList<Address> list = (ArrayList<Address>) service.getAddresses(userDetailsId);
			for (Address address : list) {
			%>
			<tr>
				<td><%=address.getStreetName()%></td>
				<td><%=address.getCityName()%></td>
				<td><%=address.getPincode()%></td>
				<td colspan="2"><a href="EditAddress?aid=<%=address.getAddressId()%>&udid=<%=userDetailsId%>" class="btn btn-edit btn-sm" role="button">Edit</a>
				<a href="DeleteAddressServlet?id=<%=address.getAddressId()%>" class="btn btn-delete btn-sm" role="button">Delete</a></td>
			</tr>
			<%
			}
			%>
			<tr>
				<td colspan="4"><a href="AddAddress?id=<%=userDetailsId%>">+ Add New Address</a></td>
			</tr>
		</table>
</center>
</body>
</html>