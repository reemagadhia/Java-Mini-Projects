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
		<div class="header">
			   <nav class="navbar navbar-expand-lg navbar-light bg-light">
				  <a class="navbar-brand" href="#">EShoppers</a>
				  <div class="collapse navbar-collapse" id="navbarNav"> 
				  	<div class="row">
						<div class="col-sm-10">
						    <ul class="navbar-nav" type="none">
						      <li class="nav-item active">
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
				<div class="row">
								<div class="col-xs-12">
									<div class="tab1">
										<ul class="nav nav-tabs" role="tablist">
											<li role="presentation" class="active">
											<a href="#Pending" aria-controls="Pending" role="tab"data-toggle="tab">Pending Registrations</a>
											</li>
											<li role="presentation">
											<a href="#Approved" aria-controls="Approved" role="tab" data-toggle="tab">Approved Registrations</a>
											</li>
											<li role="presentation">
											<a href="#Cancelled"aria-controls="Cancelled" role="tab" data-toggle="tab">Cancelled Registrations</a>
											</li>
										</ul>
										<div class="tab-content">
											<div role="tabpanel" class="tab-pane active" id="Pending">
												<table class="table table-hover">
								                      <thead>
								                          <tr>
								                          	  <th>First Name</th>
								                              <th>Last Name</th>
								                              <th>Email Id</th>
								                              <th>Contact No.</th>
								                              <th>Company</th>
								                              <th>Applied For</th>
								                              <th>Registration Date</th>
								                              <th>Status</th>
								                          </tr>
								                      </thead>
								                      <tbody>
								                          <tr ng-repeat="u in userp">
								                          	  <td>{{u.FIRSTNAME}}</td>
								                              <td>{{u.LASTNAME}}</td>
								                              <td>{{u.USERNAME}}</td>
								                              <td>{{u.COMPANY}}</td>
								                              <td>{{u.CONTACT}}</td>
								                              <td>{{u.APPLIEDFOR}}</td>
								                              <td>{{u.REGDATE}}</td>
								                              <td>{{u.STATUS}}</td>
								                          </tr>
								                      </tbody>
								                  </table>
											</div>
											<div role="tabpanel" class="tab-pane" id="Approved">
												<table class="table table-hover">
								                      <thead>
								                          <tr>
								                          	  <th>First Name</th>
								                              <th>Last Name</th>
								                              <th>Email Id</th>
								                              <th>Contact No.</th>
								                              <th>Company</th>
								                              <th>Applied For</th>
								                              <th>Registration Date</th>
								                              <th>Status</th>
								                          </tr>
								                      </thead>
								                      <tbody>
								                          <tr ng-repeat="u in usera">
								                          	 <td>{{u.FIRSTNAME}}</td>
								                              <td>{{u.LASTNAME}}</td>
								                              <td>{{u.USERNAME}}</td>
								                              <td>{{u.COMPANY}}</td>
								                              <td>{{u.CONTACT}}</td>
								                              <td>{{u.APPLIEDFOR}}</td>
								                              <td>{{u.REGDATE}}</td>
								                              <td>{{u.STATUS}}</td>
								                          </tr>
								                      </tbody>
								                  </table>
											</div>
											<div role="tabpanel" class="tab-pane" id="Cancelled">
												<table class="table table-hover">
								                      <thead>
								                          <tr>
								                          	  <th>First Name</th>
								                              <th>Last Name</th>
								                              <th>Email Id</th>
								                              <th>Contact No.</th>
								                              <th>Company</th>
								                              <th>Applied For</th>
								                              <th>Registration Date</th>
								                              <th>Status</th>
								                          </tr>
								                      </thead>
								                      <tbody>
								                          <tr ng-repeat="u in userc">
								                          	  <td>{{u.FIRSTNAME}}</td>
								                              <td>{{u.LASTNAME}}</td>
								                              <td>{{u.USERNAME}}</td>
								                              <td>{{u.COMPANY}}</td>
								                              <td>{{u.CONTACT}}</td>
								                              <td>{{u.APPLIEDFOR}}</td>
								                              <td>{{u.REGDATE}}</td>
								                              <td>{{u.STATUS}}</td>
								                          </tr>
								                      </tbody>
								                  </table>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
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