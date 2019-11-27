<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="servlets.LinieTabelComanda" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ include file = "header.jsp" %>
   
 	<% List liniiTabelComanda = (List)request.getSession().getAttribute("liniiTabelComanda");%>

    <table align = "center">
        <tr>
            <th>ID<br/>Produs</th>
            <th>Nume Produs</th>
            <th>Descriere Produs</th>
            <th>Pret Unitar</th>
            <th>Cantitate</th>
            <th>Pret Total</th>
            <th>Renunta</th>
        </tr>
  <% 
  for (int i = 0; i < liniiTabelComanda.size(); i++){ 
	  LinieTabelComanda ltc = (LinieTabelComanda)liniiTabelComanda.get(i);
  %>
  <tr>
    <td align="center"><%=ltc.getIdProdus()%></td>
    <td><%=ltc.getNumeProdus()%></td>
    <td><%=ltc.getDescriereProdus()%></td>
    <td align="right"><%=(Double)ltc.getPretUnitar()%></td>
    <td align="center"><%=ltc.getCantitate()%></td>
    <td align="right"><%=(Double)ltc.getPretTotal()%></td>
    <td align="center"></td>
  </tr>
 <%}%>
  <tr>
 	<td colspan="5" align="center"><b>T O T A L<br/>C O M A N D A:</b></td>
 	<td align="right"><b><%=request.getSession().getAttribute("grandTotal")%></b></td>
 	<td><b>RON</b></td>
 </b></tr>
 
</table>


</body>
</html>