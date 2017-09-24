
package restaurant.application.Tables;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Tables_info {
    public static void getTables(ResultSet rs) throws SQLException {
        while (rs.next()) {
            StringBuffer buffer = new StringBuffer();
            
            buffer.append("Table ID " + rs.getInt("table_id") + ' ');
            buffer.append(rs.getString("name") + ' ');
            buffer.append(rs.getString("email") + ' ');
            buffer.append(rs.getString("status") + ' ');
            buffer.append(rs.getInt("num_people"));
        }
    }
}
