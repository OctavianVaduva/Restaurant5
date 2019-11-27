package servlets.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SchimbaOspatar
 */
@WebServlet("/admin/SchimbaOspatar")
public class SchimbaOspatar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SchimbaOspatar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

		String action = request.getParameter("action");
		if((action != null) && action.equals("livrare")) {
			RequestDispatcher rd = request.getRequestDispatcher("/LivreazaCommandItem");
			 rd.forward(request, response);
			 return;
		} 
		if((action != null) && action.equals("plata")) {
			RequestDispatcher rd = request.getRequestDispatcher("/PlatesteComanda");
			 rd.forward(request, response);
			 return;
		} 
		String ospatar = request.getParameter("ospatar");
		request.getSession().setAttribute("numeOspatar", ospatar);

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
