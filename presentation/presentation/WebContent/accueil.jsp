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
<title><fmt:message key="accueil" /></title>
<%@include file="include/header.jsp"%>
<%@include file="include/menu.jsp"%>
<%@include file="include/footer.jsp"%>
<title><fmt:message key="accueil" /></title>
</head>
<body>
	<div class="message">
		<h3>
			<fmt:message key="accueil.bienvenue" /> <%=joueur.getLogin()%> <fmt:message key="accueil.point" />
		</h3>
		<img src="img/jeux-de-des.jpg" >
	</div>
</body>
</html>