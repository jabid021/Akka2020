<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome ${login} - ${param.id}</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">

</head>
<body>


	<div class="container-fluid">
		<div class="row">
			<div class="col-3"> <img src='img/${oeuvre.image}'></div>
			<div class="col-9"> ${oeuvre.libelle} (${oeuvre.id}) </div>
		</div>
		<p>${oeuvre.description}</p>
		<p>${oeuvre.editeur}</p>
	</div>
	
	<a href="listOeuvre.jsp">RETOUR</a>
</body>
</html>