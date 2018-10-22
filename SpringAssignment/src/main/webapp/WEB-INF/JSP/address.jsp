<%@page import="java.util.ArrayList"%>
<%@page import="com.pojo.Address"%>
<%@page import="com.service_impl.UserServiceImpl"%>
<%@page import="com.service.UserService"%>
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
  </script>
</head>
<body>
<%
	String status = (String)session.getAttribute("status");
	if(status == null || status == "false"){
		session.setAttribute("status", "false");
		response.sendRedirect("index.jsp");
	}
	else
	{
		session.setAttribute("status", "true");
	}
%>
<center>
	<%
	int userDetailsId=0;
	try{
		userDetailsId = Integer.parseInt(request.getParameter("id"));
	}
	catch(Exception e){
		
	}
	if(userDetailsId!=0){
		session.setAttribute("userDetailsId", userDetailsId);
	}
	%>
		<div class="container-fluid">
			<div class="header">
				<h2>Home</h2>
				<div class="menu">
					<a href="Display" class="btn btn-menu" role="button">Home</a>
				</div>
				<div class="menu-logout">
					<a href="LogoutServlet" class="btn btn-logout" role="button">Logout</a>
				</div>
			</div>
		</div>
		<table class="table table-bordered" id="addressTable">
			<script type="text/javascript">
			
			$(document).ready(function(){
					$.ajax({
						url: "AddressDetails",
						type: "GET",
						async: false,
						data: { 
							userDetailsId :<%=(Integer) session.getAttribute("userDetailsId")%>
						},
						success: function(result){
							$("#addressTable").html(result);
						},
					});
				});
				
			</script>
			
		</table>
</center>
</body>
</html>