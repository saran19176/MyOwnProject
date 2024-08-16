<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Guess Game</title>
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
		<h1 style="color: blue;">Guess the Number....</h1>
		<form action="GuessNumberServlet" method="Post">
			Enter the Guess : <input type="text" name="guess"><br>
			<br><input type="submit" value="GUESS"><br>
			
		</form>
	</div><br>

	<div align="center">
		<form action="login.jsp">
			<br>
			<input style="color: red;" type="submit" value="Play Again">
		</form>
	</div>

	<%
	  String message = (String)request.getAttribute("message");
	  if(message != null){
		  out.println("<div style = 'text-align : center; color : green;'><p>" + message + "</div></p>");
	  }
	%>
</body>
</html>