
package restaurant.application.database;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnector {
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private static final String CONN = "jdbc:mysql://localhost/restaurant";
    
    public static Connection getConnection() throws SQLException {
        return (Connection) DriverManager.getConnection(CONN, 
                    USERNAME, PASSWORD);
    }
}
