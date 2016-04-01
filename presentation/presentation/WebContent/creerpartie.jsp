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
</head>
<body>

	<!-- sidebar -->
	<div id="sidebar-nav">
		<ul id="dashboard-menu">
			<li><a href="accueil"> <i class="icon-home"></i> <span><fmt:message key="creation.partie.accueil" /></span>
			</a></li>
			<li><a class="dropdown-toggle" href="#"> <i
					class="icon-group"></i><span><fmt:message key="creation.partie.jouer" /></span> <i
					class="icon-chevron-down"></i>
			</a>
				<ul class="submenu">
					<li><a href="creerpartie"><fmt:message key="creation.partie.creer" /></a></li>
					<li><a href="rejoindrepartie"><fmt:message key="creation.partie.rejoindre.partie" /></a></li>
				</ul></li>
		</ul>
	</div>
	<!-- end sidebar -->
	
	<!-- main container -->
    <div class="content">
    <div id="pad-wrapper" class="new-user">
            <div class="row header">
                <div class="col-md-12">
                    <h3><fmt:message key="creation.partie.creer.nouvelle" /></h3>
                </div>                
            </div>

            <div class="row form-wrapper">
                <!-- left column -->
                <div class="col-md-9 with-sidebar">
                    <div class="container">

                        <form class="new_user_form" role="form" id="creerfreelance" method="post">
                            <div class="col-md-12 field-box">
                                <label><span class="help-required"></span><fmt:message key="creation.partie.nom" /> :</label>
                                <div class="col-md-9">
                                    <input class="form-control required" aria-required="true" role="input" type="text" name="nom" id="nom" value=""/>
                                </div>
                            </div>
                            <div class="col-md-12 field-box">
                                <label for="prenom"><fmt:message key="creation.partie.nb.joueurs" /> :</label>
                                <div class="col-md-9">
                                    <input class="form-control" type="text" name="prenom" id="prenom" value="" role="input" />
                                </div>
                            </div>
                            <div class="col-md-11 field-box actions">
                                <input type="submit" value="<fmt:message key="creation.partie.creer" />" name="submit" id="submitButton" class="btn-glow primary" title="Cliquez ici pour créer!" />
                                <span>OU</span>
                                <a class="btn-flat info" onClick="history.back()">
                                    <i class="icon-reply"></i><fmt:message key="creation.partie.retour" />
                                </a>
                            </div>
                    </div>
                </div>

            </div>
        </div>
    </div>
    <!-- end main container -->
    
</body>
</html>