<%@ page isErrorPage="true"%>
<html><body>
exception lev&eacute;e <b> <%= exception %> </b>
<hr>
<h3>Trace de la pile</h3>
<pre>
<%
java.io.PrintWriter myWriter = new java.io.PrintWriter(out);
exception.printStackTrace(myWriter);
%>
</pre>
</body></html>