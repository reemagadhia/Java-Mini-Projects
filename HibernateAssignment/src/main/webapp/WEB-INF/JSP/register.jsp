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
		<h2>Register</h2>
	</div>
</div>
<div class="container-fluid">
	<div class="content">
		<div class="container">
			<form class="form-horizontal" action="UserDataServlet" method="post">
			<div class="row">
			  <div class="form-group">
			    <label class="control-label col-sm-5" for="uname">Username:</label>
			    <div class="col-sm-7">
			      	<input type="text" class="form-control" id="uname" name="uname" placeholder="Enter Username">
			    </div>
			  </div>
			  <div class="form-group">
			    <label class="control-label col-sm-5" for="pwd">Password:</label>
			    <div class="col-sm-3"> 
			      	<input type="password" class="form-control" id="pwd" name="pwd" placeholder="Enter Password" onblur="password_validation()">
			    </div>
			    <div class="col-sm-4" id="pwderror">
			    </div>
			  </div>
			  <div class="form-group">
			    <label class="control-label col-sm-5" for="cfmpwd">Confirm Password:</label>
			    <div class="col-sm-3"> 
			      	<input type="password" class="form-control" id="cfmpwd" name="cfmpwd" placeholder="Confirm Password" onblur="check_password()">
			    </div>
			    <div class="col-sm-4" id="cfmpwderror">
			    </div>
			  </div>
			  <div class="form-group">
			    <label class="control-label col-sm-5">Role:</label>
			    <div class="col-sm-7"> 
			   		<label class="radio-inline"><input type="radio" id="opt1" name="role" value="Admin" checked>Admin</label>
					<label class="radio-inline"><input type="radio" id="opt2" name="role" value="Buyer">Buyer</label>
			    </div>
			  </div>
			 
			  <div class="form-group">
			    <label class="control-label col-sm-5" for="fname">First Name:</label>
			    <div class="col-sm-7">
			      <input type="text" class="form-control" id="fname" name="fname" placeholder="Enter First Name">
			    </div>
			  </div>
			  <div class="form-group">
			    <label class="control-label col-sm-5" for="lname">Last Name:</label>
			    <div class="col-sm-7"> 
			      <input type="text" class="form-control" id="lname" name="lname" placeholder="Enter Last Name">
			    </div>
			  </div>
			  <div class="form-group">
			    <label class="control-label col-sm-5" for="email">Email:</label>
			    <div class="col-sm-7"> 
			      <input type="text" class="form-control" id="email" name="email" placeholder="Enter Email">
			    </div>
			  </div>
			  <div class="form-group">
			    <label class="control-label col-sm-5" for="mobile">Mobile No:</label>
			    <div class="col-sm-3"> 
			      <input type="text" class="form-control" id="mobile" name="mobile" placeholder="Enter Mobile No" onblur="mobile_validation()">
			    </div>
			    <div class="col-sm-4" id="moerror">
			    </div>
			  </div>
			  <div class="form-group">
			    <label class="control-label col-sm-5" for="city">Street Name:</label>
			    <div class="col-sm-7"> 
			      <input type="text" class="form-control" id="street" name="street" placeholder="Enter Street Name">
			    </div>
			  </div>
			  <div class="form-group">
			    <label class="control-label col-sm-5" for="city">City Name:</label>
			    <div class="col-sm-7"> 
			      <input type="text" class="form-control" id="city" name="city" placeholder="Enter City Name">
			    </div>
			  </div>
			  <div class="form-group">
			    <label class="control-label col-sm-5" for="pincode">Pin Code:</label>
			    <div class="col-sm-7"> 
			      <input type="text" class="form-control" id="pincode" name="pincode" placeholder="Enter Pin Code">
			    </div>
			  </div>
			  </div>
			  <div class="col-sm-offset-5 col-sm-7">
			    <div class="form-group"> 
			      <button type="submit" class="btn btn-submit btn-md">Register</button>
			    </div>
			  </div>
			</form>
		</div>
	</div>
</div>
<script src="http://localhost:8080/HibernateAssignment/js/myscript.js"></script>
</body>
</html>