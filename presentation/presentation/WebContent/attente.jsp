<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
	var requete;
	function demandeRedirection(){
		var url = "navigation?nav=redirection";
		if (window.XMLHttpRequest) {
			requete = new XMLHttpRequest();
		} else if (window.ActiveXObject) {
			requete = new ActiveXObject("Microsoft.XMLHTTP");
		}
		requete.open("GET", url, true);
		requete.onreadystatechange = reponseRedirection;
		requete.send(null);
	};
	
	function reponseRedirection(){
		var message = "";
		if (requete.readyState == 4) {
			if (requete.status == 200) {
				// exploitation des données de la réponse
				var messageTag = requete.responseXML.getElementsByTagName("redirection")[0];
				message = messageTag.childNodes[0].nodeValue;
				window.location = message+".jsp";
			}
		}
	};
</script>
</head>
<body onload="demandeRedirection()">
	<h1>Page d'attente</h1>	
</body>
</html>