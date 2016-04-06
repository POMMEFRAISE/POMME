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
<title></title>
<div id="menu">
		<fmt:message key="menu" />
</div>
	<ul>
		<li><a href="accueil"><fmt:message key="menu.accueil" /></a></li>
		<li><a href=""><fmt:message key="menu.jouer" /></a>
		<ul>
			<li><a href="navigation?nav=creerpartie"><fmt:message
						key="menu.creer.partie" /></a></li>
			<li><a href="navigation?nav=rejoindrepartie"><fmt:message
						key="menu.rejoindre.partie" /></a></li>
		</ul>
		</li>
	</ul>
</head>
<body>
</body>
</html>