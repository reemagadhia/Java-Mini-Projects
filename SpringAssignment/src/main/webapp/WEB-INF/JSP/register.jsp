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
		<h2>Register</h2>
	</div>
</div>
<div class="container-fluid">
	<div class="content">
		<div class="container">
			<form class="form-horizontal" action="AddDataServlet" method="post">
			<div class="row">
			  <div class="form-group">
			    <label class="control-label col-sm-5" for="uname"><span class="required">*</span> Username:</label>
			    <div class="col-sm-3">
			      	<input type="text" class="form-control" id="uname" name="uname" placeholder="Enter Username">
			    </div>
			    <div class="col-sm-4" id="unameerror">
			    </div>
			  </div>
			  <div class="form-group">
			    <label class="control-label col-sm-5" for="pwd"><span class="required">*</span> Password:</label>
			    <div class="col-sm-3"> 
			      	<input type="password" class="form-control" id="pwd" name="pwd" placeholder="Enter Password" onblur="password_validation()">
			    </div>
			    <div class="col-sm-4" id="pwderror">
			    </div>
			  </div>
			  <div class="form-group">
			    <label class="control-label col-sm-5" for="cfmpwd"><span class="required">*</span> Confirm Password:</label>
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
			    <label class="control-label col-sm-5" for="fname"><span class="required">*</span> First Name:</label>
			    <div class="col-sm-3">
			      <input type="text" class="form-control" id="fname" name="fname" placeholder="Enter First Name">
			    </div>
			    <div class="col-sm-4" id="fnameerror">
			    </div>
			  </div>
			  <div class="form-group">
			    <label class="control-label col-sm-5" for="lname">Last Name:</label>
			    <div class="col-sm-7"> 
			      <input type="text" class="form-control" id="lname" name="lname" placeholder="Enter Last Name">
			    </div>
			  </div>
			  <div class="form-group">
			    <label class="control-label col-sm-5" for="email"><span class="required">*</span> Email:</label>
			    <div class="col-sm-3"> 
			      <input type="text" class="form-control" id="email" name="email" placeholder="Enter Email">
			    </div>
			    <div class="col-sm-4" id="emailerror">
			    </div>
			  </div>
			  <div class="form-group">
			    <label class="control-label col-sm-5" for="mobile"><span class="required">*</span> Mobile No:</label>
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
			      <button type="submit" id="register" class="btn btn-submit btn-md">Register</button>
			    </div>
			  </div>
			</form>
			<div class="row">
                    <div class="col-sm-12">
	                    <div class="registererror" id ="registererror">
							
						</div>
					</div>
				</div>
		</div>
	</div>
</div>
</body>
</html>