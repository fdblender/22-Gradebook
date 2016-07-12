<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ValidateLogin</title>
</head>
<body>

<form onsubmit="return validateEmail()" action="dataentry.jsp" method="post">    
<p>Enter a valid email and password</p>
<input type="text" name="email" id="email" value="email"></input>
<input type="password" name="password" id="password" value="password"></input>
<input type="hidden" name="action" id="action" value="login"></input>
<input type="submit" name="submit" id="submit" value="Login"></input>
</form>

<script>
function validateEmail(email) { 
 // http://stackoverflow.com/a/46181/11236
 
 var re = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
 //return re.test(email);
 return true;
}
</script>
</body>
</html>