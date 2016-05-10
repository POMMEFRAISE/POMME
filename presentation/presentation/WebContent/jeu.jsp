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
<title><fmt:message key="jeu" /></title>
<%@include file="include/header.jsp"%>
<%@include file="include/footer.jsp"%>

<script type="text/javascript">
	var requete = null;

	function demandeRedirection() {
		var url = "navigation?nav=redirectionlancer";
		if (window.XMLHttpRequest) {
			requete = new XMLHttpRequest();
		} else if (window.ActiveXObject) {
			requete = new ActiveXObject("Microsoft.XMLHTTP");
		}
		requete.onreadystatechange = function() {
			var message = "";
			if (requete.readyState == 4) {
				if (requete.status == 200) {
					// exploitation des données de la réponse
					var message = requete.responseText;
					var redirection;
					console.log(message);
					if (message === "") {
						redirection = "navigation?nav=jeu";
					} else {
						redirection = "navigation?nav=accueil";
					}
					window.location = redirection;
				}
			}
		};

		requete.open("GET", url, true);
		requete.send(null);
	};

	function interromptRequete() {
		requete.abort();
		alert("Requête interompu");
	};
</script>

</head>
<body onload="demandeRedirection();">
	<center>
		<jsp:useBean id="jeu" scope="session" class="model.Jeu" />
		${jeu.getPartie().getNom()}

		<center>
			<table>
				<c:forEach items="${jeu.getJoueurs().getJoueurs()}" var="unJoueur">
					<c:if test="${unJoueur.isDoitJouer() == true}">
						<tr>
							<td><center>${unJoueur.getJoueurGauche().getLogin()}</center></td>
							<td><center>${unJoueur.getLogin()}</center></td>
							<td><center>${unJoueur.getJoueurDroite().getLogin()}</center></td>
						</tr>
						<tr>
							<td><img src="img/joueur.png"></td>
							<td><img src="img/joueur.png"></td>
							<td><img src="img/joueur.png"></td>
						</tr>
					</c:if>
				</c:forEach>
			</table>
		</center>
		<fmt:message key="jeu.lancer.des.resultat" />
		<center>
			<table>
				<tr>
					<c:if test="${jeu.getDes().getDes() != null}">
						<td><img src="img/${jeu.getDes().getDes().get(0).getImage()}"></td>
						<td><img src="img/${jeu.getDes().getDes().get(1).getImage()}"></td>
						<td><img src="img/${jeu.getDes().getDes().get(2).getImage()}"></td>
						<td><img src="img/${jeu.getDes().getDes().get(3).getImage()}"></td>
						<td><img src="img/${jeu.getDes().getDes().get(4).getImage()}"></td>
					</c:if>
				</tr>
			</table>
		</center>
		<c:forEach items="${jeu.getJoueurs().getJoueurs()}" var="unJoueurPremier">		
			<c:if test="${unJoueurPremier.isPremier() == true}">
					<fmt:message key="jeu.lancer.joueur.premier" />${unJoueurPremier.getLogin()}                
			</c:if>
		</c:forEach>
		<br />
		<br />
		<c:forEach items="${jeu.getJoueurs().getJoueurs()}" var="unJoueur">
			<c:if test="${unJoueur.isDoitJouer() != false}">
				<fmt:message key="jeu.lancer.joueur.suivant" />${unJoueur.getLogin()}                
			</c:if>
		</c:forEach>
		<c:forEach items="${jeu.getJoueurs().getJoueurs()}" var="unJoueur">
			<c:if test="${unJoueur.isDoitJouer() != false && unJoueur.getLogin() eq joueur.getLogin()}">
				<c:if test="${unJoueur.getResultatPremierLancer() == 0}">
					<form method="post" action="navigation?nav=formjeupremierlancer">
						<input type="submit" onclick="interromptRequete();"
							value="<fmt:message key="jeu.lancer.des.premier" />"
							class="buttonsubmit" />
					</form>
				</c:if>
				<c:if test="${unJoueur.getResultatPremierLancer() != 0}}">
					<form method="post" action="navigation?nav=formjeujoueur">
						<input type="submit" onclick="interromptRequete();"
							value="<fmt:message key="jeu.lancer.des.jouer" />"
							class="buttonsubmit" />
					</form>
				</c:if>
			</c:if>
		</c:forEach>
	</center>
</body>
</html>