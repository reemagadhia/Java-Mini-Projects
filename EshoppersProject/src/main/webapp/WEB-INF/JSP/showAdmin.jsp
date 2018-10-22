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
<body ng-app="myApp" ng-controller="adminController">
<%
	/* String appliedFor = session.getAttribute("appliedFor").toString();
	session.setAttribute("appliedFor", appliedFor); */
%>
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
				         <div class="col-sm-2">
				    	</div>
				  </div>
				</nav>
		</div>
	</div>
<div class="container-fluid">
		<div class="content">
			<div class="container">
			<form class="form-horizontal" action="" name="adminForm" id="adminForm">
				   <div class="form-group"> 
				 	 <div class="col-sm-offset-10 col-sm-2">
				      <a role="button" id = "adminButton" class="btn btn-login btn-lg" data-toggle="modal" href="#" data-target=".admin-modal-md">+ Add Admin</a>
				    </div>
				  </div>
			</form>
			<table class="table table-hover">
				<thead>
					<tr>
						<th>User Name</th>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Email Id</th>
						<th>Contact No.</th>
						<th>Company</th>
						<th colspan="2">Actions</th>
					</tr>
				</thead>
				<tbody>
					<tr ng-repeat="u in userad">
						<td>{{u.USERNAME}}</td>
						<td>{{u.FIRSTNAME}}</td>
						<td>{{u.LASTNAME}}</td>
						<td>{{u.EMAIL}}</td>
						<td>{{u.CONTACT}}</td>
						<td>{{u.COMPANY}}</td>
						<td><a href="#"  data-toggle="modal" data-target=".admin-modal-md" ng-click="getUserById(u.UID);">Edit</a></td>
						<td><a href="" ng-click="deleteUser(u.UID);">Delete</a></td>
					</tr>
				</tbody>
			</table>
			</div>
		</div>
	</div>
	<div class="modal fade admin-modal-md" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel">

		<div class="container">
			<div class="modal-dialog modal-md" role="document">

				<div class="modal-content">

					<div class="row">
						<div class="col-xs-12">
							<div class="col-xs-10">
								<h4 class="modal-title">Add/Edit Product</h4>
							</div>
							<div class="col-xs-2">
								<button type="button" class="close" data-dismiss="modal">&times;</button>
							</div>
							<form class="form-horizontal" name="adminForm" id="adminForm">
								  <div class="form-group">
								    <label class="control-label col-sm-4" for="firstName"><span class="required">*</span> First-Name</label>
								    <div class="col-sm-8">
								      <input type="text" class="form-control" id="firstName" name="firstName" placeholder="Enter First-Name" ng-model="user.firstName" >
								    </div>
								  </div>
								  <div class="form-group">
								    <label class="control-label col-sm-4" for="lastName"><span class="required">*</span> Last-Name</label>
								    <div class="col-sm-8">
								      <input type="text" class="form-control" id="lastName" name="lastName" placeholder="Enter Last-Name" ng-model="user.lastName">
								    </div>
								  </div>
								  <div class="form-group">
								    <label class="control-label col-sm-4" for="company"><span class="required">*</span> Company-Name</label>
								    <div class="col-sm-8">
								      <input type="text" class="form-control" id="company" name="company" placeholder="Enter Company-Name" ng-model="user.company">
								    </div>
								  </div>
								  <div class="form-group">
								    <label class="control-label col-sm-4" for="contact"><span class="required">*</span> Contact-No</label>
								    <div class="col-sm-8">
								      <input type="text" class="form-control" id="contact" name="contact" placeholder="Enter Contact-No" ng-model="user.contact">
								    </div>
								  </div>
							  	  <div class="form-group">
								    <label class="control-label col-sm-4" for="userName"><span class="required">*</span> User-Name</label>
								    <div class="col-sm-8">
								      <input type="text" class="form-control" id="userName" name="userName" placeholder="Enter User-Name"ng-model="user.userName">
								    </div>
								  </div>
								  <div class="form-group">
								    <label class="control-label col-sm-4" for="userName"><span class="required">*</span>Confirm User-Name</label>
								    <div class="col-sm-8">
								      <input type="text" class="form-control" id="userName" name="userName" placeholder="Enter User-Name">
								    </div>
								  </div>
								  <div class="form-group">
								    <label class="control-label col-sm-4" for="password"><span class="required">*</span> Password</label>
								    <div class="col-sm-8">
								      <input type="password" class="form-control" id="password" name="password" placeholder="Enter Password" ng-model="user.password">
								    </div>
								  </div>
								  <div class="form-group">
								    <label class="control-label col-sm-4" for="password"><span class="required">*</span>Confirm Password</label>
								    <div class="col-sm-8">
								      <input type="password" class="form-control" id="password" name="password" placeholder="Enter Password">
								    </div>
								  </div>
								  <div class="form-group">
								    <div class="col-xs-12">
										<div class="checkbox">
											<label class="control-label col-sm-12"><input type="checkbox" id="tandc" onclick="terms_condition();">I
												agree with the Terms and Conditions as given in the <a href="#">Eshoppers Terms and Conditions</a></label>
										</div>
									</div>
								  </div>
								  <div class="form-group">
								 	 <div class="col-sm-offset-8 col-sm-4">
								      <a role="button" id = "addAdmin" class="btn btn-login btn-lg" href="showAdmin" ng-click ="saveAdmin(user)">Add</a>
								    </div>
								  </div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script>
		$('.admin-modal-md').on('hidden.bs.modal', function () {
		    $(this).find('form').trigger('reset');
		})
	</script>
<script type="text/javascript">
	<%@include file="../../js/app.js" %>
	<%@include file="../../js/adminService.js" %>
	<%@include file="../../js/adminController.js" %>
</script>
</body>
</html>