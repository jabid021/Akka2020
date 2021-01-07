<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>title</title>

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">

</head>
<body>

	<!-- <c:if test="${empty oeuvres}">

	</c:if>


	<c:if test="${oeuvres[0].libelle=='One Piece'}">
		C'est Bien OnePiece
	</c:if>
	
	
	<c:if test="${!empty oeuvres}">

	</c:if>-->


	<c:choose>
		<c:when test="${empty oeuvres}">
	
		Pas d'oeuvres en base
	
	</c:when>

		<c:otherwise>
			<table class="table table-striped">
				<tr>
					<th>image</th>
					<th>id</th>
					<th>libelle</th>
					<th>editeur</th>
				</tr>

				<c:forEach items="${oeuvres}" var="o">

					<tr>
						<td><img width=50 src='img/${o.image}'></td>
						<td>${o.id}</td>
						<td><a href='fiche?id=${o.id}'>${o.libelle} </a></td>
						<td>${o.editeur}</td>
					</tr>

				</c:forEach>

			</table>
		</c:otherwise>
	</c:choose>






	<!-- La page doit afficher un tableau avec toutes les oeuvres -->
</body>
</html>