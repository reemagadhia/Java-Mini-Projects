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
<%
try{
	String status = session.getAttribute("status").toString();

	if(status == null || status == "false"){
		response.sendRedirect("index.jsp");
	}
	else
	{
		session.setAttribute("status", "true");
	}
}
catch(Exception E){
	response.sendRedirect("index.jsp");	
}
%>
<div class="container-fluid">
	<div class="header">
		<h2>Add New Address</h2>
		<div class="menu">
			<a href="Display" class="btn btn-menu" role="button">Home</a>
		</div>
		<div class="menu-logout">
			<a href="LogoutServlet" class="btn btn-logout" role="button">Logout</a>
		</div>
	</div>
</div>
<%
	int userDetailsId = Integer.parseInt(request.getParameter("id"));
%>
<div class="container-fluid">
	<div class="content">
		<div class="container">
			<form class="form-horizontal" action="AddAddressServlet" method="post">
			  <div class="form-group">
			    <label class="control-label col-sm-5" for="city">Street Name:</label>
			    <div class="col-sm-7"> 
			      <input type="text" class="form-control" id="street" name="street" placeholder="Enter Street Name">
			    </div>
			  </div>
			  <input type="hidden" name="userDetailsId" value=<%=userDetailsId%>>
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
			  <div class="col-sm-offset-5 col-sm-7">
			    <div class="form-group"> 
			      <button type="submit" id="addaddress" class="btn btn-submit btn-md">Add</button>
			    </div>
			  </div>
			</form>
			<div class="col-sm-12">
			    <div class="addresserror" id="addresserror">
			    </div>
			</div>
		</div>
	</div>
</div>
</body>
</html>