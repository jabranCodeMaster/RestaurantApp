/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.application;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import restaurant.application.database.MySQL_Connector;

/**
 *
 * @author Mehtab
 */
public class Main extends Application {
    
    private Stage primaryStage;
    private static BorderPane mainLayout;
    
    @Override
    public void start(Stage primaryStage) throws IOException, Exception {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Employee App");
        
        showMainView();
        showLogin();
        
        MySQL_Connector connector = new MySQL_Connector();
        connector.readDatabase();
    }

    public void showMainView() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("view/MainView.fxml"));
        mainLayout = loader.load();
        Scene scene = new Scene(mainLayout);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public void showLogin() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("view/LoginFXML.fxml"));
        AnchorPane loginView = loader.load();
        mainLayout.setCenter(loginView);
    }
    
    public static void showHomescreen() throws IOException {
        FXMLLoader screenloader = new FXMLLoader();
        screenloader.setLocation(Main.class.getResource("view/MainFXML.fxml"));
        BorderPane mainView = screenloader.load();
        mainLayout.setCenter(mainView);
    }
    public static void main(String[] args){
        launch(args);
    }
    
}
