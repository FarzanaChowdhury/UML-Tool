package com.example.umltool;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;

public class UMLView {


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
            System.out.println("Error found");
        }

    }
    @FXML
    public void ClassDiagram(MouseEvent e) throws IOException
    {
        try {
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
    {Platform.exit();}
}

