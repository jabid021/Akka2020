<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/taglib.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<!-- importer le fichier de style -->
<link rel="stylesheet" href="css/style.css">
<title>Accueil Inventaire</title>
</head>
<body>

	${sessionScope.compte}
	<div id="container">
		<!-- zone de connexion -->
		<div>
			<h1>Se connecter</h1>
		</div>
		<form action="home" method="POST">

			<label><b>Login</b></label> <input type="text"
				placeholder="Entrer votre Login" name="login" required> <label><b>Mot
					de passe</b></label> <input type="password"
				placeholder="Entrer le mot de passe" name="password" required>

			<input type="submit" id='submit' value='LOGIN'>
			<div class="error">${error}</div>
		</form>
	</div>
</body>
</html>