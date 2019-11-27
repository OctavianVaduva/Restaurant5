package util;

import com.mysql.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * Connect to Database
 */
public class JDBCConnectionFactory {
	// cream legatura la baza de date
    public static final String URL = "jdbc:mysql://localhost:3306/Restaurant3";
    public static final String USER = "root";
    public static final String PASS = "Veveveve11!!";
    /**
     * Get a connection to database
     * @return Connection object
     */
    public static Connection getConnection()
    {
      try {
          DriverManager.registerDriver(new Driver());
          return DriverManager.getConnection(URL, USER, PASS);
      } catch (SQLException ex) {
          throw new RuntimeException("Error connecting to the database", ex);
      }
    }
    /**
     * Test Connection
     */
    public static void main(String[] args) {
        Connection connection = JDBCConnectionFactory.getConnection();
        if (connection!=null) {
        	System.out.println("Am luat conexiune!");
        }
        else {
        	System.out.println("N-am conexiune!");
        }
    }
}
