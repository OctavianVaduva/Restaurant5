<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="servlets.LinieTabelCos" %>
<%@ page import="util.ProdusManager" %>
<%@ page import="entitati.Produs" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<nav>
	<button class="baraOptiuni" onclick="location.href='/restaurant5/index.html'">Home</button>
    <button class="baraOptiuni" onclick="location.href='/restaurant5/adaugaProdusNou.jsp'">Administrator</button>
    <button class="baraOptiuni" onclick="location.href='/restaurant5/admin/comenziospatar.jsp'">Ospatar</button>
    <button class="baraOptiuni" onclick="location.href='/restaurant5/AfiseazaMeniu'">Client</button>
    <button class="baraOptiuni" onclick="location.href='/restaurant5/AfiseazaMeniu'">Meniu</button>
    <button class="baraOptiuni" onclick="location.href='/restaurant5/AfisareCos'">Comanda curenta</button>
</nav>
   
 	<% List liniiTabelCos = (List)request.getSession().getAttribute("liniiTabelCos");%>


<form action="UpdateCos" >
	<input type="hidden" id="productId" name="productId"/>
	<input type="hidden" id="action" name="action"/>

	
    <table align = "center">
        <tr>
            <th>ID<br/>Produs</th>
            <th>Nume Produs</th>
            <th>Descriere Produs</th>
            <th>Pret Unitar</th>
            <th>Cantitate</th>
            <th>Pret Total</th>
            <th>Info stoc</th>
            <th>Renunta</th>
        </tr>
  <% 
  ProdusManager pm = new ProdusManager();
  pm.setup();
  boolean stockProblem = false;
  
  for (int i = 0; i < liniiTabelCos.size(); i++){ 
      LinieTabelCos ltc = (LinieTabelCos)liniiTabelCos.get(i);
      Produs produs =pm.getProdusById(ltc.getIdProdus());
  %>
  <tr>
    <td align="center"><%=ltc.getIdProdus()%></td>
    <td><%=ltc.getNumeProdus()%></td>
    <td><%=ltc.getDescriereProdus()%></td>
    <td align="right"><%=(Double)ltc.getPretUnitar()%></td>
    <td align="center"><%=ltc.getCantitate()%></td>
    <td align="right"><%=(Double)ltc.getPretTotal()%></td>
    <td><%if(ltc.getCantitate() > produs.getStoc()) { %>
    <div style="color:red"> Disponibil: <%=produs.getStoc() %></div>
    <%stockProblem = true; %>
    <%} else {%>
    <div style="color:green"> OK </div>
     <%}%></td>
    <td align="center"><button onclick = 'document.getElementById("productId").value="<%=ltc.getIdProdus()%>";
    document.getElementById("action").value="remove";
    form.submit();'>Renunta</button></td>
  </tr>
 <%}%>
  <tr>
 	<td colspan="5" align="center"><b>T O T A L<br/>C O M A N D A:</b></td>
 	<td align="right"><b><%=request.getSession().getAttribute("grandTotal")%></b></td>
 	<td><b>RON</b></td>
 </b></tr>
 
</table>
</form>
<br/>
<hr>
<%if(!stockProblem){%><p align="right"><button><a href="OperatieComanda"> Trimite comanda</a> </button></p><%}%>


</body>
</html>