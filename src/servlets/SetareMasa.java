package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SetareMasa
 */
@WebServlet("/setaremasa")
public class SetareMasa extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SetareMasa() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String masa = request.getParameter("masa"); // se obtin din configurare.jsp 
		String numeOspatar = request.getParameter("numeOspatar");
		
//		System.out.println("Masa = " + masa);// pentru verificare
//		System.out.println("Ospatar = " + numeOspatar); 
		
		request.getSession().setAttribute("masa", masa);
		request.getSession().setAttribute("numeOspatar", numeOspatar);
		
		RequestDispatcher rd = request.getRequestDispatcher("/index.html");
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
