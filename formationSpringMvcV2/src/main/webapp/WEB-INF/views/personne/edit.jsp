<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><%@ taglib prefix="c"
	uri="http://java.sun.com/jsp/jstl/core"%>

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
		<h1>edition personne</h1>
		<form action="save" method="post">
			<input type="hidden" name="version" value="${personne.version}">
			<div class="form-group">
				<label>id:</label> <input class="form-control" name="id"
					value="${personne.id}" readonly="readonly"
					placeholder="generation automatique">
			</div>
			<div class="form-group">
				<label>prenom:</label> <input class="form-control" name="prenom"
					value="${personne.prenom}">
			</div>
			<div class="form-group">
				<label>nom:</label> <input class="form-control" name="nom"
					value="${personne.nom}">
			</div>
			<div class="form-group">
				<button type="submit" class="btn btn-outline-success">enregistrer</button>
				<a href="../personne" class="btn btn-outline-warning">annuler</a>
			</div>
		</form>
	</div>
</body>
</html>