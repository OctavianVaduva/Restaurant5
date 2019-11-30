/**
 * 
 */
package util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entitati.Categorie;
import entitati.Produs;

/**
 * @author VV
 *
 */
public class ProdusJDBCDAO implements ProdusDAO {

	/**
	 * 
	 */
	public ProdusJDBCDAO() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setup() {
		// TODO Auto-generated method stub
	}

	@Override
	public void exit() {
		// TODO Auto-generated method stub
	}

	@Override
	public Produs getProdusById(Integer idProdus) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List readAllProducts() {
		Connection con = JDBCConnectionFactory.getConnection();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM produse");
			List produse = new ArrayList();
			while (rs.next())
			{
				Produs produs = extractProdusFromResultSet(rs);
				produse.add(produs);
			}
			System.out.println("Size=" + produse.size());
			return produse;
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	private static Produs extractProdusFromResultSet(ResultSet rs) throws SQLException {
		Produs produs = new Produs();
		produs.setIdProdus(rs.getInt(1));
		
//		System.out.println("idCategorie = " + rs.getInt(2));
		//TODO de gasit categorie din baza de date cu ID-ul rs.getInt(2)
		produs.setCategorie(getCategorieByID(rs.getInt(2)));
		
		produs.setNumeProdus(rs.getString(3));
		produs.setDescriereProdus(rs.getString(4));
		produs.setPretUnitar(rs.getDouble(5));
		produs.setStoc(rs.getInt(6));
		produs.setNivelAlerta(rs.getInt(7));
		return produs;
	}
	
	private static Categorie getCategorieByID(int  id) {
		Connection con = JDBCConnectionFactory.getConnection();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM categorie_produs WHERE id_categorie_produs=" + id);
			if(rs.next()) {
				Categorie categorie = new Categorie();
				categorie.setIdCategorieProdus(rs.getInt(1));
				System.out.println("Id categorie = " + categorie.getIdCategorieProdus());
				categorie.setNumeCategorieProdus(rs.getString(2));
				return categorie;
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
			return null;
		
	}

	@Override
	public void updateStoc(Produs p) {
		// TODO Auto-generated method stub

	}
    public static void main(String[] args) {
        // code to run the program
        ProdusDAO manager = new ProdusJDBCDAO();
        manager.setup();
        
//        manager.createProdus();
//        manager.readProdus(120);
//        manager.deleteProdus(135);
//        manager.updateProdus();
//        manager.readCategorie(2);
        System.out.println("Produse size="+manager.readAllProducts().size());
     
        manager.exit();
    }
}
