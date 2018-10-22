<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="http://localhost:8080/HibernateProject/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="http://localhost:8080/HibernateProject/css/mystyle.css" />
<script src="http://localhost:8080/HibernateProject/js/jquery.min.js"></script>
<script src="http://localhost:8080/HibernateProject/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container-fluid">
	<div class="header">
		<h2>Login</h2>
	</div>
</div>
<div class="container-fluid">
	<div class="content">
		<div class="container">
			<form class="form-horizontal" action="LoginServlet" method="post">
			  <div class="form-group">
			    <label class="control-label col-sm-5" for="luname">Username:</label>
			    <div class="col-sm-7">
			      <input type="text" class="form-control" id="luname" name="luname" placeholder="Enter Username">
			    </div>
			  </div>
			  <div class="form-group">
			    <label class="control-label col-sm-5" for="lpwd">Password:</label>
			    <div class="col-sm-7"> 
			      <input type="password" class="form-control" id="lpwd" name="lpwd" placeholder="Enter Password">
			    </div>
			  </div>
			  
			  <div class="col-sm-offset-5 col-sm-1">
			    <div class="form-group"> 
			      <button type="submit" class="btn btn-login btn-lg">Login</button>
			    </div>
			  </div>
			  
			  <div class="col-sm-6">
			    <div class="form-group"> 
			      <a href="Register" class="btn btn-register btn-lg" role="button">Register</a>
			    </div>
			  </div>
			</form>
		</div>
	</div>
</div>
</body>
</html>