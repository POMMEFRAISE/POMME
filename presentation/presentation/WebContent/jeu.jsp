<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<fmt:setLocale value="${fr_FR}" />
<fmt:setBundle basename="internationalisation.message_fr_FR" />

<%@page import="model.Joueur"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><fmt:message key="jeu" /></title>
<%@include file="header.jsp"%>
</head>
<body>

	<!-- sidebar -->
	<div id="sidebar-nav">
		<ul id="dashboard-menu">
			<li><a href="accueil"> <i class="icon-home"></i> <span><fmt:message key="jeu.accueil" /></span>
			</a></li>
			<li><a class="dropdown-toggle" href="#"> <i
					class="icon-group"></i> <span><fmt:message key="jeu.jouer" /></span> <i
					class="icon-chevron-down"></i>
			</a>
				<ul class="submenu">
					<li><a href="creerpartie"><fmt:message key="jeu.creer.partie" /></a></li>
					<li><a href="rejoindrepartie"><fmt:message key="jeu.rejoindre.partie" /></a></li>
				</ul></li>
		</ul>
	</div>
	<!-- end sidebar -->

	<!-- main container -->

	<div class="content">
		<div id="pad-wrapper" class="datatables-page">
			<div class="row header">
				<div class="col-md-12">
					<div class="col-md-11 field-box actions">
						<a href="jouer"><input type="submit" value="<fmt:message key="jeu.lancer.des" />" name="submit"
							id="submitButton" class="btn-glow primary"
							title="Cliquez ici pour lancer les d�s !" /></a>
					</div>
				</div>
			</div>
		</div>
		<center>
			<table>
				<tr>
					<%
						Joueur j1 = new Joueur("titi"); //liste de joueurs pr afficher le nom pr cette partie
						Joueur j2 = new Joueur("tata");
					%>
					<td><center><%=j1.getLogin()%></center></td>
					<td></td>
					<td><center><%=j2.getLogin()%></center></td>
				</tr>
				<tr>
					<td><img src="img/joueur.png"></td>
					<td><img src="img/table_ronde.png"></td>
					<td><img src="img/joueur.png"></td>
				</tr>
				<tr>
					<td></td>
					<td><center><%=joueur.getLogin()%></center></td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<td><center>
							<img src="img/joueur.png">
						</center></td>
					<td></td>
				</tr>
			</table>
		</center>
	</div>
	<!-- end main container -->

</body>
</html>