<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<form onsubmit="return validateText()" action="" method="post">    
<p>Enter your first name</p>
<input type="text" name="first" id="first" value=""></input>
<p>Enter your last name</p>
<input type="text" name="last" id="last" value=""></input>
<p>Enter your phone number</p>
<input type="text" name="phone" id="phone" value=""></input>

<input type="submit" name="submit" id="submit" value="Login"></input>
</form>

<script>
function validateText(){
    return true;
}
</script>

</body>
</html>