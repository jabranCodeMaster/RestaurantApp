/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.application.view;

//finish implementing function reserveTable()

import com.mysql.jdbc.Connection;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import restaurant.application.Main;
import restaurant.application.database.DBConnector;
import restaurant.application.model.Table;

/**
 * FXML Controller class
 *
 * @author Mehtab
 */
public class MainFXMLController implements Initializable {
    
    @FXML
    private BorderPane rootLayout;

    @FXML
    private Label welcome_label;

    @FXML
    private ImageView imageHome;

    @FXML
    private ImageView imageReserv;

    @FXML
    private ImageView imageOrder;

    @FXML
    private ImageView imagePay;

    @FXML
    private ImageView imageSettings;

    @FXML
    private AnchorPane homePane;

    @FXML
    private AnchorPane reservPane;

    @FXML
    private ListView<String> reserv_empty_list;
    
    @FXML
    private ListView<String> reserv_nempty_list;

    @FXML
    private Button reserv_add;

    @FXML
    private Button reserv_cancel;

    @FXML
    private TextField reserv_name;

    @FXML
    private TextField reserv_num_people;

    @FXML
    private TextField reserv_phone;

    @FXML
    private TextField reserv_email;

    @FXML
    private AnchorPane orderPane;

    @FXML
    private AnchorPane settingsPane;

    @FXML
    private AnchorPane payPane;
    
    
    Main main;
    Table[] list_tables = new Table[6];
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       fillTable();
    }
    
    private void fillTable() {
        for (int i = 0; i < 6; i++) {
            list_tables[i] = new Table();
        }
        try (
                Connection connect = DBConnector.getConnection();
                Statement stmt = connect.createStatement(
                        ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                ResultSet rs = stmt.executeQuery("SELECT * FROM tables");
                )
        {
            int pos = 0;
            rs.first();
            while (!rs.isAfterLast()) {
                
                list_tables[pos].setTableID(rs.getInt("table_id"));
                list_tables[pos].setName(rs.getString("name"));
                list_tables[pos].setNumPeople(rs.getInt("num_people"));
                list_tables[pos].setStatus(rs.getString("status"));
                list_tables[pos].setEmail(rs.getString("email"));
                list_tables[pos].setPhone(rs.getString("phone_num"));
                
                pos++;
                rs.next();
            }
        }
        catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    
    public void homePress(MouseEvent event) {
        homePane.setVisible(true);
        homePane.setDisable(false);
        reservPane.setVisible(false);
        reservPane.setDisable(true);
        orderPane.setVisible(false);
        orderPane.setDisable(true);
        payPane.setVisible(false);
        payPane.setDisable(true);
        settingsPane.setVisible(false);
        settingsPane.setDisable(true);
    }
    
    public void reservPress(MouseEvent event) {
        homePane.setVisible(false);
        homePane.setDisable(true);
        reservPane.setVisible(true);
        reservPane.setDisable(false);
        orderPane.setVisible(false);
        orderPane.setDisable(true);
        payPane.setVisible(false);
        payPane.setDisable(true);
        settingsPane.setVisible(false);
        settingsPane.setDisable(true);
        
        setListView();
    }
    
    private void setListView() {
        reserv_empty_list.getItems().clear();
        reserv_nempty_list.getItems().clear();
        for (int i = 0; i < 6; i++) {
            if (list_tables[i].getStatus().equals("empty")) {
                reserv_empty_list.getItems().add(("Table ") + list_tables[i].getTableID());
            }
            else {
                reserv_nempty_list.getItems().add(("Table ") + list_tables[i].getTableID());
            }
        }
    }
    
    private void reserveTable(ActionEvent e) {
        String name = reserv_name.getText();
        int numPeople = Integer.parseInt(reserv_num_people.getText());
        String email = reserv_email.getText();
        String phone = reserv_phone.getText();
        
        ObservableList listofTablesEmpty = reserv_empty_list.getSelectionModel().getSelectedItems();
        
        //string_table_num = reserv_empty_list.getItems().
    }
    
    public void orderPress(MouseEvent event) {
        homePane.setVisible(false);
        homePane.setDisable(true);
        reservPane.setVisible(false);
        reservPane.setDisable(true);
        orderPane.setVisible(true);
        orderPane.setDisable(false);
        payPane.setVisible(false);
        payPane.setDisable(true);
        settingsPane.setVisible(false);
        settingsPane.setDisable(true);
    }
    
    public void payPress(MouseEvent event) {
        homePane.setVisible(false);
        homePane.setDisable(true);
        reservPane.setVisible(false);
        reservPane.setDisable(true);
        orderPane.setVisible(false);
        orderPane.setDisable(true);
        payPane.setVisible(true);
        payPane.setDisable(false);
        settingsPane.setVisible(false);
        settingsPane.setDisable(true);
    }
    
    public void settingsPress(MouseEvent event) {
        homePane.setVisible(false);
        homePane.setDisable(true);
        reservPane.setVisible(false);
        reservPane.setDisable(true);
        orderPane.setVisible(false);
        orderPane.setDisable(true);
        payPane.setVisible(false);
        payPane.setDisable(true);
        settingsPane.setVisible(true);
        settingsPane.setDisable(false);
    }
}
