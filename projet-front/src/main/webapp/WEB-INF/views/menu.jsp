<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.servletContext.contextPath}"></c:set>
<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
	<a class="navbar-brand" href="${ctx}">EShop</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown"
		aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarNavDropdown">
		<ul class="navbar-nav">
			<li class="nav-item active"><a class="nav-link" href="${ctx}">home
					<span class="sr-only">(current)</span>
			</a></li>
			<li class="nav-item"><a class="nav-link" href="${ctx}/produit">produits</a></li>
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" href="#"
				id="navbarDropdownMenuLink" data-toggle="dropdown"
				aria-haspopup="true" aria-expanded="false"> gestion des
					categorie </a>
				<div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
					<a class="dropdown-item" href="${ctx}/categorie">liste des
						categories</a> <a class="dropdown-item" href="${ctx}/categorie/add">creation
						nouvelle categorie</a>

					<form class="dropdown-item form-inline"
						action="${ctx}/categorie/detail" method="get">
						<div class="form-group">
							<input class="form-control" name="id"
								placeholder="numero de categorie">
							<button class="btn btn-outline-primary">recherche</button>
						</div>
					</form>
				</div></li>
		</ul>
	</div>

</nav>
