<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align = center>
<h2>User Login</h2>
</div>
<form action="LoginServlet" method="Post">
<div align="center">
<table>
 <tr><td>Enter the UserName :</td><td><input type="text" name="usname"></td></tr>
 <tr><td>Enter the Password :</td><td><input type="password" name="password"></td></tr>
 <tr><td><input type="submit" value="login"> </td> </tr>
 </table>
</div>

</form>
<div align="center">
  <form action="signup.jsp">
 <input type="submit" value="signup">
</form>
</div>
</body>
</html>