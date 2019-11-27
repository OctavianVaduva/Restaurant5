package servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entitati.Comanda;
import entitati.CommandItem;
import entitati.Produs;
import util.CommandItemManager;
import util.HibernateUtil;
import util.ProdusDAO;
import util.ProdusManager;

/**
 * Servlet implementation class PreiaComanda
 */
@WebServlet("/OperatieComanda")
public class OperatieComanda extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OperatieComanda() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: xxxxx").append(request.getContextPath());
		
		Map cos = (HashMap)request.getSession().getAttribute("cos");
		String masa = (String) request.getSession().getAttribute("masa");
		String ospatar = (String) request.getSession().getAttribute("numeOspatar");
		
		String continutComanda = "";
		Iterator it = cos.keySet().iterator(); // iterator peste multimea cheilor
		
		while(it.hasNext()){
            String currentKey = it.next().toString();
            String valoare = cos.get(currentKey).toString();
            continutComanda = continutComanda + ";" + currentKey + ":" + valoare;
		}
			continutComanda = continutComanda.substring(1); // scoatem primul sena care este ";"
			
		SessionFactory factory = HibernateUtil.getSessionfactory();
		Session session = factory.openSession();
		    Comanda comanda = new Comanda();
		    comanda.setNrMasa(new Integer(masa));
		    comanda.setNumeOspatar(ospatar);
		    comanda.setDataCreare(new java.util.Date());
		    comanda.setPretTotalComanda(new Double("" + request.getSession().getAttribute("grandTotal")));
		    
		    comanda.setContinutComanda(continutComanda);
		        
		    session.beginTransaction();
		     
		    String IdComanda = "" + session.save(comanda);
		     
		    session.getTransaction().commit();
		    session.close();
		    
		    Iterator it2 = cos.keySet().iterator();
		  //TODO Cream lineItems
            CommandItemManager cim = new CommandItemManager();
            cim.setup();

            while(it2.hasNext()) {
            	String currentKey = it2.next().toString();
            	
                List produse = (List) request.getServletContext().getAttribute("produse");
                Iterator itProduse = produse.iterator();
                Double pu = 0d;
                while(itProduse.hasNext()) {
                	Produs produs = (Produs)itProduse.next();
                	if(("" + produs.getIdProdus()).equals(currentKey)) {
                		pu = produs.getPretUnitar();
                		break;
                	}
                }
            	
            	String valoare = cos.get(currentKey).toString();
            	CommandItem ci = new CommandItem();
            	ci.setIdComanda(new Integer(IdComanda));
            	ci.setDataCreare(comanda.getDataCreare());
//            	ci.setDataLivrare(null);
            	ci.setIdProdus(new Integer(currentKey));
            	ci.setNrProduse(new Integer(valoare));
            	ci.setPretTotal(pu.doubleValue()*Integer.parseInt(valoare));
            	cim.createCommandItem(ci);
            	ProdusDAO pm = new ProdusManager();
            	pm.setup();
            	Produs produs = pm.getProdusById(ci.getIdProdus());
            	produs.setStoc(produs.getStoc() - Integer.parseInt(valoare)); //actualizare stoc
            	pm.updateStoc(produs);
            	pm.exit();
            }
            cim.exit();

		    cos.clear();
		    
		    request.getSession().setAttribute("cos", cos);
		    request.getSession().setAttribute("grandTotal", new Double("0"));
		    request.getSession().setAttribute("nrObiecteCos", new Integer("0"));
		    request.getSession().setAttribute("nrProduse", new Integer("0"));
		    
		    ProdusDAO pm = new ProdusManager();
		    pm.setup();
		    List produse = pm.readAllProducts();
		    pm.exit();
		    request.getServletContext().setAttribute("produse", produse);
		        
		    response.sendRedirect("/restaurant5/meniu.jsp");	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
