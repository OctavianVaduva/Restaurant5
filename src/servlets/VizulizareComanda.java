package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entitati.Comanda;
import entitati.Produs;
import util.ComandaManager;

/**
 * Servlet implementation class VizulizareComanda
 */
@WebServlet("/VizulizareComanda")
public class VizulizareComanda extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VizulizareComanda() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		

//		 * TODO luat idComanda de pe sesiune
		 String idComanda = "" + request.getSession().getAttribute("idComanda");
		 
//		 * TODO Citit obiect Comanda din DB pe baza idComanda
		 ComandaManager manager = new ComandaManager();
		 manager.setup();
		 Comanda comanda = manager.readComanda(new Integer(idComanda));
		 manager.exit();
		 
//		 * TODO obtinut produsele comenzii (CommandItems) si creat din ele linii tabel comanda
		 String continut = comanda.getContinutComanda();
		 String[] tokens = continut.split(";");
		 List produse = (List) request.getSession().getAttribute("produse");
		 List liniiTabelComanda= new ArrayList();
		 for(int i = 0; i < tokens.length; i++) {
			 String[] el = tokens[i].split(":"); // un tokens este un produs
			 String id = el[0];
			 String nrBucati = el[1];
			 LinieTabelComanda ltc = new LinieTabelComanda();
			 ltc.setCantitate(new Integer(nrBucati));
//			 ltc.setIdProdus(new Integer(id));
			 
//			 * TODO impachetat liniile intr-o colectie 
			 Iterator itProduse = produse.iterator();
	            while(itProduse.hasNext()){
	                Produs produs = (Produs)itProduse.next();
	                if (produs.getIdProdus().intValue()==Integer.parseInt(id)) {
//	                    LinieTabelCos ltc = new LinieTabelCos();
	                    ltc.setIdProdus(new Integer(Integer.parseInt(id)));
//	                    ltc.setCantitate(val);
	                    ltc.setNumeProdus(produs.getNumeProdus());
	                    ltc.setDescriereProdus(produs.getDescriereProdus());
	                    ltc.setPretUnitar(produs.getPretUnitar());
	                    ltc.setPretTotal(ltc.getCantitate()*ltc.getPretUnitar());
	                    liniiTabelComanda.add(ltc);

	                    break;
						}
					}

//	            TODO de refacut logica de actualizarea bazei de date
		 }
		 
         Double totalComanda = comanda.getPretTotalComanda(); // TODO de actualizat total comandacand implementam edit pentru comanda
//		 * TODO redirectat catre JDP de afisare comanda 
	        request.getSession().setAttribute("liniiTabelComanda",liniiTabelComanda);
	        request.getSession().setAttribute("totalComanda",totalComanda);
		
			RequestDispatcher rd = request.getRequestDispatcher("/vizualizarecomanda.jsp");
			 rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
