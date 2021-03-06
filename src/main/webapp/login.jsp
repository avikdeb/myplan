<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<sql:query var="rs" dataSource="jdbc/myplan">
select role from myplan.role
</sql:query>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/style.css">
<title>Login to MyPlan</title>
</head>
<body>

<form action="LoginServlet" method="post">
<table frame="box">
	<thead> <font color="green"><b>Login to MyPlan</b></font></thead>
	<tr>
		<td>
			<table border="0">
				<tr>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				<tr>
				<tr>
					<td>Username</td>
					<td><input type="text" name="username" value=""></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="password" value=""></td>
				</tr>
				<%
				if(null!=request.getAttribute("error_code") && request.getAttribute("error_code").toString().equalsIgnoreCase("100")) {
				%>
							
				<tr>
					<td>&nbsp;</td>
					<td><font color="red"><i>*Invalid login credentials</i></font></td>
				<tr>
				<%
				} else {
				%>
				<tr>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				<tr>
				<%
				}
				%>
				<tr>
					<td>Select Application Role</td>
					<td>
						<select name="role">
							<c:forEach var="row" items="${rs.rows}">
    							<option value="${row.role}">${row.role}</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<%
				if(null!=request.getAttribute("error_code") && request.getAttribute("error_code").toString().equalsIgnoreCase("200")) {
				%>
				<tr>
					<td>&nbsp;</td>
					<td><font color="red"><i>*Incorrect Project Role</i></font></td>
				<tr>
				<%
				} else {
				%>
				<tr>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<%
				}
				%>
				<tr>
					<td><input type="submit" name="login" value="Login"></td>
					<td><input type="submit" name="reset" value="Reset"></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				<tr>
					<td><font color="blue"> <b><a href="newuser.jsp">New User Registration</a></font> ||</b></td>
					<td><font color="red">Reset Password</font></td>
				</tr>
			</table>		
		</td>
	</tr>
</table>
</form>
</body>
</html>