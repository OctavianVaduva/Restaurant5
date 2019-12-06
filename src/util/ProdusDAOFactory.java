package util;

public class ProdusDAOFactory {
	static ProdusDAOFactory produsDAOFactory = null;

	private ProdusDAOFactory() {
		// TODO Auto-generated constructor stub
		super();
		
	}
	
	public static ProdusDAOFactory getInstance() {
		if(produsDAOFactory == null) {
			produsDAOFactory = new ProdusDAOFactory();
		}
		return produsDAOFactory;
	}
	
	public ProdusDAO getProdusDAO() {
		
//		setam manual "String implementation" aceasta optiune sau urmatoarea, pentru a selecta tehnologia de accesare si de prelucrare a datelor din baza de date.
		String implementation = "JDBC"; 
//		String implementation = "Hibernate";
		ProdusDAO result = null;
		if(implementation.equals("JDBC")) {
			result = new ProdusJDBCDAO();
		}
		if(implementation.equals("Hibernate")) {
			result = new ProdusManager();
		}
		return result;
		
	}
	public static void main(String[] args) {
		
	}
}
