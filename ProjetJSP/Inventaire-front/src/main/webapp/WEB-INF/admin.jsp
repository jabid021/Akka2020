<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gestion Admin</title>


</head>
<body>
	<a id="btnDisconnect" href="disconnect"><input type="button"
		class="btn btn-danger" value="Se deconnecter"></a>
	<div id="content">
		<ul class="nav nav-pills mb-3" id="pills-tab" role="tablist">
			<li class="nav-item"><a class="nav-link active"
				id="pills-emp-tab" data-toggle="pill" href="#pills-emp" role="tab"
				aria-controls="pills-emp" aria-selected="true">Gestion employés</a>
			</li>
			<li class="nav-item"><a class="nav-link " id="pills-ordi-tab"
				data-toggle="pill" href="#pills-ordi" role="tab"
				aria-controls="pills-ordi" aria-selected="false">Gestion
					ordinateurs</a></li>
		</ul>
		<div class="tab-content" id="pills-tabContent">
			<div class="tab-pane fade show active" id="pills-emp" role="tabpanel"
				aria-labelledby="pills-emp-tab">
				
				<input type="text" placeholder="Filtrer par login" id="filterName">
				
				<h1>Liste des employés</h1>
				<input id="btnAddEmp" type="button" class="btn btn-success"
					value="Ajouter">
				<table class="table table-striped">
					<thead>
						<tr>
							<th>Id</th>
							<th>Login</th>
							<th>Password</th>
							<th>Mail</th>
							<th>PC</th>
							<th>Actions</th>
						</tr>
					</thead>
					<tbody id="contentEmp">
						<c:forEach items="${employes}" var="emp">

							<tr>
								<td>${emp.id}</td>
								<td>${emp.login}</td>
								<td>${emp.password}</td>
								<td>${emp.mail}</td>
								<td>${emp.pc.id}-${emp.pc.marque}</td>
								<td><input
									onclick="updateEmp(${emp.id},'${emp.login}','${emp.password}','${emp.mail}',${emp.pc.id},'${emp.pc.marque}')"
									type="button" class="btn btn-warning" value="Modifier">

									<form class="formDelete" action="emp" method="post">
										<input type="hidden" value="${emp.id}" name="id_emp">
										<input type="submit" name="btnForm" class="btn btn-danger"
											value="Supprimer">
								</form>
								</td>
							</tr>

						</c:forEach>

					</tbody>
				</table>



				<div id="addFormEmp">
					<h3>Ajouter nouveau Employé</h3>
					<form action="emp" method="post">
						<label for="add_login">Login :</label> <input required
							id="add_login" name="login" type="text"
							placeholder="Saisir votre login"><br> <label
							for="add_password">Password :</label> <input required
							id="add_password" name="password" type="password"
							placeholder="Saisir votre password"><br> <label
							for="add_mail">Mail :</label> <input required id="add_mail"
							name="mail" type="email" placeholder="Saisir votre mail"><br>
						<label for="add_pc">PC : </label> <select id="add_pc" name="id_pc">
							<option value="choose" selected="selected">Choisir un Pc</option>
							<c:forEach items="${pcDispos}" var="pc">
								<option value="${pc.id}">${pc.id}-${pc.marque}</option>
							</c:forEach>
						</select><br> <input name="btnForm" class="btn btn-success"
							type="submit" value="Ajouter">
					</form>
				</div>

				<div id="updateFormEmp">
					<h3>Modifier l'employé</h3>
					<form action="emp" method="post">

						<input type="hidden" id="update_id_emp" name="id_emp"> <label
							for="update_login">Login :</label> <input required
							id="update_login" name="login" value="red" type="text"
							placeholder="Saisir votre login"><br> <label
							for="update_password">Password :</label> <input required
							id="update_password" name="password" type="password"
							placeholder="Saisir votre password"><br> <label
							for="update_mail">Mail :</label> <input required id="update_mail"
							name="mail" value="re@gmail.com" type="email"
							placeholder="Saisir votre mail"><br> <label
							for="update_pc">PC : </label> <select id="update_pc" name="id_pc">
							<option id="update_pc_selected" selected="selected"></option>
							<c:forEach items="${pcDispos}" var="pc">
								<option value="${pc.id}">${pc.id}-${pc.marque}</option>
							</c:forEach>
						</select><br> <input name="btnForm" class="btn btn-warning"
							type="submit" value="Modifier">
					</form>
				</div>

			</div>


















































			<!-- Tableau gestion des machines (showAll + add + update + delete) -->
			<div class="tab-pane fade" id="pills-ordi" role="tabpanel"
				aria-labelledby="pills-ordi-tab">


				<h1>Liste des machines</h1>
				<input id="btnAddPC" type="button" class="btn btn-success"
					value="Ajouter">

				<table class="table table-striped">
					<thead>
						<tr>
							<th>Numero</th>
							<th>Marque</th>
							<th>RAM</th>
							<th>Employé</th>
							<th>Actions</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${listePc}" var="pc">
							<tr>
								<td>${pc.id}</td>
								<td>${pc.marque}</td>
								<td>${pc.RAM}</td>
								<c:choose>
									<c:when test="${pc.employe==null}">
										<td>Disponible</td>
									</c:when>
									<c:otherwise>
										<td>${pc.employe.login}</td>
									</c:otherwise>
								</c:choose>

								<td><input
									onclick="updatePC(${pc.id},'${pc.marque}',${pc.RAM})"
									type="button" class="btn btn-warning" value="Modifier">

									<c:choose>
										<c:when test="${pc.employe==null}">
											<form class="formDelete" action="pc" method="post">
												<input type="hidden" value="${pc.id}" name="id_pc">
												<input type="submit" name="btnForm" class="btn btn-danger"
													value="Supprimer"></td>
								</form>
								</c:when>
								<c:otherwise>
									<input disabled name="btnForm" type="button"
										class="btn btn-danger" value="Supprimer" />
									</td>



								</c:otherwise>
								</c:choose>



							</tr>
						</c:forEach>
					</tbody>
				</table>


				<div id="addFormPC">
					<h3>Ajouter nouveau PC</h3>
					<form action="pc" method="post">
						<label for="add_marque">Marque : </label> <select id="add_marque"
							name="marque">
							<option selected="selected">Choisir une marque</option>
							<c:forEach items="${marques}" var="marque">
								<option value="${marque}">${marque}</option>
							</c:forEach>

						</select> <br> <label for="add_ram">RAM</label> <input value="8"
							id="add_ram" name="ram" type="number"><br> <input
							class="btn btn-success" type="submit" name="btnForm"
							value="Ajouter">
					</form>
				</div>


				<div id="updateFormPC">
					<h3>Modifier le PC</h3>
					<form action="pc" method="post">
						<input type="hidden" id="update_id_pc" name="id_pc"> <label
							for="update_marque">Marque : </label> <select id="update_marque"
							name="marque">

						</select> <br> <label for="update_ram">RAM</label> <input value="16"
							id="update_ram" name="ram" type="number"><br> <input
							class="btn btn-warning" type="submit" name="btnForm"
							value="Modifier">
					</form>
				</div>



			</div>
		</div>
	</div>




</body>
</html>




<script>



marquePC=new Array();

<c:if test="${empty pcDispos}">
btnAddEmp.style.display="none";
</c:if>
 <c:forEach items="${marques}" var="marque">
 marquePC.push("${marque}");
</c:forEach>

//GESTION Employé
btnAddEmp.onclick=function()
{
	updateFormEmp.style.display="none";
	addFormEmp.style.display="block";
}

function updateEmp(id,login,password,mail,numPc,marquePc)
{
	addFormEmp.style.display="none";
	updateFormEmp.style.display="block";

	update_login.value=login;
	update_password.value=password;
	update_mail.value=mail;


	update_pc_selected.value=numPc;
	update_pc_selected.innerHTML=numPc+"-"+marquePc;
	
	update_id_emp.value=id;
}

//Gestion MACHINE


btnAddPC.onclick=function()
{
	updateFormPC.style.display="none";
	addFormPC.style.display="block";
}

function updatePC(id,marque,ram)
{
	updateFormPC.style.display="block";
	addFormPC.style.display="none";

	update_id_pc.value=id;
	update_ram.value=ram;
	optionsSelect="";
	var optionsSelect;
	for(i in marquePC)
	{
		isSelected=(marquePC[i]==marque) ? "selected=selected" : "";
		optionsSelect+="<option "+isSelected+" value='"+marquePC[i]+"' >"+marquePC[i]+"</option>";
	}

	update_marque.innerHTML=optionsSelect;
}

filterName.onkeyup=function filterEmp()
{
	var filter=filterName.value;
	$.ajax("filterEmp",
		{ 
			type: "POST", 
			data: 
			{ 
				filterName:filter
			}, 
			success: function (resp) 
			{ 
				contentEmp.innerHTML=resp;
			} 
		}); 
};


</script>