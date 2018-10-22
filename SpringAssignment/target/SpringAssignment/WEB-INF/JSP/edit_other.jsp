<%@page import="com.service_impl.UserServiceImpl"%>
<%@page import="com.service.UserService"%>
<%@page import="com.pojo.User"%>
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
<%
	int userDetailsId = (Integer) session.getAttribute("userDetailsId");
	User user = (User)session.getAttribute("user");
%>
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
<div class="container-fluid">
	<div class="content">
		<div class="container">
			<form class="form-horizontal" action="EditOtherServlet" method="post">
			  <div class="form-group">
			    <label class="control-label col-sm-5" for="uname"><span class="required">*</span> Username:</label>
			    <div class="col-sm-3">
			      	<input type="text" class="form-control" id="uname" name="uname" placeholder="Enter Username" value="<%=user.getUserName() %>">
			    </div>
			    <div class="col-sm-4" id="unameerror">
			    </div>
			  </div>
			  <div class="form-group">
			    <label class="control-label col-sm-5" for="pwd"><span class="required">*</span> Password:</label>
			    <div class="col-sm-3"> 
			      	<input type="password" class="form-control" id="pwd" name="pwd" placeholder="Enter Password" value="<%=user.getPassword() %>" onblur="password_validation(),check_password()">
			    </div>
			    <div class="col-sm-4" id="pwderror">
			    </div>
			  </div>
			  <input type="hidden" name="userDetailsId" value=<%=userDetailsId%>>
			  <div class="form-group">
			    <label class="control-label col-sm-5" for="cfmpwd"><span class="required">*</span> Confirm Password:</label>
			    <div class="col-sm-3"> 
			      	<input type="password" class="form-control" id="cfmpwd" name="cfmpwd" placeholder="Confirm Password" value="<%=user.getPassword() %>" onblur="check_password()">
			    </div>
			    <div class="col-sm-4" id="cfmpwderror">
			    </div>
			  </div>
			  <div class="form-group">
			    <label class="control-label col-sm-5" for="fname"><span class="required">*</span> First Name:</label>
			    <div class="col-sm-3">
			      <input type="text" class="form-control" id="fname" name="fname" placeholder="Enter First Name" value="<%=user.getUserDetails().getFirstName()%>">
			    </div>
			    <div class="col-sm-4" id="fnameerror">
			    </div>
			  </div>
			  <div class="form-group">
			    <label class="control-label col-sm-5" for="lname">Last Name:</label>
			    <div class="col-sm-7"> 
			      <input type="text" class="form-control" id="lname" name="lname" placeholder="Enter Last Name" value="<%=user.getUserDetails().getLastName()%>">
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