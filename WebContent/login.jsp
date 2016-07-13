<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ValidateLogin</title>

<script>
	function validateEmail() {
		var email = $('#email').val();
		// http://stackoverflow.com/a/46181/11236

		// check the email
		var re = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
		var goodemail = re.test(email);
		if (goodemail == false)
			alert("Invalid Email!");

		// check the password
		var password = $('#password').val();
		var pword = new RegExp(/^[a-zA-Z0-9]{4,100}$/)
		goodpassword = pword.test(password)
		if (!goodpassword) {
			alert("Invalid Password!"+password);
		}

		return (goodpassword && goodemail);
	}
</script>

<script>
	function checkPass() {
		var form_valid = (document.getElementById('password').value == 'password');
		if (!form_valid) {
			alert('Given data is incorrect');
			return false;
		}
		return true;
	}
</script>

</head>
<body>

	<form onsubmit="return validateEmail()" action="dataentry.jsp"
		method="get">
		<p>Enter a valid email and password</p>
		<input type="text" name="email" id="email" value=""></input> <input
			type="password" name="password" id="password" value=""></input> <input
			type="hidden" name="action" id="action" value="login"></input> <input
			type="submit" name="submit" id="submit" value="Login"></input>
	</form>

	<script>
		function verifyPassword() {
			var password = $('#password').val();

			if (password.length < 1) {
				alert('That password is too short.' + password);
			}
		}
	</script>

</body>
</html>