<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create</title>
</head>
<body>
	<h2>Create page here</h2>
	<form action="saveLead" method="post">
		<table>
			<tr>
				<td>First Name<input type="text" name="firstName"/></td>
			</tr>
			<tr>
				<td>Last Name<input type="text" name="lastName"/></td>
			</tr>
			<tr>
				<td>Email<input type="text" name="email"/></td>
			</tr>
			<tr>
				<td>Mobile<input type="text" name="mobile"/></td>
			</tr>
			<tr>
				<td><input type="submit" value="Save"/></td>
			</tr>
		</table>
	</form>
</body>
</html>