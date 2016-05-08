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
<title><fmt:message key="jeu" /></title>
<%@include file="include/header.jsp"%>
<%@include file="include/menu.jsp"%>
<%@include file="include/footer.jsp"%>
</head>
<body>

	<center>
	<div class="content">
		<div id="pad-wrapper" class="datatables-page">
			<div class="row header">
				<div class="col-md-12">
					<div class="col-md-11 field-box actions">
						<jsp:useBean id="jeu" scope="session" class="model.Jeu" />
						${jeu.getPartie().getNom()}
					</div>
				</div>
			</div>
		</div>
		<center>
			<table>
				<c:forEach items="${jeu.getJoueurs().getJoueurs()}" var="unJoueur">
					<c:if test="${unJoueur.getLogin() eq joueur.getLogin()}">
						<tr>
							<td><center>${unJoueur.getJoueurGauche().getLogin()}</center></td>
							<td></td>
							<td><center>${unJoueur.getJoueurDroite().getLogin()}</center></td>
						</tr>
						<tr>
							<td><img src="img/joueur.png"></td>
							<td><img src="img/table_ronde.png"></td>
							<td><img src="img/joueur.png"></td>
						</tr>
						<tr>
							<td></td>
							<td><center>${unJoueur.getLogin()}</center></td>
							<td></td>
						</tr>
						<tr>
							<td></td>
							<td><center>
									<img src="img/joueur.png">
								</center></td>
							<td></td>
						</tr>
					</c:if>
				</c:forEach>
			</table>
		</center>
		//Afficher résultat dés
		
		<div id="pad-wrapper" class="datatables-page">
			<div class="row header">
				<div class="col-md-12">
					<div class="col-md-11 field-box actions">
						${jeu.getPartie().getNom()}
						<c:forEach items="${jeu.getJoueurs().getJoueurs()}" var="unJoueur">
							<c:if test="${unJoueur.isDoitJoueur() != false}">
								${unJoueur.getLogin()}                
							</c:if>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
		<div id="pad-wrapper" class="datatables-page">
			<div class="row header">
				<div class="col-md-12">
					<div class="col-md-11 field-box actions">
						<c:forEach items="${jeu.getJoueurs().getJoueurs()}" var="unJoueur">
							<c:if test="${unJoueur.isDoitJoueur() != false && unJoueur.getLogin() eq joueur.getLogin()}">
								<c:if test="${unJoueur.resultatPremierLancer() == 0}">
									<input type="submit" value="<fmt:message key="jeu.lancer.des.premier" />" class="buttonsubmit" />
								</c:if>               
								<c:if test="${unJoueur.resultatPremierLancer() != 0}}">
									<input type="submit" value="<fmt:message key="jeu.lancer.des.jouer" />" class="buttonsubmit" />
								</c:if>                  
							</c:if>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- end main container -->
</center>
</body>
</html>