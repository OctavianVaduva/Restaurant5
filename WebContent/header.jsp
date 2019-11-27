<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>header</title>
</head>
<body>
<nav>
	<button class="baraOptiuni" onclick="location.href='/restaurant5/StartAplicatie'">Home</button>
    <button class="baraOptiuni" onclick="location.href='/restaurant5/admin/adaugaProdusNou.jsp'">Administrator</button>
    <button class="baraOptiuni" onclick="location.href='/restaurant5/admin/comenziospatar.jsp'">Ospatar</button>
    <button class="baraOptiuni" onclick="location.href='/restaurant5/index.html'">Client</button>
    <button class="baraOptiuni" onclick="location.href='/restaurant5/AfiseazaMeniu'">Meniu</button>
    <button class="baraOptiuni" onclick="location.href='/restaurant5/AfisareCos'">Continut cos</button>
</nav>

<%String idComanda = (String)request.getSession().getAttribute("idComanda"); 
%>
<% if(idComanda != null) { %>
    <button class="baraOptiuni" onclick="location.href='/restaurant5/AfisareCos'">Vizualizare Comanda</button>
<%}
%>

</body>
</html>