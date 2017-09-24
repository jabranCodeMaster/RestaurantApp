
package restaurant.application.view;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.mysql.jdbc.Connection;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import restaurant.application.Main;
import restaurant.application.database.DBConnector;


public class LoginFXMLController implements Initializable {

    private Main main;
    /**
     * Initializes the controller class.
     */
    @FXML
    private JFXTextField textUser;

    @FXML
    private JFXPasswordField textPass;

    @FXML
    private JFXButton btnLogin;

    @FXML
    private JFXButton btnPassword;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    
    public void loginPress(ActionEvent event) throws IOException {
        String username = textUser.getText();
        String password = textPass.getText();
        
        checkLogin(username, password);
        
        if (username.equals("Hello") && password.equals("12345")) {
            System.out.println("Login Successful");
            main.showHomescreen();
        }
    }
    
    public void passPress(ActionEvent event) {
        System.out.println("Button was pressed");
    }
    
    public static void checkLogin(String username, String password) throws IOException {
        
        try (
                Connection connect = DBConnector.getConnection();
                Statement stmt = connect.createStatement(
                        ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                ResultSet rs = stmt.executeQuery("SELECT * FROM employee_info");
                )
        {
            rs.first();
            while (!rs.isAfterLast()) {
                if ((username.equals(rs.getString("email_id"))) && (password.equals(rs.getString("password")))) {
                    System.out.println("User detected");
                    Main.showHomescreen();
                    break;
                }
                rs.next();
            }
            
        }
        catch(SQLException e) {
            System.out.println(e);
        }
    }
    
}
