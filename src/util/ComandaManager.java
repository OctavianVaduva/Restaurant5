package util;

import java.util.List;

//import javax.persistence.Query;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import entitati.Comanda;
import entitati.CommandItem;

public class ComandaManager {

	public ComandaManager() {
		super();
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
	
    protected void createComanda() {
        // code to save a book
        Comanda comanda = new Comanda();
//        comanda.setIdComanda(idComanda);;
        comanda.setNrMasa(2);
        comanda.setNumeOspatar("Vasilica Viorica");
        comanda.setDataCreare(new java.util.Date());
        comanda.setPretTotalComanda(125.25);
//        comanda.setIncasat(125.25);
//        comanda.setDataIncasare(new java.util.Date());
        comanda.setContinutComanda("120:3;119:2");
        
        Session session = sessionFactory.openSession();
        session.beginTransaction();
     
        String ID = "" + session.save(comanda);
        System.out.println("ID comanda = " + ID);
     
        session.getTransaction().commit();
        session.close();
    }	
	
    public Comanda readComanda(Integer idComanda) {
        // code to get a book
        Session session = sessionFactory.openSession();
        
//        Integer idProdus = 20;
        Comanda comanda = session.get(Comanda.class, idComanda);
     
        System.out.println("ID Comanda: " + comanda.getIdComanda());
        System.out.println("	Masa nr: " + comanda.getNrMasa());
        System.out.println("	Ospatar: " + comanda.getNumeOspatar());
        System.out.println("	Continut comanda: " + comanda.getContinutComanda());
     
        session.close();
        return comanda;
    }
    
    public List readComendsForOspatar(String numeOspatar) {
        // code to get a book
        Session session = sessionFactory.openSession();
        List comenzi = null;
        
        try {
        	Query query = session.createQuery("from Comanda where numeOspatar='"+numeOspatar +"'");
        	comenzi =  query.list();
        	System.out.println("Numar comenzi pentru ospatar: " + numeOspatar + " = " + comenzi.size());
        } finally {
        	session.close();
        }
        return comenzi;
    }
    
    public void update(Comanda com) {
    	Session session = sessionFactory.openSession();
    	session.beginTransaction();
    	session.update(com);
    	
    	session.getTransaction().commit();
    	session.close();
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ComandaManager manager = new ComandaManager();
        manager.setup();
        
//        manager.createComanda();
        manager.readComendsForOspatar("Valentina");
//        manager.readComanda(1);;
//        manager.deleteComanda(135);
//        manager.updateComanda();
     
        manager.exit();
		
	}

}
