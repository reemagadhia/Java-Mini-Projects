function password_validation(){
	var pwd = document.getElementById("pwd").value;
	var pass_regex=/(?=.*[A-Z].*[A-Z])(?=.+\d)(?=.+[$@$!%*?&])[A-Za-z\d$@$!%*?&].{8,}/;
	if(!(pass_regex.test(pwd))){
	document.getElementById("pwderror").style.display="block";
	document.getElementById("pwderror").innerHTML="Incorrect Password";
	}else{
		document.getElementById("pwderror").style.display="none";
	}
}
function check_password(){
	var pwd = document.getElementById("pwd").value;
	var cfmpwd = document.getElementById("cfmpwd").value;
	if(!(pwd==cfmpwd)){
		document.getElementById("cfmpwderror").style.display="block";
		document.getElementById("cfmpwderror").innerHTML="Password and Confirm Password must be same";
	}else{
		document.getElementById("cfmpwderror").style.display="none";
	}
}
function mobile_validation(){
	var mobile = document.getElementById("mobile").value;
	var mo_regex=/^\+?([0-9]{1})[ ]\(?([0-9]{3})?[-]([0-9]{3})?[-]([0-9]{4})$/;
	document.getElementById("moerror").style.display="none";
	if(!(mo_regex.test(mobile))){
	document.getElementById("moerror").style.display="block";
	document.getElementById("moerror").innerHTML="Mobile No should be entered in U.S. format only";
	
	}else{
		document.getElementById("moerror").style.display="none";
	}
}
$(document).ready(function(){
$("#login").click(function(event) {
	if($("#luname").val()=="" || $("#lpwd").val()==""){
		event.preventDefault();
		$("#loginerror").html("Please Enter Username and Password");
	}
	else {
		$("#loginerror").css("display" ,"none");
	}
});
$("#register").click(function(event) {
	if($("#uname").val()==""){
		event.preventDefault();
		$("#unameerror").css("display","initial");
		$("#unameerror").html("Please Enter Username");
	}
	else {
		$("#unameerror").css("display","none");
	}
	
	if($("#pwd").val()==""){
		event.preventDefault();
		$("#pwderror").css("display","block");
		$("#pwderror").html("Please Enter Password");
	}
	else {
		$("#pwderror").css("display","none");
	}
	
	if($("#cfmpwd").val()==""){
		event.preventDefault();
		$("#cfmpwderror").css("display","block");
		$("#cfmpwderror").html("Please Enter Confirm Password");
	}
	else {
		$("#cfmpwderror").css("display","none");
	}
	
	if($("#fname").val()==""){
		event.preventDefault();
		$("#fnameerror").css("display","block");
		$("#fnameerror").html("Please Enter Firstname");
	}
	else {
		$("#fnameerror").css("display","none");
	}
	
	if($("#email").val()==""){
		event.preventDefault();
		$("#emailerror").css("display","block");
		$("#emailerror").html("Please Enter Email");
	}
	else {
		$("#emailerror").css("display","none");
	}
	
	if($("#mobile").val()==""){
		event.preventDefault();
		$("#moerror").css("display","block");
		$("#moerror").html("Please Mobile No");
	}
	else {
		$("#moerror").css("display","none");
	}
});
$("#logout").click(function(event) {
	if(confirm("Are you sure you want to Logout?")){
		$("#logout").attr("href", "LogoutServlet");
	}
	else{
		return false;
	}
});

});
