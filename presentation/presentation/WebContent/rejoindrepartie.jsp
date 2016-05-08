<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<fmt:setLocale value="${fr_FR}" />
<fmt:setBundle basename="internationalisation.message_fr_FR" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><fmt:message key="rejoindre.partie" /></title>
<%@include file="include/header.jsp"%>
<%@include file="include/menu.jsp"%>
<%@include file="include/footer.jsp"%>
</head>
<body background="img/fond.jpg">
	<form method="post" action="navigation?nav=formrejoindrepartie">
	<center>
		<table cellpadding="0" cellspacing="0" border="0" class=""
			id="acceuil">
			<caption>
				<fmt:message key="rejoindre.partie.liste" />
			</caption>
			<jsp:useBean id="listeParties" scope="request" class="model.Parties"/>
			<thead>
				<tr>
					<th rowspan="1" colspan="1"><fmt:message
							key="rejoindre.partie.nom" /></th>
					<th rowspan="1" colspan="1"><fmt:message
							key="rejoindre.partie.nb.joueurs" /></th>
					<th rowspan="1" colspan="1"><fmt:message
							key="rejoindre.partie.rejoindre" /></th>
				</tr>
				<c:forEach items="${listeParties.getParties()}" var="partie">
					<tr>
						<td>${partie.nom}</td>
						<td>${partie.nbJoueurs}</td>
						<td>
						   <input type="submit" name="partieARejoindre" value="${partie.getNom()}" class="buttonsubmit"/>
						</td>
					</tr>
				</c:forEach>
			</thead>
			<tbody>

			</tbody>
		</table>
	</center>
	</form>
<div class="des">
<img src="img/des.png">
</div>
</body>
</html>