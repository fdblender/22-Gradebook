<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


<form onsubmit="return checkRegistration()" method="get" action="http://google.com">
    Write google to go to google..<br/>
    <input type="text" id="some_input" value=""/>
    <input type="submit" value="google it"/>
</form>

<script>
function checkRegistration(){
    var form_valid = (document.getElementById('some_input').value == 'google');
    if(!form_valid){
        alert('Given data is incorrect');
        return false;
    }
    return true;
}
</script>
</body>
</html>