<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="controller.Jouer"%>
<%@page import="model.De"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	De unDe = new De();
	unDe.setValeur(1);
	int de=unDe.getValeur();
	switch(de){
	case 1:
		%><img src="img/de_1.png">
		<% ;
	break;
	default: ;
	}
	
	%>
	
</body>
</html>