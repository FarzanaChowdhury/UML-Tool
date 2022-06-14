package com.example.umltool;


import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;

import java.io.IOException;

public class Start extends Application {

        @Override
        public void start(Stage stage) throws IOException {
            Parent root = FXMLLoader.load(getClass().getResource("UMLView.fxml"));

            Line line = new Line();
            stage.setResizable(true);
            stage.setTitle("UML Tool");
            Scene scene = new Scene(root);
            Group r = new Group(line);
            stage.setScene(scene);
            stage.show();

    }
    public static void main(String[] args) {
        launch();
    }
}
