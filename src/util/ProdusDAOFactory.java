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
		
//		String implementation = "JDBC"; // setam manual aceasta optiune sau urmatoarea, pentru a selecta tehnologia de accesare a bazei de date si de prelucrare a datelor.
		String implementation = "Hibernate";
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
