<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<table class="table">
			<tr>
				<th>id</th>
				<th>prenom</th>
				<th>nom</th>
				<th></th>
				<th></th>
			</tr>
			<c:forEach items="${personnes}" var="p">
				<tr>
					<td>${p.id}</td>
					<td>${p.prenom}</td>
					<td>${p.nom}</td>
					<td><a href="./personne/edit?id=${p.id}"
						class="btn btn-outline-primary">editer</a></td>
					<td><a href="./personne/delete?id=${p.id}"
						class="btn btn-outline-danger">supprimer</a></td>
				</tr>
			</c:forEach>
		</table>
		<a href="./personne/add" class="btn btn-link">nouvelle personne</a>
	</div>
</body>
</html>