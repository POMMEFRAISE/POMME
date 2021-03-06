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
</head>
<body>
<nav>
<div id="menu">
		<fmt:message key="menu" />
</div>
	<ul>
		<li><a href="navigation?nav=accueil"><img src="img/accueil.png">  <fmt:message key="menu.accueil" /></a></li>
		<li><a href=""><img src="img/de_icone.png">  <fmt:message key="menu.jouer" /></a>
		<ul>
			<li><a href="navigation?nav=creerpartie"><fmt:message
						key="menu.creer.partie" /></a></li>
			<li><a href="navigation?nav=rejoindrepartie"><fmt:message
						key="menu.rejoindre.partie" /></a></li>
		</ul>
		</li>
		<li><a href=""><img src="img/profil.png">  <fmt:message key="menu.profil" /></a>
		<ul>
			<li><a href="navigation?nav=modifierprofil"><fmt:message
						key="menu.gerer.profil" /></a></li>
			<li><a href="navigation?nav=consulterscore"><fmt:message
						key="menu.consulter.score" /></a></li>
		</ul>
		</li>
	</ul>
</nav>

</body>
</html>