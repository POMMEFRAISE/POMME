<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page import="model.Partie"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Rejoindre une partie</title>
<%@include file="header.jsp"%>
</head>
<body>

	<!-- sidebar -->
	<div id="sidebar-nav">
		<ul id="dashboard-menu">
			<li><a href="accueil"> <i class="icon-home"></i> <span>Accueil</span>
			</a></li>
			<li><a class="dropdown-toggle" href="#"> <i
					class="icon-group"></i> <span>Jouer</span> <i
					class="icon-chevron-down"></i>
			</a>
				<ul class="submenu">
					<li><a href="creerpartie">Créer une partie</a></li>
					<li><a href="rejoindrepartie">Rejoindre une partie</a></li>
				</ul></li>
		</ul>
	</div>
	<!-- end sidebar -->

	<!-- main container -->
	<div class="content">

		<div id="pad-wrapper" class="datatables-page">

			<h1>Liste des parties</h1>
			</br>

			<div class="row">
				<div class="col-md-12">

					<table cellpadding="0" cellspacing="0" border="0" class=""
						id="acceuil">
						<thead>
							<tr role="row">
								<th tabindex="0" rowspan="1" colspan="1">Nom de la partie</th>
								<th tabindex="0" rowspan="1" colspan="1">Nombre de joueurs</th>
								<th tabindex="0" rowspan="1" colspan="1">Nombre de joueurs</th>
							</tr>
						</thead>
						<tbody>

							<tr class="gris">
							<tr>

								<td>
									<%
										Partie p = new Partie("p1", 3);
									%> 
									<a href="jeu"><%=p.getNom()%></a>

								</td>
								<td><%=p.getNbJoueurs()%></td>

							</tr>
						</tbody>
					</table>

				</div>
			</div>

		</div>
	</div>
	<!-- end main container -->

</body>
</html>