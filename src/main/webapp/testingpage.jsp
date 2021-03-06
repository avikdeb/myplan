<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<sql:query var="rs" dataSource="jdbc/enrolmentapp">
	select * from enrolmentapp.user
</sql:query>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Testing - User List</title>
</head>
<body>
<font color="green"><b>List of Registered Users</b></font>
<table frame="box" border="1">
	<tr>
		<th>Username</th>
		<th>Firstname</th>
		<th>Lastname</th>
		<th>E-mail</th>
		<th>Mobile</th>
		<th>Department</th>
	</tr>
	<c:forEach var="row" items="${rs.rows}">
	<tr>
		<td>${row.username}</td>
		<td>${row.firstname}</td>
		<td>${row.lastname}</td>
		<td>${row.email}</td>
		<td>${row.mobile}</td>
		<td>${row.department}</td>
	</tr>
	</c:forEach>
</table>
</body>
</html>