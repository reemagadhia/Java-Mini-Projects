
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
		<h2>Edit</h2>
	</div>
</div>
<%
	int userDetailsId = Integer.parseInt(request.getParameter("udid"));
	int userId = Integer.parseInt(request.getParameter("uid"));
	session.setAttribute("userId", userId);
	UserService service = new UserServiceImpl();
	User user = (User)request.getAttribute("user");
	
%>
<div class="container-fluid">
	<div class="content">
		<div class="container">
			<form class="form-horizontal" action="EditOtherServlet" method="post">
			  <div class="form-group">
			    <label class="control-label col-sm-5" for="uname">Username:</label>
			    <div class="col-sm-7">
			      	<input type="text" class="form-control" id="uname" name="uname" placeholder="Enter Username" value="<%=user.getUserName() %>">
			    </div>
			  </div>
			  <div class="form-group">
			    <label class="control-label col-sm-5" for="pwd">Password:</label>
			    <div class="col-sm-3"> 
			      	<input type="password" class="form-control" id="pwd" name="pwd" placeholder="Enter Password" value="<%=user.getPassword() %>" onblur="password_validation(),check_password()">
			    </div>
			    <div class="col-sm-4" id="pwderror">
			    </div>
			  </div>
			  <input type="hidden" name="userDetailsId" value=<%=userDetailsId%>>
			  <div class="form-group">
			    <label class="control-label col-sm-5" for="cfmpwd">Confirm Password:</label>
			    <div class="col-sm-3"> 
			      	<input type="password" class="form-control" id="cfmpwd" name="cfmpwd" placeholder="Confirm Password" value="<%=user.getPassword() %>" onblur="check_password()">
			    </div>
			    <div class="col-sm-4" id="pwderror">
			    </div>
			  </div>
			  <div class="form-group">
			    <label class="control-label col-sm-5" for="fname">First Name:</label>
			    <div class="col-sm-7">
			      <input type="text" class="form-control" id="fname" name="fname" placeholder="Enter First Name" value="<%=user.getUserDetails().getFirstName()%>">
			    </div>
			  </div>
			  <div class="form-group">
			    <label class="control-label col-sm-5" for="lname">Last Name:</label>
			    <div class="col-sm-7"> 
			      <input type="text" class="form-control" id="lname" name="lname" placeholder="Enter Last Name" value="<%=user.getUserDetails().getLastName()%>">
			    </div>
			  </div>
			  <div class="form-group">
			    <label class="control-label col-sm-5" for="email">Email:</label>
			    <div class="col-sm-7"> 
			      <input type="text" class="form-control" id="email" name="email" placeholder="Enter Email" value="<%=user.getUserDetails().getEmail()%>">
			    </div>
			  </div>
			  <div class="form-group">
			    <label class="control-label col-sm-5" for="mobile">Mobile No:</label>
			    <div class="col-sm-3"> 
			      <input type="text" class="form-control" id="mobile" name="mobile" placeholder="Enter Mobile No" value="<%=user.getUserDetails().getMobileNo()%>" onblur="mobile_validation()">
			    </div>
			    <div class="col-sm-4" id="moerror">
			    </div>
			  </div>
			  <div class="col-sm-offset-5 col-sm-7">
			    <div class="form-group"> 
			      <button type="submit" class="btn btn-submit btn-md">Edit</button>
			    </div>
			  </div>
			</form>
		</div>
	</div>
</div>
<script src="http://localhost:8080/HibernateAssignment/js/myscript.js"></script>
</body>
</html>