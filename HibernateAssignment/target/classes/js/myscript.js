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