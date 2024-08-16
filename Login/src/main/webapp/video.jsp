<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Video</title>
</head>
<body>
	<%
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	/* response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
	response.setDateHeader("Expires", 1); // Proxies. */

	if (session.getAttribute("uname") == null) {
		response.sendRedirect("login.jsp");
	}
	%>
	
	
	<div style="display: flex; justify-content: center;">
		<iframe width="560" height="315"
			src="https://www.youtube.com/embed/YywLS8XdxLQ?si=Km9Drn3k3UstC1D9"
			title="YouTube video player" frameborder="0"
			allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
			referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe>

	</div>


	<div align="center">
		<form style="align-items: center;" action="logout.jsp">
			<br>
			<input type="submit" value="Logout">
		</form>
	</div>

</body>
</html>
