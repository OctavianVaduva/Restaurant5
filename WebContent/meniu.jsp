<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="entitati.Produs" %>
<%@ page import="entitati.Categorie" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>  
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Meniu</title>
	<%
	String contextPath = request.getContextPath(); // memoram in contextPath valoarea URL
	%>
	<script src="https://code.jquery.com/jquery-1.11.3.js"></script>
	<script src="https://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
	<script src="https://code.jquery.com/jquery-1.9.1.js"></script>
	
	<script>
	function myFunction(arg) {
		id = "cant" + arg;
		alert("S-a apasat butonul " + arg + " iar cantitatea este " + document.getElementById(id).value);
		document.getElementById("productId").value = arg;
		<%-- opener.location.href='<%=contextPath%>/UpdateCos?Id=' + arg + '&quantity=' + document.getElementById("" +id).value'} --%>
	</script>
	
	<style>
	
	/* sursa< https://www.geeksforgeeks.org/how-to-create-table-with-100-width-with-vertical-scroll-inside-table-body-in-html/  */
	table.meniu { 
	    width: 100%; 
	    border-spacing: 0; 
	    border: 1px solid #dddddd; 
	    } 
	          
	        /* To display the block as level element */ 
	   table.meniu tbody, table.meniu thead { 
	        display: block; 
	        }  
	          
	        thead tr th { 
	            height: 20px;  
	            line-height: 1px; 
	        } 
	          
	        table.meniu tbody { 
	            /* Set the height of table body */ 
	          	height: 350px; 
	            /* Set vertical scroll */ 
	            overflow-y: auto; 
	            /* Hide the horizontal scroll */ 
	            overflow-x: auto;  
	        } 
	          
	        tbody {  
	            border-top: 1px solid black; 
	        } 
	        tbody td, thead th { 
	            border-right: 1px solid #dddddd; 
	        } 
	
	tr:nth-child(odd) {
	  background-color: #88ff88;
	  font-family: Times;
	  font-size: 15px;
	  color="blue" 
	}
	</style>

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

<%@ include file = "header.jsp" %>


	<h1 align="center"><b><i>RESTAURANTUL VEDETELOR</i></b></h1>
	<h2 align="center"><b><i>Meniu</i></b></h2>
    Sunteti la masa: <b><%= request.getSession().getAttribute("masa") %></b> <br/> 	
    Ospatarul de serviciu pentru aceasta masa este: <b><i><u><%= request.getSession().getAttribute("numeOspatar") %></u></i></b>
    
	<% 
	/* List produse = (List)request.getSession().getAttribute("produse"); // incarcare de pe sesiune*/
	List produse = (List)request.getServletContext().getAttribute("produse"); // incarcare de pe apliatie nu pe sesiune
	%>
	
	<form action="UpdateCos" method="post">
		<input type="hidden" id="productId" name="productId"/>
	
	Cosul contine  <b><%= request.getSession().getAttribute("nrProduse") %></b> tipuri de produse totalizand: 
	<%= request.getSession().getAttribute("nrObiecteCos") %> produse

	
	<table class="meniu" border="1">
		<thead style="width:98.2%" >
			<tr> <!-- Scrierea capului de tabel -->
				<th style="width: 5%;" rowspan="2">Categ.</th>
				<th style="width: 65%;" style="color:red" align="left">Produs</th>
				<th style="width: 5%;">Pret</th>
				<th style="width: 10%;">Imagine</th> 
				<th style="width: 5%;">Cantitate</th>
				<th style="width: 10%;">Adauga</th>
			</tr>  
			<tr>
				<th align="left" colspan="5" style="color:blue" ><i>Descriere produs</i></th>
			</tr>
		</thead>
			
		<tbody>	
		<%
		for(int i = 0; i < produse.size(); ++i) {
			Produs produs = (Produs) produse.get(i);  // facem cast la Produs, pentr ca aducem obiecte din entitate
			Categorie categorie = produs.getCategorie();
		%>
		<tr align="center">
<%-- 					<td style="width: 5%;" rowspan="2"><%=produs.getIdCategorie()%></td> --%>
					<td style="width: 5%;" rowspan="2"><%=categorie.getNumeCategorieProdus()%></td>
					<td style="width: 65%;" style="color:red" align="left"><b><i><%=produs.getIdProdus()%></i> - <%=produs.getNumeProdus()%></b></td>
					<td style="width: 5%;"><%=produs.getPretUnitar()%></td>
					<td style="width: 10%;"><img border="1" src="imagini/meniu.jpg" width=90% height=8%></td>
					<td style="width: 5%;"><input type="number" name="cant<%=produs.getIdProdus()%>" id="cant<%=produs.getIdProdus()%>" min="1" max="<%=produs.getStoc()%>"></td>
 					<td style="width: 10%;"><% if(produs.getStoc() > produs.getNivelAlerta()) {%>
							<button onclick='this.disabled=true; document.getElementById("productId").value="<%=produs.getIdProdus()%>"; form.submit();'>Adauga</button>
							<%} else if(produs.getStoc() > 0) {%>
							 <font color="red"><b><i>Intreaba osparatul</i></b></font> <br/> <button onclick='document.getElementById("productId").value="<%=produs.getIdProdus()%>"; form.submit();'>Adauga</button>
							 <%} else { %> <font color="red">Produsul nu este disponbil!</font> <%}%>
					</td>
				</tr>
						<tr>
					<td colspan="5" style="color:blue"><i><%=produs.getDescriereProdus()%></i></td>
				</tr>		
				
				<%} %>

		</tbody>

	</table>
</form>
	<p></p>
	<p align="right"><input action="AdaugaComanda" type="submit" value="Adauga comanda"></p>
</body>
</html>
