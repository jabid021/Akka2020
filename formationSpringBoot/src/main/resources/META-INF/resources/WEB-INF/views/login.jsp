<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<c:set var="ctx" value="${pageContext.servletContext.contextPath }"></c:set>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<div align="center">
			<h1>identification</h1>
			<c:if test="${param.error != null }">
				<div class="alert alert-danger">erreur d'authentification</div>
			</c:if>
			<form action="login" method="post">
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}">
				<div class="form-group">
					<label for="username">login:</label> <input name="username"
						class="form-control" required="required">
				</div>
				<div>
					<label for="password">mot de passe:</label> <input type="password"
						name="password" class="form-control" required="required">
				</div>
				<div class="form-group">
					<button type="submit" class="btn btn-outline-primary">envoyer</button>
					<a href="${ctx}" class="btn btn-link">annuler</a>
				</div>
			</form>
		</div>
	</div>
</body>
</html>