<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.service_impl.UserServiceImpl"%>
<%@page import="com.pojo.UserDetails"%>
<%@page import="java.util.List"%>
<%@page import="com.pojo.User"%>
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
	  <%@include file="../js/myscript.js" %>
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
		<div class="container-fluid">
			<div class="header">
				<h2>Home</h2>
				<div class="menu">
					<a href="Display" class="btn btn-menu" role="button">Home</a>
				</div>
				<div class="menu-logout">
					<a href="LogoutServlet" id ="logout" class="btn btn-logout" role="button">Logout</a>
				</div>
			</div>
		</div>
		<table class="table table-bordered" id ="userTable">
			
			<script type="text/javascript">
			
			$(document).ready(function(){
					$.ajax({
						url: "ShowData",
						type: "GET",
						async: false,
						data: { 
							roleId :<%=(Integer) session.getAttribute("roleId")%>
						},
						success: function(result){
							$("#userTable").html(result);
						},
					});
				});
				
			</script>	
			<%
				int roleId=(Integer)session.getAttribute("roleId");
				session.setAttribute("roleId",roleId);
			%>
		</table>
	</center>
</body>
</html>