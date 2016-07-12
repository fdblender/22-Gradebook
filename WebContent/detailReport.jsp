<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="en_US" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Gradebook</title>
<jsp:include page="bootstrap.jsp"></jsp:include>
</head>
<body>
<h2>Gradebook Report</h2>
<table class="table table-bordered table-hover table-striped">
    <thead>
        <tr><th>StudentName</th><th>Assignment</th><th>Type</th><th>Date</th><th>Grade</th></tr>
    </thead>
    <tbody>
    <c:forEach var="assignment" items="${assignments}">
        <tr>
        <td><c:out value="${assignment.name}"/></td>
        <td><c:out value="${assignment.assignment}"/></td>
        <td><c:out value="${assignment.type}"/></td>
        <td><fmt:formatDate value="${assignment.dategraded}" pattern="yy-MMM-dd"/></td> 
        <td><c:out value="${assignment.grade}"/></td>        
        </tr>
    </c:forEach>
    </tbody>
</table>

<form action="getReportOptions.jsp" method="post">
	<input type="hidden" name="action" id="action" value="edit"></input>
	<input type="submit" name="submit" id="submit" value="Get more reports"></input>
</form>
	

</body>
</html>