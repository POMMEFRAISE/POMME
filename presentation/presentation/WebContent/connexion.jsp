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
<title><fmt:message key="connexion.authentification" /></title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body background="img/fond_ecran.jpg">
	<form method="post" action="connexion">
      <fieldset>
                <legend><fmt:message key="connexion.authentification" /></legend>
                
<%--                Réafficher valeur en cas de erreur de saisie   
					<label>Login : </label> 
                    <input type="text" name="login"  value="<%out.print(j.getLogin());%>" id="login" size="30" required /><br /><br />
                    <label>Mot de passe : </label> 
                    <input type="password" name="pwd" value="<%out.print(j.getPwd());%>" id="pwd" size="30" required /><br /><br /><br />
                    --%>  
                     
                    <label><fmt:message key="connexion.login" /> : </label> 
                    <input type="text" name="login"  value="" id="login" size="30" required /><br /><br />
                    <label><fmt:message key="connexion.motdepasse" /> : </label> 
                    <input type="password" name="pwd" value="" id="pwd" size="30" required /><br /><br /><br />
                     
                    <input type="submit" value="<fmt:message key="connexion.confirmer" />" class="buttonsubmit" />
                    <input type="reset" value="Effacer" class="buttonreset" />
            </fieldset>
        </form>
</body>
</html>