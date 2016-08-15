<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration</title>
</head>
<body>
<h1 align="center">REGISTER</h1>

<script>
function equalPassword(){		
	var p1 = document.forms["myForm"]["pwd"].value;
	var p2 = document.forms["myForm"]["cpwd"].value;
	if (p1!=p2) { 
		alert("Password Not Equal")
		return false;		
	}	
}
</script>

<form name="myForm" action="register" method="post" onsubmit="return equalPassword()">
<table style="width:50%">
<tr><td>First Name</td><td><input type="text" name="fname" required></td></tr> 
<tr><td>Last Name</td><td><input type="text" name="lname" required/></td></tr>
<tr><td>Email</td><td><input type="email" name="email" required/></td></tr>
<tr><td>User Name</td><td><input type="text" name="uname" required/></td></tr>
<tr><td>Password</td><td><input type="password" name="pwd" required/></td></tr>
<tr><td>Confirm Password</td><td><input type="password" name="cpwd" required/></td></tr>

</table>
<center><input type="submit"/></center>
</form>

</body>
</html>