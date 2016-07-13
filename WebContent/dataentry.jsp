<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Data Entry</title>

</script>

</head>
<body>

	<form onsubmit="return validateForm()" action="login.jsp" method="post">
		<p>Enter your first name</p>
		<input type="text" name="first" id="first" value=""></input>
		<p>Enter your last name</p>
		<input type="text" name="last" id="last" value=""></input>
		<p>Enter your phone number</p>
		<input type="text" name="phone" id="phone" value=""></input> <input
			type="submit" name="submit" id="submit" value="Submit"></input>
	</form>

	<script>
		// calling this function is not working
		function IsEmpty(objectfield, stringfield) {
			alert("value: " + objectvalue);
			objectvalue = objectfield.value.length;
			if (objectvalue == '') {
				alert("Oops.. Please fill out the value of " + stringfield);
				objectfield.style.background = 'Yellow';
				return false;
			} else {
				return true;
			}
		}
		
		// but this function does work!
		function validateForm() {

			var first = $('#first').val();
			var last = $('#last').val();
			var phone = $('#phone').val();
			firstgood = (first != '');
			lastgood = (last != '');
			phonegood = (phone != '');
			
			if (!firstgood) {
				alert("You forgot to enter your first name");				
			} 

			if (!lastgood) {
				alert("You forgot to enter your last name");				
			} 

			if (!phonegood) {
				alert("You forgot to enter your phone number");				
			} 
			
			return (firstgood && lastgood && phonegood);

		}
	</script>

</body>
</html>