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
<body ng-app="myApp" ng-controller="registrationController">
<div class="container-fluid">
	<div class="content">
		<div class="container">
			<center><h2>EShopper's Registration</h2></center>
			<form class="form-horizontal" name="registrationForm" id="registrationForm">
				  <div class="form-group">
				    <label class="control-label col-sm-5" for="firstName"><span class="required">*</span> First-Name</label>
				    <div class="col-sm-4">
				      <input type="text" class="form-control" id="firstName" name="firstName" placeholder="Enter First-Name" ng-model="user.firstName" >
				    </div>
				    <div class="col-sm-3">
				    </div>
				  </div>
				  <div class="form-group">
				    <label class="control-label col-sm-5" for="lastName"><span class="required">*</span> Last-Name</label>
				    <div class="col-sm-4">
				      <input type="text" class="form-control" id="lastName" name="lastName" placeholder="Enter Last-Name" ng-model="user.lastName">
				    </div>
				    <div class="col-sm-3">
				    </div>
				  </div>
				  <div class="form-group">
				    <label class="control-label col-sm-5" for="appliedFor"><span class="required">*</span> Apply For</label>
				    <div class="col-sm-4">
				      <select class="selectpicker form-control" id="appliedFor" ng-model="user.appliedFor" name="appliedFor">
						 <option selected="selected" value="Supplier">Supplier</option>
						 <option>Buyer</option>
					  </select>
				    </div>
				    <div class="col-sm-3">
				    </div>
				  </div>
				  <div class="form-group">
				    <label class="control-label col-sm-5" for="company"><span class="required">*</span> Company-Name</label>
				    <div class="col-sm-4">
				      <input type="text" class="form-control" id="company" name="company" placeholder="Enter Company-Name" ng-model="user.company">
				    </div>
				    <div class="col-sm-3">
				    </div>
				  </div>
				  <div class="form-group">
				    <label class="control-label col-sm-5" for="contact"><span class="required">*</span> Contact-No</label>
				    <div class="col-sm-4">
				      <input type="text" class="form-control" id="contact" name="contact" placeholder="Enter Contact-No" ng-model="user.contact">
				    </div>
				    <div class="col-sm-3">
				    </div>
				  </div>
			  	  <div class="form-group">
				    <label class="control-label col-sm-5" for="userName"><span class="required">*</span> User-Name</label>
				    <div class="col-sm-4">
				      <input type="text" class="form-control" id="userName" name="userName" placeholder="Enter User-Name" ng-model="user.userName">
				    </div>
				    <div class="col-sm-3">
				    </div>
				  </div>
				  <div class="form-group">
				    <label class="control-label col-sm-5" for="userName"><span class="required">*</span>Confirm User-Name</label>
				    <div class="col-sm-4">
				      <input type="text" class="form-control" id="userName" name="userName" placeholder="Enter User-Name">
				    </div>
				    <div class="col-sm-3">
				    </div>
				  </div>
				  <div class="form-group">
				    <label class="control-label col-sm-5" for="password"><span class="required">*</span> Password</label>
				    <div class="col-sm-4">
				      <input type="password" class="form-control" id="password" name="password" placeholder="Enter Password" ng-model="user.password">
				    </div>
				    <div class="col-sm-3">
				    </div>
				  </div>
				  <div class="form-group">
				    <label class="control-label col-sm-5" for="password"><span class="required">*</span>Confirm Password</label>
				    <div class="col-sm-4">
				      <input type="password" class="form-control" id="password" name="password" placeholder="Enter Password">
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
				      <a role="button" id = "addAdmin" class="btn btn-login btn-lg" href="login" ng-click ="saveUser(user)">Add</a>
				    </div>
				  </div>
			</form>
		</div>
	</div>
</div>
<script type="text/javascript">
	<%@include file="../../js/app.js" %>
	<%@include file="../../js/registrationService.js" %>
	<%@include file="../../js/registrationController.js" %>
</script>
</body>
</html>