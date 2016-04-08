<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<!-- ---ICI---- -->

<?php
$sLangueNavigateur= substr($_SERVER[‘HTTP_ACCEPT_LANGUAGE’], 0, 2);
if($sLangueNavigateur==en){
?><fmt:setBundle basename="internationalisation.message_en_EN" /><?php
}else{
?><fmt:setBundle basename="internationalisation.message_fr_FR" /><?php
}
?> 
<!-- ---ICI--- -->

<%@page import="model.Joueur"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><fmt:message key="connexion.authentification" /></title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body background="img/fond_ecran.jpg">
	<form method="post" action="navigation?nav=formconnexion">
      <fieldset class="formconnexion">
                <legend><fmt:message key="connexion.authentification" /></legend>
                     
                    <label><fmt:message key="connexion.id" /> : </label> 
                    <input type="text" name="login"  value="" id="login" size="30" required /><br /><br />
                    <label><fmt:message key="connexion.mot.de.passe" /> : </label> 
                    <input type="password" name="pwd" value="" id="pwd" size="30" required /><br /><br /><br />
                     
                    <input type="submit" value="<fmt:message key="connexion.confirmer" />" class="buttonsubmit" />
                    <input type="reset" value="<fmt:message key="connexion.effacer" />" class="buttonreset" />
                    <br /><br />
                    <a href="navigation?nav=creercompte" class="creercompte"><fmt:message key="connexion.creercompte" /></a>
                    <br /> 	        
            </fieldset>
        </form>
</body>
<%@include file="include/footer.jsp"%>
</html>