<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.service_impl.UserServiceImpl"%>
<%@page import="com.pojo.UserDetails"%>
<%@page import="java.util.List"%>
<%@page import="com.pojo.User"%>
<%@page import="com.service.UserService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<table class="table table-bordered">
		<tr>
			<th>Full Name</th>
			<th>Last Name</th>
			<th>Email</th>
			<th>Mobile No.</th>
			<th colspan="3" >Actions</th>
		</tr>
	<%
		UserService service = new UserServiceImpl();
		int roleId = (Integer) session.getAttribute("user");
		if(roleId == 1){
	%>

			<%
				List<User> list = service.getUsers();
				for(User user:list)
				{
			%>
			<tr>
			    <td><%=user.getUserDetails().getFirstName()%></td>
			    <td><%=user.getUserDetails().getLastName()%></td>
			    <td><%=user.getUserDetails().getEmail()%></td>
			    <td><%=user.getUserDetails().getMobileNo()%></td>
			    <td><td colspan="3" ><a href="Edit?id=<%=user.getUserId()%>" class="btn btn-edit btn-sm" role="button">Address</a>
			    <a href="Edit?id=<%=user.getUserId()%>" class="btn btn-edit btn-sm" role="button">Edit</a>
			    <a href="DeleteServlet?id=<%=user.getUserId()%>" class="btn btn-delete btn-sm" role="button">Delete</a></td></td>
			</tr>
			<%
			    }
			}else{
				
			%>
			
			<%
			} 
			%>
	</table>	
</body>
</html>