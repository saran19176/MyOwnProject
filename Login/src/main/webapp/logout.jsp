<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1 style="text-align: center; color: green;">Logout
		Successful............</h1>

	<%
    session.removeAttribute("uname");
    %>
    
    
	<div align="center">
		<form action="login.jsp">
			<input type="submit" value="Login again">
		</form>
	</div>
</body>
</html>