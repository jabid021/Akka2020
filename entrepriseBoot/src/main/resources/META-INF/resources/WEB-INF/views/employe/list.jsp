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
		<jsp:include page="../logout.jsp"></jsp:include>
		<h1>liste des employes</h1>
		<table class="table">
			<tr>
				<th>numero</th>
				<th>nom</th>
				<th>poste</th>
				<th>date d'embauche</th>
				<th>salaire</th>
				<th>adresse</th>
				<th></th>
				<th></th>
			</tr>
			<c:forEach var="e" items="${employes}">
				<tr>
					<td>${e.numero}</td>
					<td>${e.nom}</td>
					<td>${e.poste}</td>
					<td><fmt:parseDate value="${e.embauche}" pattern="yyyy-MM-dd"
							var="embaucheEnDate" type="date"></fmt:parseDate> <fmt:formatDate
							pattern="dd/MM/yyyy" value="${embaucheEnDate}" /></td>
					<td>${e.salaire}</td>
					<td>${e.adresse.numero}&nbsp;${e.adresse.voie}&nbsp;${e.adresse.ville}</td>
					<td><a href="./employe/edit?id=${e.numero}"
						class="btn btn-outline-primary">editer</a></td>
					<td><a href="./employe/delete?id=${e.numero}"
						class="btn btn-outline-danger">supprimer</a></td>
				</tr>
			</c:forEach>
		</table>
		<a href="./employe/add" class="btn btn-outline-link">ajouter un
			employe</a>
	</div>
</body>
</html>