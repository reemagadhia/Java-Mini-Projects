<%@page import="com.pojo.Address"%>
<%@page import="com.service_impl.UserServiceImpl"%>
<%@page import="com.service.UserService"%>
<%@page import="com.pojo.User"%>
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

<div class="container-fluid">
	<div class="header">
		<h2>Edit Address</h2>
		<div class="menu">
			<a href="Display" class="btn btn-menu" role="button">Home</a>
			<a href="" class="btn btn-menu" role="button">Edit Profile</a>
		</div>
		<div class="menu-logout">
			<a href="LogoutServlet" class="btn btn-logout" role="button">Logout</a>
		</div>
	</div>
</div>
<%
	int userDetailsId = Integer.parseInt(request.getParameter("udid"));
	UserService service = new UserServiceImpl();
	int addressId = Integer.parseInt(request.getParameter("aid"));
	Address address = service.getAddressById(addressId);
	session.setAttribute("addressId", addressId);
%>
<div class="container-fluid">
	<div class="content">
		<div class="container">
			<form class="form-horizontal" action="EditAddressServlet" method="post">
			  <div class="form-group">
			    <label class="control-label col-sm-5" for="city">Street Name:</label>
			    <div class="col-sm-7"> 
			      <input type="text" class="form-control" id="street" name="street" placeholder="Enter Street Name" value ="<%=address.getStreetName()%>">
			    </div>
			  </div>
			   <input type="hidden" name="userDetailsId" value=<%=userDetailsId%>>
			  <div class="form-group">
			    <label class="control-label col-sm-5" for="city">City Name:</label>
			    <div class="col-sm-7"> 
			      <input type="text" class="form-control" id="city" name="city" placeholder="Enter City Name" value ="<%=address.getCityName() %>">
			    </div>
			  </div>
			  <div class="form-group">
			    <label class="control-label col-sm-5" for="pincode">Pin Code:</label>
			    <div class="col-sm-7"> 
			      <input type="text" class="form-control" id="pincode" name="pincode" placeholder="Enter Pin Code" value ="<%=address.getPincode() %>">
			    </div>
			  </div>
			  <div class="col-sm-offset-5 col-sm-7">
			    <div class="form-group"> 
			      <button type="submit" class="btn btn-submit btn-md ">Edit</button>
			    </div>
			  </div>
			</form>
		</div>
	</div>
</div>
</body>
</html>