package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.SessionFactory;

import entitati.Produs;
import util.ProdusManager;


/**
 * Servlet implementation class AfiseazaMeniu
 */
@WebServlet("/AfiseazaMeniu")
public class AfiseazaMeniu extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected SessionFactory sessionFactory;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AfiseazaMeniu() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

			List<Produs> produse = null;				
			
			ProdusManager manager = new ProdusManager();
	        manager.setup();
	        
	        produse = manager.readAllProducts();
	     
	        manager.exit();
	        request.getSession().setAttribute("produse", produse); // trebuie decis daca le salvam pe sesiune (pastrate mai mult timp) 
//	        			sau temporar, cu accesarea bazei de date la fiecare nevoie de afisare
//	        			Am optat pentru pastrare pe sesiune .getSession
			
		RequestDispatcher rd = request.getRequestDispatcher("/meniu.jsp");
		 rd.forward(request, response);
		
	}

//	private ListaProduseInterface listaProduseService = new ListaProduseDAO();
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		// se apeleaza intern doGet(), pentru a nu fi dependent de metoda aleasa pentru request 
	}

}
