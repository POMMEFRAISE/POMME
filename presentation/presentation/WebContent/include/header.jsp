<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="model.Joueur"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
<link rel="stylesheet" type="text/css" href="css/style.css">

<div id="menubar">
	<div class="head"></div>
	<div class="iconmenu"></div>
	<div class="bienvenue">
		<jsp:useBean id="joueur" scope="session" class="model.Joueur" />
		<jsp:getProperty name="joueur" property="prenom" /> <jsp:getProperty name="joueur" property="nom" />
	</div>
		<a href="navigation?nav=deconnexion"><img src="img/deconnexion.png" class="deconnexion"></a>
</div>
</head>
<body>