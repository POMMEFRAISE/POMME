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
<title><fmt:message key="consultation.score" /></title>
<%@include file="include/header.jsp"%>
<%@include file="include/menu.jsp"%>
<%@include file="include/footer.jsp"%>
</head>
<body background="img/fond.jpg">
	<center>
		<table cellpadding="0" cellspacing="0" border="0" class=""
			id="acceuil">
			<caption>
				<fmt:message key="consultation.score.consulter" />
			</caption>
			<thead>
				<tr>
					<th rowspan="1" colspan="1"><fmt:message
							key="consultation.score.jouer" /></th>
					<th rowspan="1" colspan="1"><fmt:message
							key="consultation.score.gain" /></th>
					<th rowspan="1" colspan="1"><fmt:message
							key="consultation.score.perte" /></th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>10</td>
					<td>5</td>
					<td>5</td>
				</tr>
				<tr>
					<td>20</td>
					<td>15</td>
					<td>5</td>
				</tr>
				<tr>
					<td>30</td>
					<td>10</td>
					<td>20</td>
					</tr>
			</tbody>
		</table>
	</center>
<div class="des">
<img src="img/des.png">
</div>
</body>
</html>