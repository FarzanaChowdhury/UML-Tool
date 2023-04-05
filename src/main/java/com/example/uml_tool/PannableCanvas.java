package com.example.uml_tool;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;
/*
public class PannableCanvas extends Pane {
    @FXML
    private Canvas grid;
    Scale scaleTransform;

    public PannableCanvas() {

        setPrefSize(600, 600);
        setStyle("-fx-background-color: lightgrey; -fx-border-color: blue;");

        // add scale transform
        scaleTransform = new Scale( 1.0, 1.0);
        getTransforms().add( scaleTransform);

        // logging
        addEventFilter(MouseEvent.MOUSE_PRESSED, event -> {
            System.out.println(
                    "canvas event: " + ( ((event.getSceneX() - getBoundsInParent().getMinX()) / getScale()) + ", scale: " + getScale())
            );
            System.out.println( "canvas bounds: " + getBoundsInParent());
        });

    }

    /**
     * Add a grid to the canvas, send it to back
     */



/*
    public void addGrid() {

        double w = getBoundsInLocal().getWidth();
        double h = getBoundsInLocal().getHeight();

        // add grid
       // Canvas grid = new Canvas(w, h);

        // don't catch mouse events
        grid.setMouseTransparent(true);

        GraphicsContext gc = grid.getGraphicsContext2D();

        gc.setStroke(Color.GRAY);
        gc.setLineWidth(1);

        // draw grid lines
        double offset = 50;
        for( double i=offset; i < w; i+=offset) {
            // vertical
            gc.strokeLine( i, 0, i, h);
            // horizontal
            gc.strokeLine( 0, i, w, i);
        }

        getChildren().add( grid);

        grid.toBack();
    }

    public Scale getScaleTransform() {
        return scaleTransform;
    }

    public double getScale() {
        return scaleTransform.getY();
    }

    /**
     * Set x/y scale
     * @param scale
     */



/*
    public void setScale( double scale) {
        scaleTransform.setX(scale);
        scaleTransform.setY(scale);
    }

    /**
     * Set x/y pivot points
     * @param x
     * @param y
     */
/*
    public void setPivot( double x, double y) {
        scaleTransform.setPivotX(x);
        scaleTransform.setPivotY(y);
    }
}

*/