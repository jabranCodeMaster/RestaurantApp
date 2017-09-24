/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.application.database;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;



public class MySQL_Connector {
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private static final String CONN = "jdbc:mysql://localhost/restaurant";
    
    
    
    
    public void readDatabase() throws Exception {
        
        
        
        try (
                Connection connect = DBConnector.getConnection();
                Statement stmt = connect.createStatement(
                        ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                ResultSet rs = stmt.executeQuery("SELECT * FROM employee_info");
                )
        {
            rs.last();
            
            System.out.println("Connected"); 
            System.out.println(rs.getRow());
        } catch (SQLException e) {
            System.out.println("Didn't work");
            System.err.print(e);
        }
        
        
    }
}
