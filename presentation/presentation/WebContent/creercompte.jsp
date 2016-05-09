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
<title><fmt:message key="creation.compte" /></title>
<link rel="stylesheet" type="text/css" href="css/style.css">
<%@include file="include/footer.jsp"%>
</head>
<body background="img/fond_ecran.jpg">
	<form method="post" action="navigation?nav=formcreercompte">
		<fieldset class="formcreercompte">
			<legend><fmt:message key="creation.compte.nouveau" /></legend>
			
			<label><fmt:message key="creation.compte.login" /> : </label> 
			<input type="text" name="login" value="" id="login" size="30" required /><br /><br /> 
			
			<label><fmt:message key="creation.compte.mot.de.passe" /> : </label> 
			<input type="password" name="pwd" value="" id="pwd" size="30" required /><br /><br />
			
			<label><fmt:message key="creation.compte.nom" /> : </label> 
			<input type="text" name="nom" value="" id="nom" size="30" required /><br /><br />
			
			<label><fmt:message key="creation.compte.prenom" /> : </label> 
			<input type="text" name="prenom" value="" id="prenom" size="30" required /><br /><br /><br />
			
			<input type="submit" value="<fmt:message key="creation.compte.confirmer" />" class="buttonsubmit" /> 
			
			<input type="reset"	value="<fmt:message key="creation.compte.effacer" />" class="buttonreset" /><br /> 
			<br /><br />
            <font color="red"><b>
            ${message }
            </b></font>
		</fieldset>
	</form>
</body>
</html>