<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%--<fmt:setLocale value="fr_FR" scope="session"/> --%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Accueil</title>
<%@include file="header.jsp"%>
</head>
<body>

	<!-- sidebar -->
	<div id="sidebar-nav">
		<ul id="dashboard-menu">
			<li class="active">
				<div class="pointer">
					<div class="arrow"></div>
					<div class="arrow_border"></div>
				</div> <a href="accueil"> <i class="icon-home"></i> <span>Accueil</span>
			</a>
			</li>
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
		<div id="pad-wrapper" class="new-user">
			<div class="row header">
				<div class="col-md-12">
					<h3>Bienvenue !</h3>
				</div>
			</div>
		</div>
			<center><img src="img/jeux-de-des.jpg"></center>
	</div>
	<!-- end main container -->
</body>
</html>