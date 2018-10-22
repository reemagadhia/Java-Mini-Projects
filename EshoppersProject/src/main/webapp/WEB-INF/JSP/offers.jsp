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
<body ng-app="myApp" ng-controller="productController">
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
						      <li class="nav-item active">
						        <a class="nav-link" href="offers">Active Offers</a>
						      </li>
						      <li class="nav-item">
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
					<table class="table table-hover">
						<thead>
							<tr>
								<th>Product Name</th>
								<th>Product Code</th>
								<th>Offer Start Date</th>
								<th>Offer End Date</th>
							</tr>
						</thead>
						<tbody>
							<tr ng-repeat="p in offers">
								<td>{{p.Name}}</td>
								<td>{{p.Code}}</td>
								<td>{{p.OfferStartDate}}</td>
								<td>{{p.OfferEndDate}}</td>
							</tr>
						</tbody>
					</table>
			</div>
		</div>
	</div>
<script type="text/javascript">
	<%@include file="../../js/app.js" %>
	<%@include file="../../js/productService.js" %>
	<%@include file="../../js/productController.js" %>
</script>
</body>
</html>