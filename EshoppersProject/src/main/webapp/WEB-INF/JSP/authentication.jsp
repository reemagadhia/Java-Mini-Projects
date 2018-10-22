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
  <%@include file="../../../js/jquery.min.js" %>
  <%@include file="../../js/bootstrap.min.js" %>
  </script>
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>
</head>
<body>
<body ng-app="myApp" ng-controller="verifyController">
<div class="container-fluid">
	<div class="content">
		<div class="container">
			<h2>Two Factor Authentication</h2>
			<p>We have sent a text message containing a verification code to
					the mobile phone number registered on your account. Enter the
					verification code below along with your new password.</p>
			<form class="form-horizontal" action="" id="verificationForm" name="verificationForm">
				  <div class="form-group">
				    <label class="control-label col-sm-3" for="code"><span class="required">*</span> Verification Code:</label>
				    <div class="col-sm-4">
				      <input type="number" class="form-control" id="code" ng-model="code.code" name="code" placeholder="Enter Verification Code">
				    </div>
				  </div>
				  <div class="form-group"> 
				 	 <div class="col-sm-offset-5 col-sm-7">
				      <button type="submit" id = "Submit" class="btn btn-login btn-lg" ng-click="verifyUser(code);">Submit</button>
				    </div>
				  </div>
			</form>
		</div>
	</div>
</div>

<script type="text/javascript">
	<%@include file="../../js/app.js" %>
	<%@include file="../../js/verifyService.js" %>
	<%@include file="../../js/verifyController.js" %>
</script>
</body>
</html>