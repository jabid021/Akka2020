<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<form action="home" method="post">

<input type="text" name="login">
<input type="password" name="password">
<input type="submit" value="Se connecter">
<div style="color:red" class="error">${error}</div>
</form>



</body>
</html>