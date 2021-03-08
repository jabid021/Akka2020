<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
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
		<jsp:include page="../logout.jsp"></jsp:include>
		<div>
			<a href="?lang=fr" class="btn btn-link"><spring:message
					code="francais"></spring:message></a> <a href="?lang=en"
				class="btn btn-link"><spring:message code="anglais"></spring:message></a>
		</div>
		<table class="table">
			<tr>
				<th><spring:message code="personne.id"></spring:message></th>
				<th><spring:message code="personne.prenom"></spring:message></th>
				<th><spring:message code="personne.nom"></spring:message></th>
				<th></th>
				<th></th>
			</tr>
			<c:forEach items="${personnes}" var="p">
				<tr>
					<td>${p.id}</td>
					<td>${p.prenom}</td>
					<td>${p.nom}</td>
					<sec:authorize access="hasRole('ROLE_ADMIN')">
						<td><a href="./secure/personne/edit?id=${p.id}"
							class="btn btn-outline-primary"><spring:message code="edit"></spring:message></a></td>
						<td><a href="./secure/personne/delete?id=${p.id}"
							class="btn btn-outline-danger"><spring:message code="delete"></spring:message></a></td>
					</sec:authorize>
				</tr>
			</c:forEach>
		</table>
		<a href="./personne/add" class="btn btn-link"><spring:message
				code="add"></spring:message></a>
	</div>
</body>
</html>