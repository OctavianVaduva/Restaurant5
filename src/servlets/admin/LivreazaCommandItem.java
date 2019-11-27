package servlets.admin;

import java.io.IOException;
import java.util.Date;
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
import util.ComandaManager;
import util.CommandItemManager;

/**
 * Servlet implementation class LivreazaCommandItem
 */
@WebServlet("/LivreazaCommandItem")
public class LivreazaCommandItem extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LivreazaCommandItem() {
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

		String commandItemId = request.getParameter("commandItemId");

		CommandItemManager cim = new CommandItemManager();
		cim.setup();
		CommandItem ci = cim.getComandItemById(new Integer(commandItemId));
		ci.setDataLivrare(new Date());
		cim.update(ci);

		// de gasit toti CommandItems ai comenzii respective
		List ciList = cim.readComandItemForCommand(ci.getIdComanda()); //
		cim.exit();
		Iterator it = ciList.iterator();
		boolean livrat = true;
		while (it.hasNext()) {
			CommandItem ciTemp = (CommandItem) it.next();
			if (ciTemp.getDataLivrare() == null) {
				livrat = false;
				break;
			}
		}
		// daca toti sunt livrati, de setat data livrare la comanda respectiva
		if (livrat) {
			ComandaManager cm = new ComandaManager();
			cm.setup();
			Comanda com = cm.readComanda(ci.getIdComanda());
			com.setDataLivrare(new Date());
			cm.update(com);
			cm.exit();
		}

		RequestDispatcher rd = request.getRequestDispatcher("/AfiseazaComenziOspatar");
		rd.forward(request, response);
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
