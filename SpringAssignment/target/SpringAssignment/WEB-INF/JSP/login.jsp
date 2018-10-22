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

<div class="container-fluid">
	<div class="header">
		<h2>Login</h2>
	</div>
</div>
<% session.setAttribute("status", "true"); %>
<div class="container-fluid">
	<div class="content">
		<div class="container">
			<form class="form-horizontal" action="LoginServlet" method="post">
			  <div class="form-group">
			    <label class="control-label col-sm-5" for="luname"><span class="required">*</span> Username:</label>
			    <div class="col-sm-7">
			      <input type="text" class="form-control" id="luname" name="luname" placeholder="Enter Username">
			    </div>
			  </div>
			  <div class="form-group">
			    <label class="control-label col-sm-5" for="lpwd"><span class="required">*</span> Password:</label>
			    <div class="col-sm-7"> 
			      <input type="password" class="form-control" id="lpwd" name="lpwd" placeholder="Enter Password">
			    </div>
			  </div>
			  
			  <div class="col-sm-offset-5 col-sm-1">
			    <div class="form-group"> 
			      <button type="submit" id = "add" class="btn btn-login btn-md">Add</button>
			    </div>
			  </div>
			  
			  <div class="col-sm-6">
			    <div class="form-group"> 
			      <a href="Register" id ="clear" class="btn btn-register btn-md" role="button">Clear</a>
			    </div>
			  </div>
			</form>
				<div class="row">
                    <div class="col-sm-12">
	                    <div class="loginMessage">
							<%
								String loginMessage="";
								if(session.getAttribute("loginMessage")!=null){
									loginMessage = session.getAttribute("loginMessage").toString();
									out.println(loginMessage);
									session.setAttribute("loginMessage","");
									session.setAttribute("status", "true");
								}
								else{
									loginMessage ="";
								}
								
								String registerMessage="";
								if(session.getAttribute("registerMessage")!=null){
									registerMessage = session.getAttribute("registerMessage").toString();
									out.println(registerMessage);
									session.setAttribute("registerMessage","");
								}
								else{
									registerMessage ="";
								}
							%>
						</div>
					</div>
				</div>
				<div class="row">
                    <div class="col-sm-12">
	                    <div class="logoutMessage" id ="logoutMessage">
		                    <%
								String logoutMessage="";
									if(session.getAttribute("logoutMessage")!=null){
										logoutMessage = session.getAttribute("logoutMessage").toString();
										out.println(logoutMessage);
										session.setAttribute("logoutMessage","");
									}
									else{
										logoutMessage ="";
									}
							%>
						</div>
					</div>
				</div>
				<div class="row">
                    <div class="col-sm-12">
	                    <div class="loginerror" id ="loginerror">
							
						</div>
					</div>
				</div>
		</div>
	</div>
</div>
</body>
</html>