<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
		<h1>edition ordinateur</h1>
		<form:form action="save" method="post" modelAttribute="ordinateur">
			<div class="form-group">
				<form:label path="id">id:</form:label>
				<form:input path="id" cssClass="form-control" readonly="true" />
			</div>
			<div class="form-group">
				<form:label path="marque">marque</form:label>
				<form:select path="marque" items="${marques}"
					cssClass="form-control">
				</form:select>
			</div>
			<div class="form-group">
				<form:label path="RAM">memoire:</form:label>
				<form:input path="RAM" type="number" min="4" cssClass="form-control" />
				<form:errors path="RAM" element="div" cssClass="alert alert-danger"></form:errors>
			</div>
			<div class="form-group">
				<button type="submit" class="btn btn-outline-success">enregistrer</button>
				<a href="../ordinateur" class="btn btn-outline-warning">annuler</a>
			</div>
		</form:form>
	</div>
</body>
</html>