/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.example.uml_tool;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class MenuController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private ImageView backgroundImage;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      //  this.backgroundImage=  new ImageView(new Image(getClass().getResourceAsStream("E:\\AbarUML\\UML Init\\UML Tool\\src\\main\\resources\\com\\example\\uml_tool\\Images\\MenuBackground.png")));
    }
    @FXML
    private AnchorPane Base;
    Parent root;
 /*   @Override
    public void initialize(URL url, ResourceBundle rb)
    {}
    */


    public void Goto(String Name) throws IOException
    {
        try {
            //Base is one of the nodes of the previous stage
            Stage pstage = (Stage) Base.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource(Name+".fxml"));

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            pstage.close();

        }
        catch(Exception er) {
            System.out.println("Error error");
        }

    }
    @FXML
    public void ClassDiagram(MouseEvent e) throws IOException
    {
        try {
            System.out.println("Class");
            Goto("ClassDiagram");
        }
        catch(Exception er){
            System.out.println("Failed to Open Diagram");
        }
    }
    @FXML
    public void ActivityDiagram(MouseEvent e) throws IOException
    {
        try {
            Goto("ActivityDiagram");
        }
        catch(Exception er){
            System.out.println("Failed to Open Diagram");
        }
    }
    @FXML
    public void FlowChart(MouseEvent e) throws IOException
    {
        try {
            Goto("FlowChart");
        }
        catch(Exception er){
            System.out.println("Failed to Open Diagram");
        }
    }
    @FXML
    public void Exit(MouseEvent e)
    {
        Platform.exit();}
}



    

