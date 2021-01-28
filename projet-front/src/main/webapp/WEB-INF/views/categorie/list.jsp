<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<c:set var="ctx" value="${pageContext.servletContext.contextPath}"></c:set>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>
<meta charset="UTF-8">
<title>eshop</title>
</head>
<body>
	<div class="container">
		<jsp:include page="../menu.jsp"></jsp:include>
		<h1>liste des categories</h1>
		<c:choose>
			<c:when test="${param.error =='id' }">
				<div class="alert alert-danger">id categorie inconnu</div>
			</c:when>
		</c:choose>
		<c:choose>
			<c:when test="${param.info == 'save'}">
				<div class="alert alert-success">categorie modifie</div>
			</c:when>
			<c:when test="${param.info == 'cancel'}">
				<div class="alert alert-info">operation annulée</div>
			</c:when>
		</c:choose>
		<table class="table">
			<tr>
				<th>id</th>
				<th>nom</th>
				<th>description</th>
				<th></th>
				<th></th>
				<th></th>
			</tr>
			<c:forEach var="o" items="${categories}">
				<tr>
					<td>${o.id}</td>
					<td>${o.nom}</td>
					<td>${o.description}</td>
					<td><a href="${ctx}/categorie/detail?id=${o.id}"
						class="btn btn-link">detail</a></td>
					<td><a href="${ctx}/categorie/edit?id=${o.id}"
						class="btn btn-outline-primary">editer</a></td>
					<td><a href="${ctx}/categorie/delete?id=${o.id}"
						class="btn btn-outline-danger">supprimer</a></td>
				</tr>
			</c:forEach>
		</table>
		<a href="${ctx}/categorie/add" class="btn btn-outline-link">ajouter
			une nouvelle categorie</a>
	</div>
</body>
</html>