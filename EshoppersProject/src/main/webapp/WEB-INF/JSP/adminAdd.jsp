<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<body ng-app="myApp" ng-controller="adminController">
<div class="container-fluid">
		<div class="header">
			   <nav class="navbar navbar-expand-lg navbar-light bg-light">
				  <a class="navbar-brand" href="#">EShoppers</a>
				  <div class="collapse navbar-collapse" id="navbarNav"> 
				  	<div class="row">
						<div class="col-sm-10">
						    <ul class="navbar-nav" type="none">
						      <li class="nav-item active">
						        <a class="nav-link" href="showAdmin">Admin</a>
						      </li>
						      <li class="nav-item active">
						        <a class="nav-link" href="adminAuth">Registrations</a>
						      </li>
						      <li class="nav-item">
						        <a class="nav-link" href="authentication">As A Supplier</a>
						      </li>
						      <li class="nav-item">
						        <a class="nav-link-logout" href="LogoutController">Logout</a>
						      </li>
						    </ul>
				         </div>
				    </div>
				    <div class="col-sm-2">
				    </div>
				  </div>
				</nav>
		</div>
	</div>
<div class="container-fluid">
	<div class="content">
		<div class="container">
			<center><h2>Add Admin</h2></center>
			<form class="form-horizontal" name="adminForm" id="adminForm">
				  <div class="form-group">
				    <label class="control-label col-sm-5" for="firstName"><span class="required">*</span> First-Name</label>
				    <div class="col-sm-4">
				      <input type="text" class="form-control" id="firstName" name="firstName" placeholder="Enter First-Name" value="${user.firstName}" ng-model="user.firstName" >
				    </div>
				    <div class="col-sm-3">
				    </div>
				  </div>
				  <div class="form-group">
				    <label class="control-label col-sm-5" for="lastName"><span class="required">*</span> Last-Name</label>
				    <div class="col-sm-4">
				      <input type="text" class="form-control" id="lastName" name="lastName" placeholder="Enter Last-Name" value="${user.lastName}" ng-model="user.lastName">
				    </div>
				    <div class="col-sm-3">
				    </div>
				  </div>
				  <div class="form-group">
				    <label class="control-label col-sm-5" for="company"><span class="required">*</span> Company-Name</label>
				    <div class="col-sm-4">
				      <input type="text" class="form-control" id="company" name="company" placeholder="Enter Company-Name" value="${user.company}" ng-model="user.company">
				    </div>
				    <div class="col-sm-3">
				    </div>
				  </div>
				  <div class="form-group">
				    <label class="control-label col-sm-5" for="contact"><span class="required">*</span> Contact-No</label>
				    <div class="col-sm-4">
				      <input type="text" class="form-control" id="contact" name="contact" placeholder="Enter Contact-No" value="${user.contact}" ng-model="user.contact">
				    </div>
				    <div class="col-sm-3">
				    </div>
				  </div>
			  	  <div class="form-group">
				    <label class="control-label col-sm-5" for="userName"><span class="required">*</span> User-Name</label>
				    <div class="col-sm-4">
				      <input type="text" class="form-control" id="userName" name="userName" placeholder="Enter User-Name" value="${user.userName}" ng-model="user.userName">
				    </div>
				    <div class="col-sm-3">
				    </div>
				  </div>
				  <div class="form-group">
				    <label class="control-label col-sm-5" for="userName"><span class="required">*</span>Confirm User-Name</label>
				    <div class="col-sm-4">
				      <input type="text" class="form-control" id="userName" name="userName" value="${user.userName}" placeholder="Enter User-Name">
				    </div>
				    <div class="col-sm-3">
				    </div>
				  </div>
				  <div class="form-group">
				    <label class="control-label col-sm-5" for="password"><span class="required">*</span> Password</label>
				    <div class="col-sm-4">
				      <input type="password" class="form-control" id="password" name="password" placeholder="Enter Password" value="${user.password}" ng-model="user.password">
				    </div>
				    <div class="col-sm-3">
				    </div>
				  </div>
				  <div class="form-group">
				    <label class="control-label col-sm-5" for="password"><span class="required">*</span>Confirm Password</label>
				    <div class="col-sm-4">
				      <input type="password" class="form-control" id="password" name="password" value="${user.password}" placeholder="Enter Password">
				    </div>
				    <div class="col-sm-3">
				    </div>
				  </div>
				  <div class="form-group">
				    <div class="col-xs-12">
						<div class="checkbox">
							<label class="control-label col-sm-12"><input type="checkbox" id="tandc" onclick="terms_condition();">I
								agree with the Terms and Conditions as given in the <a href="#">Eshoppers Terms and Conditions</a>.</label>
						</div>
					</div>
				  </div>
				  <div class="form-group">
				 	 <div class="col-sm-offset-7 col-sm-5">
				      <a role="button" id = "addAdmin" class="btn btn-login btn-lg" href="showAdmin" ng-click ="saveAdmin(user)">Add</a>
				    </div>
				  </div>
			</form>
		</div>
	</div>
</div>
<script type="text/javascript">
	<%@include file="../../js/app.js" %>
	<%@include file="../../js/adminService.js" %>
	<%@include file="../../js/adminController.js" %>
</script>
</body>
</html>