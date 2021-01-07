<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<!-- importer le fichier de style -->
<link rel="stylesheet" href="style.css">
</head>
<body>
	<div id="container">
		<!-- zone de connexion -->
		<div>
			<h1>Se connecter</h1>
		</div>
		<form action="connect.html" method="POST">

			<label><b>Login</b></label> <input type="text"
				placeholder="Entrer votre Login" name="username" required> <label><b>Mot
					de passe</b></label> <input type="password"
				placeholder="Entrer le mot de passe" name="password" required>

			<input type="submit" id='submit' value='LOGIN'>
		</form>
	</div>
</body>
</html>