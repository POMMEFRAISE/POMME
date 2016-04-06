<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<fmt:setLocale value="${fr_FR}" />
<fmt:setBundle basename="internationalisation.message_fr_FR" />		
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><fmt:message key="creation.partie" /></title>
<%@include file="header.jsp"%>
<%@include file="menu.jsp"%>
</head>
<body background="img/fond_ecran.jpg">

	<form method="post" action="navigation?nav=creerpartie">
      <fieldset>
                <legend><fmt:message key="creation.partie.creer.nouvelle" /></legend>
                     
                    <label><fmt:message key="creation.partie.nom" /> : </label> 
                    <input type="text" name="nom"  value="" id="nom" size="30" required /><br /><br />
                    <label><fmt:message key="creation.partie.nb.joueurs" /> : </label> 
                    <input type="password" name="nbjoueur" value="" id="nbjoueur" size="30" required /><br /><br /><br />
                     
                    <input type="submit" value="<fmt:message key="creation.partie.creer" />" class="buttonsubmit" />
                    <input type="reset" value="<fmt:message key="connexion.effacer" />" class="buttonreset" />
            </fieldset>
        </form>  
</body>
</html>