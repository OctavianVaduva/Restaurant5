package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entitati.Produs;
import util.HibernateUtil;

@WebServlet("/IntroducereProdus")
public class IntroducereProdus extends HttpServlet{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public IntroducereProdus() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException,IOException{

        Integer idCategorie = Integer.parseInt(request.getParameter("idCategorie")); 
        String numeProdus = request.getParameter("numeProdus"); 
        String descriereProdus = request.getParameter("descriereProdus"); 
        Double pretUnitar = Double.valueOf(request.getParameter("pretUnitar")); 
        Integer stoc = Integer.parseInt(request.getParameter("nivelExistent")); 
        Integer nivelAlerta = Integer.parseInt(request.getParameter("nivelAlerta")); 

		SessionFactory factory = HibernateUtil.getSessionfactory();
		Session session = factory.openSession();
		    Produs produs = new Produs();
		        produs.setIdCategorie(idCategorie);
		        produs.setNumeProdus(numeProdus);
		        produs.setDescriereProdus(descriereProdus);
		        produs.setPretUnitar(pretUnitar);
		        produs.setStoc(stoc);
		        produs.setNivelAlerta(nivelAlerta);
		        
		        session.beginTransaction();
		     
		        session.save(produs);
		     
		        session.getTransaction().commit();
		        session.close();
		        
		        response.sendRedirect("/restaurant/adaugaProdusNou.jsp");
        
      // Creating a RequestDispatcher object to dispatch the request to another resourcee
      // Creem un obiect rd de tip RequestDispatcher
//      RequestDispatcher rd = request.getRequestDispatcher("/restaurant/adaugaProdusNou.jsp"); // public interface RequestDispatcher
//
//      rd.forward(request, response); // transmitem raspunsul care va genera deschiderea paginii home.jsp

    }

}
