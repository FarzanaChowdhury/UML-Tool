package com.example.uml_tool;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;

import java.io.IOException;

public class ClassDiagram {
    private int shapeCount = 0, flag = 0;
    boolean selected = false;
    private Shape shapeBeingDragged = null;
    private Translate translate;
    private Shape[] shapes = new Shape[500];
    private Line line;
    double x, y;
    double orgSceneX, orgSceneY;
    double orgTranslateX, orgTranslateY;
    double startX,startY,endX,endY;
    TranslateTransition transition = new TranslateTransition();
    @FXML
    private HBox B;
    @FXML
    private Canvas canvas;
    @FXML
    Button cls;
    @FXML
    private AnchorPane p;

    private Button bt;
    Node node1,node2;
    //  TextField text;

    public void ButtonHover(MouseEvent e) {
        System.out.println("Hover");
        //     setBackground(new Background(new BackgroundFill(Color.RED, null, null)));

    }

    public void Bold(MouseEvent e) {
        System.out.println("Bold");
    }

    public void Italic(MouseEvent e) {
        System.out.println("Italic");
    }

    public void Undo(MouseEvent e) {
        System.out.println("Undo");
    }

    public void Redo(MouseEvent e) {
        System.out.println("Redo");
    }

   /* public void Exit(ActionEvent e) throws IOException {
        try {
            Stage pstage = (Stage) B.getScene().getWindow();
            pstage.close();
            Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();}
        catch(Exception er) {
            System.out.println("Error found");
        }
    }*/



    public void ExitClass(ActionEvent e) throws IOException {
        try {
            Stage pstage = (Stage) B.getScene().getWindow();
            pstage.close();
            Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();}
        catch(Exception er) {
            System.out.println("Error found");
        }
    }
    public void addButton(Button btn) {
        bt = btn;
        bt.getStyleClass().add("second-button");
        bt.setMinSize(100, 100);
        p.getChildren().add(bt);
        bt.setOnMousePressed(mouseHandler);
        bt.setOnMouseDragged(mouseHandler);
        Make_TextField();
        Anchor();

              /*  bt.setOnScroll(e ->  {
                        bt.getChildren().addAll(new EditableDraggableText(e.getX(), e.getY()));*/
        bt.setOnMouseClicked(event ->
        {
            switch (event.getClickCount()) {
                case 2:
                    System.out.println("Two click");
                    //  Create_Line(event);
                    break;
            }
        });

    }

    public void make_Button(MouseEvent e) {
        addButton(new Button());
        Button btn = new Button();
    }

    EventHandler<MouseEvent> mouseHandler = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent e) {
            if (e.getEventType() == MouseEvent.MOUSE_PRESSED) {
                               /* x = e.getX();
                                y = e.getY();
                                */

                orgSceneX = e.getSceneX();
                orgSceneY = e.getSceneY();
                orgTranslateX = ((Button) (e.getSource())).getTranslateX();
                orgTranslateY = ((Button) (e.getSource())).getTranslateY();

                System.out.println("X:" + orgSceneX);
                System.out.println("Y:" + orgSceneY);

            } else if (e.getEventType() == MouseEvent.MOUSE_DRAGGED) {
                double offsetX = e.getSceneX() - orgSceneX;
                double offsetY = e.getSceneY() - orgSceneY;
                double newTranslateX = orgTranslateX + offsetX;
                double newTranslateY = orgTranslateY + offsetY;

                ((Button) (e.getSource())).setTranslateX(newTranslateX);
                ((Button) (e.getSource())).setTranslateY(newTranslateY);

                System.out.println("Dragged");
            }
            else if(e.getEventType() == MouseEvent.MOUSE_MOVED)
            {

            }

        }
    };

    public void Make_TextField()
    {
        TextField text = new TextField();
        text.setMaxSize(90,200);
        text.getStyleClass().add("text-field");
        text.translateXProperty().bind(bt.translateXProperty());
        text.translateYProperty().bind(bt.translateYProperty());


        TextArea text2 = new TextArea();
        text2.setMaxSize(90,62);
        text2.getStyleClass().add("text-area");
        //     text2.translateXProperty().bind(bt.widthProperty());
        //    text2.translateYProperty().bind(bt.heightProperty().divide(2));

        text2.setPadding(new Insets(0,0,0,0));
        text2.translateXProperty().bind(bt.translateXProperty());
        text2.translateYProperty().bind(bt.translateYProperty().add(35));


        p.getChildren().add(text2);
        p.getChildren().add(text);



    }
    int visible = 0;
    public void Anchor()
    {
        Button b1 = new Button();
        Button b2 = new Button();
        Button b3 = new Button();
        Button b4 = new Button();

//side anchors
        b1.translateXProperty().bind(bt.translateXProperty().subtract(7));
        b1.translateYProperty().bind(bt.translateYProperty().add(50));
        b2.translateXProperty().bind(bt.translateXProperty().add(95));
        b2.translateYProperty().bind(bt.translateYProperty().add(50));

//top and down anchors
        b3.translateXProperty().bind(bt.translateXProperty().add(45));
        b3.translateYProperty().bind(bt.translateYProperty().subtract(10));
        b4.translateXProperty().bind(bt.translateXProperty().add(45));
        b4.translateYProperty().bind(bt.translateYProperty().add(90));

        b1.getStyleClass().add("anchor");
        b2.getStyleClass().add("anchor");
        b3.getStyleClass().add("anchor");
        b4.getStyleClass().add("anchor");
        p.getChildren().add(b1);
        p.getChildren().add(b2);
        p.getChildren().add(b3);
        p.getChildren().add(b4);

        b1.setOnMouseClicked(sideConnect);
        b2.setOnMouseClicked(sideConnect);
        b3.setOnMouseClicked(topConnect);
        b4.setOnMouseClicked(topConnect);
    }
    boolean side;
    public void createLine()
    {
        line = new Line(startX,startY,endX,endY);


        line.startXProperty().bind(node1.translateXProperty().add(6));
        line.startYProperty().bind(node1.translateYProperty().add(9));
        line.endXProperty().bind(node2.translateXProperty().add(6));
        line.endYProperty().bind(node2.translateYProperty().add(9));

        p.getChildren().add(line);
    }

    EventHandler<MouseEvent> sideConnect = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent e) {
            if (e.getEventType() == MouseEvent.MOUSE_CLICKED) {

                side = true;
                if(flag==0)
                {
                    node1 = (Node)e.getSource();
                    startX = node1.getTranslateX()+5;
                    startY = node1.getTranslateY();
                    flag =1;
                }
                else
                {
                    node2 = (Node)e.getSource();
                    endX = node2.getTranslateX()+5;
                    endY = node2.getTranslateY();
                    flag = 0;

                    createLine();


                };


            }

        }
    };

    EventHandler<MouseEvent> topConnect = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent e) {
            if (e.getEventType() == MouseEvent.MOUSE_CLICKED) {

                side = false;
                if(flag==0)
                {
                    node1 = (Node)e.getSource();
                    startX = node1.getTranslateX()+5;
                    startY = node1.getTranslateY();
                    flag =1;
                }
                else
                {
                    node2 = (Node)e.getSource();
                    endX = node2.getTranslateX()+5;
                    endY = node2.getTranslateY();
                    flag = 0;

                    createLine();


                };


            }

        }
    };

    public void Aggregation()
    {
        Button b = new Button();
        b.getStyleClass().add("aggregation");
        if(side) {
            b.getTransforms().add(new Rotate(90));
            b.translateXProperty().bind(line.endXProperty().add(6));
            b.translateYProperty().bind(line.endYProperty().subtract(8));
        }
        else
        {b.translateXProperty().bind(line.endXProperty().subtract(8));
            b.translateYProperty().bind(line.endYProperty().subtract(24));}

        p.getChildren().add(b);
    }

    public void Association()
    {
        Button b = new Button();
        b.getStyleClass().add("association");
        if(!side) {
            b.getTransforms().add(new Rotate(90));
            b.translateXProperty().bind(node2.translateXProperty().add(18));
            b.translateYProperty().bind(node2.translateYProperty().subtract(3));
        }
        else
        {b.translateXProperty().bind(node2.translateXProperty().subtract(9));
            b.translateYProperty().bind(node2.translateYProperty().subtract(7));}

        p.getChildren().add(b);
    }
    public void Composition()
    {
        Button b = new Button();
        b.getStyleClass().add("composition");

        if(side) {
            b.getTransforms().add(new Rotate(90));
            b.translateXProperty().bind(line.endXProperty().add(5));
            b.translateYProperty().bind(line.endYProperty().subtract(8));
        }
        else
        {b.translateXProperty().bind(line.endXProperty().subtract(8));
            b.translateYProperty().bind(line.endYProperty().subtract(24));}

        p.getChildren().add(b);
    }
    public void Inheritance()
    {
        Button b = new Button();
        b.getStyleClass().add("inheritance");
        if(!side) {
            b.getTransforms().add(new Rotate(90));
            b.translateXProperty().bind(node2.translateXProperty().add(18));
            b.translateYProperty().bind(node2.translateYProperty().subtract(3));
        }
        else
        {b.translateXProperty().bind(node2.translateXProperty().subtract(9));
            b.translateYProperty().bind(node2.translateYProperty().subtract(7));}
        p.getChildren().add(b);

    }

}

