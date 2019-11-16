package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StartAplicatie
 */
@WebServlet("/StartAplicatie")
public class StartAplicatie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StartAplicatie() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String masa = (String) request.getSession().getAttribute("masa"); //obtinem numele atributului 
		String numeOspatar = (String) request.getSession().getAttribute("numeOspatar");
		if((masa == null) || (numeOspatar == null) || ("".equals(masa)) || ("").equals(numeOspatar)) {
			
			RequestDispatcher rd = request.getRequestDispatcher("/configurare.jsp");
			 rd.forward(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("/index.html");
			 rd.forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
