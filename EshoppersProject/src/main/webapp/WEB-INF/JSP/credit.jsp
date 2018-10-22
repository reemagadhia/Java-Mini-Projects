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
<body ng-app="myApp" ng-controller="creditController">
	<div class="container-fluid">
		<div class="header">
			   <nav class="navbar navbar-expand-lg navbar-light bg-light">
				  <a class="navbar-brand" href="#">EShoppers</a>
				  <div class="collapse navbar-collapse" id="navbarNav"> 
				  	<div class="row">
						<div class="col-sm-10">
						    <ul class="navbar-nav" type="none">
						      <li class="nav-item">
						        <a class="nav-link" href="display">Registrations</a>
						      </li>
						      <li class="nav-item">
						        <a class="nav-link" href="orders">Orders</a>
						      </li>
						      <li class="nav-item">
						        <a class="nav-link" href="buyers">Buyers List</a>
						      </li>
						      <li class="nav-item">
						        <a class="nav-link" href="suppliers">Suppliers List</a>
						      </li>
						      <li class="nav-item">
						        <a class="nav-link" href="products">Manage Products</a>
						      </li>
						      <li class="nav-item">
						        <a class="nav-link" href="offers">Active Offers</a>
						      </li>
						      <li class="nav-item active">
						        <a class="nav-link" href="credit">Supplier Credit Integration</a>
						      </li>
						      <li class="nav-item">
						        <a class="nav-link-logout" href="LogoutController">Logout</a>
						      </li>
						    </ul>
				         </div>
				         <div class="col-sm-2">
				         </div>
				    </div>
				  </div>
				</nav>
		</div>
	</div>

	<div class="container-fluid">
		<div class="content">
			<div class="container">
					<form class="form-horizontal" name="loginForm" id="loginForm">
				  <div class="form-group">
					  <label class="control-label col-sm-5" for="supplier">Supplier Name</label>
					  <div class="col-sm-4" ng-controller="supplierController">
							<select class="selectpicker credit-form-control" id="supplier" ng-model="credit.supplier" name="supplier">
								<option ng-repeat="s in usersu">{{s.FIRSTNAME}}</option>
							 </select>
					   </div>
					   <div class="col-sm-3">
					   </div>
				  </div>
				  <div class="form-group">
					    <label class="control-label col-sm-5" for="tandc">Terms and Conditions</label>
					    <div class="col-sm-4">
					      <textarea class="credit-form-control" ng-model="credit.tandc" name="tandc" rows="5" id="tandc" placeholder="Enter Terms and Conditions"></textarea>
					    </div>
					    <div class="col-sm-3">
					    </div>
				   </div>
				   <div class="form-group"> 
				 	 <div class="col-sm-offset-7 col-sm-5">
				      <a  role="button" id = "credit" class="btn btn-tc btn-lg" ng-click="saveCredit(credit)">Save Terms and Conditions</a>
				    </div>
				  </div>
			</form>
			</div>
		</div>
	</div>
	<!-- <script type="text/javascript">
			
			$("select").change(function(){
					$.ajax({
						url: "GetCreditById",
						type: "GET",
						data: { 
							id : $("select").val()
						},
						success: function(result){
							    var val = result;
						        $("#tandc").html(val);
						},
					});
				});
				
</script> -->
<script type="text/javascript">
	<%@include file="../../js/app.js" %>
	<%@include file="../../js/creditService.js" %>
	<%@include file="../../js/creditController.js" %>
	<%@include file="../../js/supplierService.js" %>
	<%@include file="../../js/supplierController.js" %>
</script>
</body>
</html>