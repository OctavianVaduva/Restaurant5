package util;
/*	
 * sursa de inspiratie: 
 * https://www.codejava.net/frameworks/hibernate/
 * 		hibernate-hello-world-tutorial-for-beginners-with-eclipse-and-mysql
 */

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import entitati.Categorie;
import entitati.Produs;

public class ProdusManager {

	public ProdusManager() {
		// TODO Auto-generated constructor stub
	}

protected SessionFactory sessionFactory;
	
	public void setup() {
        // code to load Hibernate Session factory
    	final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
    	        .configure() // configures settings from hibernate.cfg.xml
    	        .build();
    	try {
    	    sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
    	} catch (Exception ex) {
    	    StandardServiceRegistryBuilder.destroy(registry);
    	}
    }
 
    public void exit() {
        // code to close Hibernate Session factory
    	sessionFactory.close();
    }
 
    protected void createProdus() {
        // code to save a book
        Produs produs = new Produs();
        produs.setIdCategorie(1);
        produs.setNumeProdus("Produs nou introdus");
        produs.setDescriereProdus("DESCRIERE Produs nou introdus");
        produs.setPretUnitar(25.00);
        produs.setStoc(200);
        produs.setNivelAlerta(20);
        
        Session session = sessionFactory.openSession();
        session.beginTransaction();
     
        session.save(produs);
     
        session.getTransaction().commit();
        session.close();
    }
    
    
 
    protected void readProdus(Integer idProdus) {
        // code to get a book
        Session session = sessionFactory.openSession();
        
//        Integer idProdus = 20;
        Produs produs = session.get(Produs.class, idProdus);
     
        
        System.out.println("Denumire: " + produs.getNumeProdus());
        System.out.println("Descriere: " + produs.getDescriereProdus());
        System.out.println("Pret: " + produs.getPretUnitar());
     
        session.close();
    }
    
    
    public List readAllProducts() {
    	List<Produs> produse = null;
    	
//		SessionFactory factory = HibernateUtil.getSessionfactory(); // suntem puternic dependeti de implementare
		Session session = sessionFactory.openSession(); // deschidem sesiune de accesare DB
		
		try {
			Query query = session.createQuery("from Produs"); // se citeste din entitatea Produs
				// vezi https://www.tutorialspoint.com/hibernate/hibernate_query_language.htm
			produse = query.list();
//			System.out.println("Dimensiune = " + produse.size());
//			System.out.println("Nume produs 1 = " + ((Produs) produse.get(0)).getNumeProdus());
			
		} finally {
			session.close();
				}
		return produse;
    }
    
    protected void readCategorie(Integer idCategorieProdus) {
        // code to get a book
        Session session = sessionFactory.openSession();
        
        Categorie categorie = session.get(Categorie.class, idCategorieProdus);
     
        System.out.println("Id categorie: " + categorie.getIdCategorieProdus());
        System.out.println("Nume categorie : " + categorie.getNumeCategorieProdus());
     
        session.close();
    }
    
 
    protected void updateProdus() {
        // code to modify a book
    	Produs produs = new Produs();
        produs.setIdProdus(125);
        produs.setIdCategorie(1);
        produs.setNumeProdus("PRODUS DE Produs nou introdus");
        produs.setDescriereProdus("PRODUS DE DESCRIERE Produs nou introdus");
        produs.setPretUnitar(25.00);
        produs.setStoc(200);
        produs.setNivelAlerta(20);
     
        Session session = sessionFactory.openSession();
        session.beginTransaction();
     
        session.update(produs);
     
        session.getTransaction().commit();
        session.close();
    }
 
    protected void deleteProdus(Integer idProdus) {
        // code to remove a book
    	Produs produs = new Produs();
        produs.setIdProdus(idProdus);
     
        Session session = sessionFactory.openSession();
        session.beginTransaction();
     
        session.delete(produs);
     
        session.getTransaction().commit();
        session.close();
    }
 
    public static void main(String[] args) {
        // code to run the program
        ProdusManager manager = new ProdusManager();
        manager.setup();
        
//        manager.createProdus();
//        manager.readProdus(120);
//        manager.deleteProdus(135);
//        manager.updateProdus();
//        manager.readCategorie(2);
        manager.readAllProducts();
     
        manager.exit();
    }
	
}
