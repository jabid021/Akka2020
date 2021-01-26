<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
		<h1>liste des departements</h1>
		<table class="table">
			<tr>
				<th>numero</th>
				<th>nom</th>
				<th>lieu</th>

				<th></th>
				<th></th>
			</tr>
			<c:forEach var="d" items="${departements}">
				<tr>
					<td>${d.numero}</td>
					<td>${d.nom}</td>
					<td>${d.lieu}</td>
					<td><a href="./departement/edit?id=${d.numero}"
						class="btn btn-outline-primary">editer</a></td>
					<td><a href="./departement/delete?id=${d.numero}"
						class="btn btn-outline-danger">supprimer</a></td>
				</tr>
			</c:forEach>
		</table>
		<a href="./departement/add" class="btn btn-outline-link">ajouter
			un departement</a>
	</div>
</body>
</html>