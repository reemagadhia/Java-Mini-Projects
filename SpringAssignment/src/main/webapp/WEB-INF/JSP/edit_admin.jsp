<%@page import="com.pojo.User"%>
<%@page import="com.service_impl.UserServiceImpl"%>
<%@page import="com.service.UserService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">
    <%@include file="../css/bootstrap.min.css" %>
    <%@include file="../css/mystyle.css" %>
  </style>
  <script type="text/javascript">
	  <%@include file="../js/jquery.min.js" %>
	  <%@include file="../js/bootstrap.min.js" %>
	  <%@include file="../js/myscript.js" %>
  </script>
</head>
<body>

<div class="container-fluid">
	<div class="header">
				<h2>Edit</h2>
				<div class="menu">
					<a href="Display" class="btn btn-menu" role="button">Home</a>
				</div>
				<div class="menu-logout">
					<a href="" id ="logout" class="btn btn-logout" role="button">Logout</a>
				</div>
			</div>
</div>
<%
	int userDetailsId = (Integer) session.getAttribute("userDetailsId");
	User user = (User)session.getAttribute("user");
%>
<div class="container-fluid">
	<div class="content">
		<div class="container">
		<form class="form-horizontal" action="EditAdminServlet" method="post">
			 <div class="form-group">
			    <label class="control-label col-sm-5" for="fname"><span class="required">*</span> First Name:</label>
			    <div class="col-sm-3">
			      <input type="text" class="form-control" id="fname" name="fname" placeholder="Enter First Name" value="<%=user.getUserDetails().getFirstName()%>">
			    </div>
			    <div class="col-sm-4" id="fnameerror">
			    </div>
			  </div>
			  <input type="hidden" name="userDetailsId" value=<%=userDetailsId%>>
			  <div class="form-group">
			    <label class="control-label col-sm-5" for="lname">Last Name:</label>
			    <div class="col-sm-7"> 
			      <input type="text" class="form-control" id="lname" name="lname" placeholder="Enter Last Name" value="<%=user.getUserDetails().getLastName()%>">
			    </div>
			  </div>
			   <div class="form-group">
			    <label class="control-label col-sm-5">Role:</label>
			    <div class="col-sm-7"> 
			    <%
			    int roleId = user.getRole().getRoleId();
			    if(roleId == 1){
			    %>
			   		<label class="radio-inline"><input type="radio" id="opt1" name="role" value="Admin" checked>Admin</label>
					<label class="radio-inline"><input type="radio" id="opt2" name="role" value="Buyer">Buyer</label>
				<%
			    }else{
				%>
					<label class="radio-inline"><input type="radio" id="opt1" name="role" value="Admin">Admin</label>
					<label class="radio-inline"><input type="radio" id="opt2" name="role" value="Buyer" checked>Buyer</label>
				<%
			    }
				%>
			    </div>
			  </div>
			  <div class="form-group">
			    <label class="control-label col-sm-5" for="email"><span class="required">*</span> Email:</label>
			    <div class="col-sm-3"> 
			      <input type="text" class="form-control" id="email" name="email" placeholder="Enter Email" value="<%=user.getUserDetails().getEmail()%>">
			    </div>
			    <div class="col-sm-4" id="emailerror">
			    </div>
			  </div>
			  <div class="form-group">
			    <label class="control-label col-sm-5" for="mobile"><span class="required">*</span> Mobile No:</label>
			    <div class="col-sm-3"> 
			      <input type="text" class="form-control" id="mobile" name="mobile" placeholder="Enter Mobile No" value="<%=user.getUserDetails().getMobileNo()%>" onblur="mobile_validation()">
			    </div>
			  	<div class="col-sm-4" id="moerror">
			    </div>
			    </div>
			  <div class="col-sm-offset-5 col-sm-7">
			    <div class="form-group"> 
			      <button type="submit" id="register" class="btn btn-submit btn-md">Edit</button>
			    </div>
			  </div>
		</form>
		</div>
	</div>
</div>
</body>
</html>