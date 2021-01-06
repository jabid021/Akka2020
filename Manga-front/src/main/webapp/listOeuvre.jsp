<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.*"%>
<%@ page import="config.Context"%>
<%@ page import="model.Oeuvre"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>title</title>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">


</head>
<body>
<%

Class.forName("com.mysql.jdbc.Driver");

List<Oeuvre> oeuvres = Context.getInstance().getDaoOeuvre().findAll();%>
<table class="table table-striped">
<tr>
<th>image</th>
<th>id</th>
<th>libelle</th>
<th>editeur</th>


</tr>

<%
for(Oeuvre e: oeuvres)
{
out.println("<tr><td><img width=50 src='img/"+e.getImage()+"'></td><td>"+e.getId()+"</td><td> <a href='fiche.jsp?id="+e.getId()+"'>"+e.getLibelle()+"</a></td><td>"+e.getEditeur()+"</td></tr>");
}
%>

</table>

<!-- La page doit afficher un tableau avec toutes les oeuvres -->


</body>
</html>