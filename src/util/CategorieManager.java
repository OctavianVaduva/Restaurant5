package util;

import java.util.List;

import org.hibernate.Query;
/*  
 * sursa de inspiratie: 
 * https://www.codejava.net/frameworks/hibernate/
 *      hibernate-hello-world-tutorial-for-beginners-with-eclipse-and-mysql
 */
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import entitati.Categorie;
import entitati.Produs;

public class CategorieManager {
	
    public CategorieManager() {
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
 
    protected void createManager() {
        // code to save a book
        Categorie categorie = new Categorie();
        categorie.setIdCategorieProdus(1);
 //       categorie.setNumeCategorieProdus();
//        produs.setDescriereProdus("DESCRIERE Produs nou introdus");
//        produs.setPretUnitar(25.00);
//        produs.setStoc(200);
//        produs.setNivelAlerta(20);
        
        Session session = sessionFactory.openSession();
        session.beginTransaction();
     
    //    session.save(produs);
     
        session.getTransaction().commit();
        session.close();
    }
    
   
    
    protected void readCategorie2(Integer idCategorieProdus) {
        // code to get a book
        Session session = sessionFactory.openSession();
        
        Categorie categorie = session.get(Categorie.class, idCategorieProdus);
     
        System.out.println("Id categorie: " + categorie.getIdCategorieProdus());
        System.out.println("Nume categorie : " + categorie.getNumeCategorieProdus());
     
        session.close();
    }
    
    public Categorie readCategorie(Integer idCategorieProdus) {
        // code to get a book
        Session session = sessionFactory.openSession();
        
        Categorie categorie = session.get(Categorie.class, idCategorieProdus);
     
        System.out.println("Id categorie: " + categorie.getIdCategorieProdus());
        System.out.println("Nume categorie : " + categorie.getNumeCategorieProdus());
     
        session.close();
        return categorie;
    }
    
    public List readAllCategories() {
        
    	List categorii = null;
    	
        Session session = sessionFactory.openSession();
        
        try {
        	Query query = session.createQuery("from Categorie");
        	categorii = query.list();
            System.out.println("Dimensiune categorie: " + categorii.size());
            System.out.println("Nume categorie 3 : " + ((Categorie) categorii.get(2)).getNumeCategorieProdus());
        }finally {
        	session.close();
        }
   
        return categorii;
    }
    

 
    public static void main(String[] args) {
        // code to run the program
        CategorieManager manager = new CategorieManager();
        manager.setup();
        
        manager.readAllCategories();
     
        manager.exit();
    }
    
}
