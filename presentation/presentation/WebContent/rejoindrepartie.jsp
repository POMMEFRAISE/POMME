<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<fmt:setLocale value="${fr_FR}" />
<fmt:setBundle basename="internationalisation.message_fr_FR" />

<%@page import="model.Partie"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><fmt:message key="rejoindre.partie" /></title>
<%@include file="include/header.jsp"%>
<%@include file="include/menu.jsp"%>
<%@include file="include/footer.jsp"%>
</head>
<body background="img/fond_ecran.jpg">

	<center>
		<table cellpadding="0" cellspacing="0" border="0" class=""
			id="acceuil">
			<caption>
				<fmt:message key="rejoindre.partie.liste" />
			</caption>
			<thead>
				<tr>
					<th rowspan="1" colspan="1"><fmt:message
							key="rejoindre.partie.nom" /></th>
					<th rowspan="1" colspan="1"><fmt:message
							key="rejoindre.partie.nb.joueurs" /></th>
					<th rowspan="1" colspan="1"><fmt:message
							key="rejoindre.partie.statut" /></th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>
						<%
							Partie p = new Partie("p1", 3);
						%> <a href="navigation?nav=jeu"><%=p.getNom()%></a>

					</td>
					<td><%=p.getNbJoueurs()%></td>
					<td>ouverte</td>
				</tr>
				<tr>
				<td>
						<%
							Partie pp = new Partie("p2", 3);
						%> <a href="navigation?nav=jeu"><%=pp.getNom()%></a>

					</td>
					<td><%=p.getNbJoueurs()%></td>
					<td>ouverte</td>
				</tr>
				<tr>
				<td>
						<%
							Partie ppp = new Partie("p3", 3);
						%> <a href="navigation?nav=jeu"><%=ppp.getNom()%></a>

					</td>
					<td><%=p.getNbJoueurs()%></td>
					<td>ouverte</td>
					</tr>
			</tbody>
		</table>
	</center>
</body>
</html>