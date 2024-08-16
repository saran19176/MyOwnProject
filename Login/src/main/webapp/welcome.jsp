<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
</head>
<body>

	<%
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
	/* response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
	response.setDateHeader("Expires", 1); // Proxies. */

	if (session.getAttribute("uname") == null) {
		response.sendRedirect("login.jsp");
	}
	%>

	<div align="center">
		Welcome ${uname}

		<h1>Login Successful........</h1>

		<form action="guess.jsp">
		  <input style="color: blue;" type="submit" value="Play Game">
		</form>
		
		<form action="LeaderBoardServlet">
		  <br><br><input style="color: green;" type="submit" value="Check LeaderBoard">
		</form>
		
	</div>


</body>
</html>