package util;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import entitati.Comanda;
import entitati.CommandItem;

public class CommandItemManager {

	public CommandItemManager() {
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
	
    protected void createCommandItem() {
        CommandItem ci = new CommandItem();

        ci.setIdComanda(4);
        ci.setDataCreare(new java.util.Date());
        ci.setIdProdus(18);
        ci.setNrProduse(1);
        ci.setPretTotal(45d);
        ci.setDataLivrare(new java.util.Date());
        
        Session session = sessionFactory.openSession();
        session.beginTransaction();
     
        session.save(ci);
     
        session.getTransaction().commit();
        session.close();
    }	
    
    public Object createCommandItem(CommandItem ci) {
        
        Session session = sessionFactory.openSession();
        session.beginTransaction();
     
        Object id = session.save(ci); // returneaza id item din comenzi items
     
        session.getTransaction().commit();
        session.close();
        return id;
    }
    
    
    public void update(CommandItem ci) {
    	Session session = sessionFactory.openSession();
    	session.beginTransaction();
    	session.update(ci);
    	
    	session.getTransaction().commit();
    	session.close();
    }
    
    public List readComandItemForCommand(Integer idComanda) {
        // code to get a book
        Session session = sessionFactory.openSession();
        List commandItems = null;
        
        try {
        	Query query = session.createQuery("from CommandItem where idComanda=" + idComanda);
        	commandItems =  query.list();
        	System.out.println("Numar itemi pentru comanda cu ID = " + idComanda + " : " + commandItems.size());
        } finally {
        	session.close();
        }
        return commandItems;
    }
    
    public CommandItem getComandItemById(Integer idItem) {
        
        Session session = sessionFactory.openSession();
        CommandItem ci = session.get(CommandItem.class, idItem);
        return ci;
    }


    public static void main(String[] args) {
    	CommandItemManager cim = new CommandItemManager();
    	cim.setup();
        
    	cim.createCommandItem();
//    	cim.readComandItemForCommand(24);
    	
        cim.exit();
    }
}
