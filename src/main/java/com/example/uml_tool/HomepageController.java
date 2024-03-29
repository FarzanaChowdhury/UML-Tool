/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.example.uml_tool;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class HomepageController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private ImageView homepageBackground;
    private Stage stage;
    private Scene scene;
    private Parent root;
    
     @FXML
    void tryButtonOnAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("LoginPage.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
     //   stage.setFullScreen(true);
        stage.setResizable(true);
        stage.show();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      //  this.homepageBackground=  new ImageView(new Image(getClass().getResourceAsStream("E:\\AbarUML\\UML Init\\UML Tool\\src\\main\\resources\\com\\example\\uml_tool\\Images\\HomepageBackground.png")));
    }
    
}
