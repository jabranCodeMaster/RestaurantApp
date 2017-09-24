/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.application.Tables;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Mehtab
 */
public class Employee_info {
    
    public static void getEmployees(ResultSet rs) throws SQLException {
        while (rs.next()) {
            StringBuffer buffer = new StringBuffer();
            
            buffer.append("Employee ID " + rs.getInt("employee_id") + ' ');
            buffer.append(rs.getString("first_name") + ' ');
            buffer.append(rs.getString("last_name") + ' ');
            buffer.append(rs.getDate("dob"));
        }
    }
}
