package servlets.admin;

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
import entitati.CommandItem;
import entitati.Produs;
import util.CategorieManager;
import util.ComandaManager;
import util.CommandItemManager;
import util.ProdusDAO;
import util.ProdusManager;

/**
 * Servlet implementation class AfiseazaComenziOspatar
 */
@WebServlet("/AfiseazaComenziOspatar")
public class AfiseazaComenziOspatar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AfiseazaComenziOspatar() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

		// TODO pun mana pe nume ospatar
		String ospatar = (String) request.getSession().getAttribute("numeOspatar");
		if(ospatar != null) {
		// TODO iau comenzile deschise pentru ospatar
		ComandaManager comandaManager = new ComandaManager();
		comandaManager.setup();
		List comenzi = comandaManager.readOpenCommandsForOspatar(ospatar);
		List listaComenziUI = new ArrayList(); // listaComenziUI = reprezentarea comenzilor
		List produse = (List) request.getServletContext().getAttribute("produse");
		List categorii = (List) request.getServletContext().getAttribute("categorii");

		if (produse == null) {
			ProdusDAO manager = new ProdusManager();
			manager.setup();
			produse = manager.readAllProducts();
			manager.exit();
			request.getServletContext().setAttribute("produse", produse); // afisarea listei de produse e aplicatie
			
			CategorieManager managerCategorie = new CategorieManager();
			managerCategorie.setup();
			categorii = managerCategorie.readAllCategories();
			managerCategorie.exit();
			request.getServletContext().setAttribute("categorii", categorii); // afisarea listei de produse e aplicatie
		}

		// TODO pregatesc comenzi si produse per comanda sac mare/sac mic
		Iterator it = comenzi.iterator();
		while (it.hasNext()) {
			Comanda comanda = (Comanda) it.next();
			ComandaUI cui = new ComandaUI(); // cui = blocul comanda de pe pagina
			cui.setNrMasa(comanda.getNrMasa());
			cui.setIdComanda(comanda.getIdComanda());
			cui.setPretTotal(comanda.getPretTotalComanda());
			cui.setNumeOspatar(comanda.getNumeOspatar());
			cui.setDataCreare(comanda.getDataCreare());
			cui.setDataLivrare(comanda.getDataLivrare());
			List liniiTabelComandaOspatar = new ArrayList();

			CommandItemManager cim = new CommandItemManager();
			cim.setup();
			List commandItems = cim.readComandItemForCommand(comanda.getIdComanda());
			cim.exit();

			Iterator itCommandItems = commandItems.iterator();
			while (itCommandItems.hasNext()) {
				CommandItem ci = (CommandItem) itCommandItems.next();
				LinieTabelComandaOspatar ltc = new LinieTabelComandaOspatar(); // linie produs comanda
				ltc.setCantitate(new Integer(ci.getNrProduse()));
				Iterator itProduse = produse.iterator();
//	                // TODO Impachetat liniile intr-o colectie;
				while (itProduse.hasNext()) {
					Produs produs = (Produs) itProduse.next();
					if (produs.getIdProdus().intValue() == ci.getIdProdus()) {
						ltc.setIdProdus(ci.getIdProdus());
						ltc.setNumeProdus(produs.getNumeProdus());
						ltc.setDescriereProdus(produs.getDescriereProdus());
						ltc.setPretUnitar(produs.getPretUnitar());
						ltc.setPretTotal(ci.getPretTotal());
						ltc.setIdCommandItem(ci.getIdItem());
						ltc.setDataLivrare(ci.getDataLivrare());
						liniiTabelComandaOspatar.add(ltc);
						break;
					}
				}
			}
			cui.setLiniiTabelComandaOspatar(liniiTabelComandaOspatar);
			listaComenziUI.add(cui);

//			String continut = comanda.getContinutComanda(); // varianta de citire din stringuri
//			String[] tokens = continut.split(";");
//			
//            for(int i=0; i< tokens.length; i++) {
//                String[] el = tokens[i].split(":");
//                String id = el[0];
//                String nrBucati = el[1];
//                
//                LinieTabelComandaOspatar ltc = new LinieTabelComandaOspatar(); // linie produs comanda
//                ltc.setCantitate(new Integer(nrBucati));
//                Iterator itProduse = produse.iterator();
//                
//                // TODO Impachetat liniile intr-o colectie;
//                while(itProduse.hasNext()){
//                    Produs produs = (Produs)itProduse.next();
//                    
//                    if (produs.getIdProdus().intValue()==Integer.parseInt(id)) {
//                        ltc.setIdProdus(new Integer(Integer.parseInt(id)));
//                        ltc.setNumeProdus(produs.getNumeProdus());
//                        ltc.setDescriereProdus(produs.getDescriereProdus());
//                        ltc.setPretUnitar(produs.getPretUnitar());
//                        ltc.setPretTotal(ltc.getCantitate()*ltc.getPretUnitar());
////                        ltc.setDataLivrare(cOMMNADiTEM ..);
//                        liniiTabelComandaOspatar.add(ltc);
//                        break;
//                    }                
//                }
//                cui.setLiniiTabelComandaOspatar(liniiTabelComandaOspatar);
//                listaComenziUI.add(cui);
		}
		request.getSession().setAttribute("listaComenziUI", listaComenziUI);
	}

	// TODO Redirectez catre comenziospatar.jsp
	RequestDispatcher rd = request.getRequestDispatcher("/admin/comenziospatar.jsp");rd.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
