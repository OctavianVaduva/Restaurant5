package util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import entitati.Comanda;

public class ComandaManager {

	public ComandaManager() {
		super();
		// TODO Auto-generated constructor stub
	}
	
protected SessionFactory sessionFactory;
	
	protected void setup() {
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
	 
    protected void exit() {
        // code to close Hibernate Session factory
    	sessionFactory.close();
    }	
	
    protected void createComanda() {
        // code to save a book
        Comanda comanda = new Comanda();
//        comanda.setIdComanda(idComanda);;
        comanda.setNrMasa(2);
        comanda.setNumeOspatar("Vasilica Viorica");
        comanda.setDataComanda(new java.util.Date());
        comanda.setPretTotalComanda(125.25);
        comanda.setIncasat(125.25);
        comanda.setDataIncasare(new java.util.Date());
        comanda.setContinutComanda("125;3;126;2");
        
        Session session = sessionFactory.openSession();
        session.beginTransaction();
     
        session.save(comanda);
     
        session.getTransaction().commit();
        session.close();
    }	
	
    protected void readComanda(Integer idComanda) {
        // code to get a book
        Session session = sessionFactory.openSession();
        
//        Integer idProdus = 20;
        Comanda comanda = session.get(Comanda.class, idComanda);
     
        
        System.out.println("ID Comanda: " + comanda.getIdComanda());
        System.out.println("	Masa nr: " + comanda.getNrMasa());
        System.out.println("	Ospatar: " + comanda.getNumeOspatar());
        System.out.println("	Continut comanda: " + comanda.getContinutComanda());
     
        session.close();
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ComandaManager manager = new ComandaManager();
        manager.setup();
        
//        manager.createComanda();
        manager.readComanda(1);
//        manager.deleteComanda(135);
//        manager.updateComanda();
     
        manager.exit();
		
	}

}
