<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="config.Context"%>
<%@ page import="model.Oeuvre"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">

</head>
<body>


<% 
Class.forName("com.mysql.jdbc.Driver");
int id = Integer.parseInt(request.getParameter("id")); 
	Oeuvre e = Context.getInstance().getDaoOeuvre().findById(id);
%>

	<div class="container-fluid">
		<div class="row">
			<div class="col-3"><%= "<img src='img/"+e.getImage()+"'>" %></div>
			<div class="col-9"><%= e.getLibelle()+"( "+e.getId()+" )" %></div>
		</div>
		<p><%=e.getDescription() %></p>
		<p><%= e.getEditeur() %></p>
	</div>
	
	<a href="listOeuvre.jsp">RETOUR</a>
</body>
</html>