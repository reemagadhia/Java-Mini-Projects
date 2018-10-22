<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <style type="text/css">
    <%@include file="../../css/bootstrap.min.css" %>
    <%@include file="../../css/mystyle.css" %>
  </style>
  
  <script type="text/javascript">
  	  <%@include file="../../js/jquery.min.js" %>
	  <%@include file="../../js/bootstrap.min.js" %>
  </script>
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>
</head>
<body ng-app="myApp" ng-controller="loginController">

<div class="container-fluid">
	<div class="content">
		<div class="container">
			<center><h2>EShopper's Login</h2></center>
			<form class="form-horizontal" name="loginForm" id="loginForm">
				  <div class="form-group">
				    <label class="control-label col-sm-5" for="username"><span class="required">*</span> User-Name</label>
				    <div class="col-sm-4">
				      <input type="email" class="form-control" id="username" name="username" ng-model="user.username" placeholder="Enter Email Address">
				    </div>
				    <div class="col-sm-3">
				    </div>
				  </div>
				  <div class="form-group">
				    <label class="control-label col-sm-5" for="password"><span class="required">*</span> Password</label>
				    <div class="col-sm-4">
				      <input type="password" class="form-control" id="password" name="password" ng-model="user.password" placeholder="Enter Password">
				    </div>
				    <div class="col-sm-3">
				      <span class="error" ng-show="loginForm.password.$dirty && !loginForm.password.$valid"> Enter valid Password</span>
				    </div>
				  </div>
				   <div class="form-group"> 
				 	 <div class="col-sm-offset-5 col-sm-2">
				      <button type="button" id = "login" class="btn btn-login btn-lg" ng-click="loginUser(user);">Login</button>
				    </div>
				 	 <div class="col-sm-5">
				      <a  role="button" id = "add" class="btn btn-login btn-lg"  href="register">Register</a>
				    </div>
				  </div>
			</form>
		</div>
	</div>
</div>
<script type="text/javascript">
	<%@include file="../../js/app.js" %>
	<%@include file="../../js/loginService.js" %>
	<%@include file="../../js/loginController.js" %>
</script>
</body>
</html>