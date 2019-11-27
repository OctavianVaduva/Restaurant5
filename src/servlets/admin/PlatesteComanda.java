package servlets.admin;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entitati.Comanda;
import util.ComandaManager;

/**
 * Servlet implementation class PlatesteComanda
 */
@WebServlet("/PlatesteComanda")
public class PlatesteComanda extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlatesteComanda() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String idComanda = request.getParameter("idComanda");
		System.out.println("id Comanda = " + idComanda);
		
		ComandaManager cm = new ComandaManager();
		cm.setup();
		Comanda com = cm.readComanda(new Integer(idComanda));
		com.setDataIncasare(new Date());
		com.setIncasat(com.getPretTotalComanda());
		cm.update(com);
		cm.exit();
		
		RequestDispatcher rd = request.getRequestDispatcher("/AfiseazaComenziOspatar");
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
