<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="entitati.Produs" %>
<%@ page import="servlets.admin.LinieTabelComandaOspatar"   %>
<%@ page import="servlets.admin.ComandaUI" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ include file = "../header.jsp" %>

	<% 
	List listaComenziUI = (List) request.getSession().getAttribute("listaComenziUI");
	%>

	<form action="SchimbaOspatar" method="post">
		  Nume ospatar: <input type="text" name="ospatar"placeholder="Prenume Ospatar" >
		  <br><br>
		  <input type="submit" value="Submit">

	<%
	if(listaComenziUI != null) {%>	
<p>	Ospatar: <b><%=request.getSession().getAttribute("numeOspatar")%> </b> <br/>
TOTAL comenzi deschise:  <b><%= listaComenziUI.size()%> </b></p>


<input type="hidden" id="commandItemId" name="commandItemId">
<input type="hidden" id="action" name="action">
<input type="hidden" id="idComanda" name="idComanda">

<table align="center" border=1>

	<%
	for(int i =0; i < listaComenziUI.size(); i++) { 
		ComandaUI ui = (ComandaUI)listaComenziUI.get(i);
		List liniiTabelComandaOspatar = ui.getLiniiTabelComandaOspatar();	
	%>
	<tr style="background:#ccc; font-weight:bold; <% if(ui.getDataLivrare() != null) {%> color:red; <%}  %>">
		<td align="center"  rowspan="<%=liniiTabelComandaOspatar.size() +1%>">Masa <br/><%=ui.getNrMasa() %></td>
		<td colspan="2">Data creare: <br/><%=ui.getDataCreare() %></td>
		<td  colspan="2">Data livrare: <br/><%=ui.getDataLivrare() %></td>
		<td align="right" colspan="2">
		TOTAL: <%=ui.getPretTotal() %> RON 
		<% if(ui.getDataLivrare() != null) {%>
				<button onclick='this.disabled=true; document.getElementById("action").value="plata"; 
				document.getElementById("idComanda").value="<%=ui.getIdComanda()%>"; form.submit();'>Platit</button>
				<%} %><br/>
		</td>
		

	</tr>
		<%
		for(int j =0; j < liniiTabelComandaOspatar.size(); j++) { 
			LinieTabelComandaOspatar ltco = (LinieTabelComandaOspatar)liniiTabelComandaOspatar.get(j);
		%>
			<tr <% if(ltco.getDataLivrare() == null) {%> style="color:red;" <%} %>>
				<!-- <td></td> -->
				<td><%=ltco.getIdProdus() %></td>
				<td><%=ltco.getNumeProdus() %></td>
				<td><%=ltco.getPretUnitar()%></td>
				<td><%=ltco.getCantitate() %></td>
				<td><%=ltco.getPretTotal()%></td>
				<% if(ltco.getDataLivrare() != null) {%>
				<td><%= ltco.getDataLivrare() %></td>
				<%} else { %>
				<td align="right"><button onclick='this.disabled=true; document.getElementById("action").value="livrare"; document.getElementById("commandItemId").value="<%=ltco.getIdCommandItem()%>"; form.submit();'>Livrat</button></td>
				<%} %>
			</tr>
		<%}%>
	<%}%>
</table>
</form>
<%}%>

</body>
</html>