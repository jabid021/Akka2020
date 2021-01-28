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
		<div>
			<div align="center">
				<h1>detail de la categorie ${categorie.nom}</h1>
			</div>

			<c:if test="${!empty categorie.categorieMere}">
				<div>
					<h2>categorie mere:</h2>
					<a href="${ctx}/categorie/detail?id=${categorie.categorieMere.id}"
						class="btn btn-link">${categorie.categorieMere.nom}</a>
				</div>
			</c:if>


			<c:if test="${!empty categorie.sousCategories}">
				<div>
					<h2>sous categorie:</h2>
				</div>
				<div>
					<c:forEach items="${categorie.sousCategories}" var="sc">
						<a href="${ctx}/categorie/detail?id=${sc.id}" class="btn btn-link">${sc.nom}</a>
					</c:forEach>
				</div>
			</c:if>

			<div>
				<h2>information</h2>
				<p>${categorie.description}</p>
			</div>
			<div>
				<h3>produit de la categorie</h3>
				<table class="table">
					<c:forEach items="${categorie.produits}" var="p">
						<tr>
							<td>${p.id}</td>
							<td>${p.nom}</td>
							<td><a href="${ctx}/produit/edit?id=${p.id}">detail</a></td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
</body>
</html>