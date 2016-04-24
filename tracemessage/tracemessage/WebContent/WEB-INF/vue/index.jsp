<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.*"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>Gestion des messages</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="bootstrap/css/bootstrap.css" rel="stylesheet">
    <link href="bootstrap/css/bootstrap-responsive.css" rel="stylesheet">
    <link href="css/stylesMiseEnPage.css" rel="stylesheet">
  </head>
  <body>
<%@ include file="../include/enTete.html" %>
    <div class="container">
        <jsp:useBean id="messages" scope="session" class="modele.Messages"></jsp:useBean>
        
<%
            ArrayList<modele.Message> listMessages = (ArrayList<modele.Message>) messages.getMessages();
%>
            <table>
                <tr>
                    <th>Identifiant</th>
                    <th>Type message</th>
                    <th>Statut</th>
                    <th>Source<th>
                <tr>
<%
            for (modele.Message message : listMessages) { 
%> 
                <tr>
                    <td><%= message.getIdentifiantMessage() %></td>
                    <td><%= message.getMessage() %></td>
                    <td><%= message.getStatutMessage() %></td>
                    <td><%= message.getSourceMessage() %></td>
                </tr>
<%
            }
%>
            </table>
    </div> <!-- /container -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="bootstrap/js/bootstrap.min.js"></script>
    <%@ include file="../include/piedDePage.html" %>
  </body>
</html>