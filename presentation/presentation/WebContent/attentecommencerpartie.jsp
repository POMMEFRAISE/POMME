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
		<title><fmt:message key="rejoindre.partie.attente" /></title>
		<%@include file="include/header.jsp"%>
		<%@include file="include/menu.jsp"%>
		<%@include file="include/footer.jsp"%>
		
		<script type="text/javascript">
			function demandeRedirection(){
				var requete = null;
				
				var url = "navigation?nav=redirectionJeu";
				if (window.XMLHttpRequest) {
					requete = new XMLHttpRequest();
				} else if (window.ActiveXObject) {
					requete = new ActiveXObject("Microsoft.XMLHTTP");
				}
				requete.onreadystatechange = function(){
					var message = "";
					if (requete.readyState == 4) {
						if (requete.status == 200) {
							// exploitation des données de la réponse
							var message = requete.responseText;
							var redirection
							if(message.equals("")){
								redirection = "navigation?nav=jeu";
							}else{
								redirection ="navigation?nav=accueil&messagErreure=message";
							}
							window.location = redirection;
						}
					}
				};
		
				requete.open("GET", url, true);
				requete.send(null);
			};
		</script>
	</head>
	<body onload="demandeRedirection();" background="img/fond.jpg" >
<%-- 		<jsp:useBean id="jeu" scope="session" class="model.Jeu" />
		<jsp:useBean id="partie" scope="session" class="model.Partie" />
		Vous avez rejoint la <jsp:getProperty name="jeu" property="partie.nom"/>
		<br />
		Elle va bientôt commncer ! --%>
	</body>
</html>