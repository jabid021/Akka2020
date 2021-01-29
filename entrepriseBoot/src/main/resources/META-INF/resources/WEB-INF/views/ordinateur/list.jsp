<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<h1>liste ordinateur</h1>
		<table class="table">
			<tr>
				<th>id</th>
				<th>marque</th>
				<th>RAM</th>
				<th></th>
				<th></th>
			</tr>
			<c:forEach var="o" items="${ordinateurs}">
				<tr>
					<td>${o.id}</td>
					<td>${o.marque}</td>
					<td>${o.RAM}</td>
					<td><a href="./ordinateur/edit?id=${o.id}"
						class="btn btn-outline-primary">editer</a></td>
					<td><a href="./ordinateur/delete?id=${o.id}"
						class="btn btn-outline-primary">supprimer</a></td>
				</tr>
			</c:forEach>
		</table>
		<a href="./ordinateur/add" class="btn btn-outline-link">ajouter un
			ordianteur</a>
	</div>
</body>
</html>