package com.example.uml_tool;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class ActivityDiagramController {
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

    TextField text;
    TextArea text2;
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

    public void ButtonHovered(MouseEvent e) {
        System.out.println("Hovered");
        //     setBackground(new Background(new BackgroundFill(Color.RED, null, null)));

    }

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

    public void Exit(ActionEvent e) throws IOException {
        try {
            Stage pstage = (Stage) B.getScene().getWindow();
            pstage.close();
            Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } catch (Exception er) {
            System.out.println("Error found");
        }
    }
//Don't need to change anything above it


    public void addAction() {
        bt = new Button();
        bt.getStyleClass().add("action");
        bt.setPrefSize(150, 80);
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

    public void addstart() {
        bt = new Button();
        bt.getStyleClass().add("startCircle");
        bt.setMinSize(100, 80);
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

    public void addFork() {
        bt = new Button();
        bt.getStyleClass().add("fork");
        bt.setPrefSize(200, 3);
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

    public void addDecision() {
        bt = new Button();
        bt.getStyleClass().add("Decision");
        bt.setMinSize(145, 80);
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
    @FXML
    Label actLb;
    @FXML
    MenuBar menubar;
    ColorPicker colorPicker = new ColorPicker();
    public void bgColor()
    {

        p.getChildren().add(colorPicker);
        colorPicker.valueProperty().addListener((observable -> {
            p.setStyle(
                    "-fx-background-color: #" + colorPicker.getValue().toString().substring(2, 8) + ";"
            );
            actLb.setStyle(
                    "-fx-background-color: #" + colorPicker.getValue().toString().substring(2, 8) + ";"
            );
            menubar.setStyle(
                    "-fx-background-color: #" + colorPicker.getValue().toString().substring(2, 8) + ";"
            );
        }));
    }
    public void Default()
    {
        p.setStyle("-fx-background-color: #f4f4f4");
        menubar.setStyle("-fx-background-color: #3a88a9");
        actLb.setStyle("-fx-background-color: #9bc6d9");

    }

    public void Save(ActionEvent e)
    {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("All Files", "*.jpg"));
        Stage stage = (Stage) p.getScene().getWindow();
        File file = fileChooser.showSaveDialog(stage);
    }
public void Hideclr(MouseEvent e)
{
    System.out.println("click");
    colorPicker.setVisible(false);
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
        text = new TextField();
        text.setMaxSize(90,200);
        text.getStyleClass().add("text-field");
        text.translateXProperty().bind(bt.translateXProperty().add(35));
        text.translateYProperty().bind(bt.translateYProperty().add(30));



        p.getChildren().add(text);



    }
    int visible = 0;
    public void Anchor()
    {
        Button b1 = new Button();
        Button b2 = new Button();
        Button b3 = new Button();
        Button b4 = new Button();

        b1.setMaxSize(20,20);
        b2.setMaxSize(20,20);
        b2.setMaxSize(20,20);
        b4.setMaxSize(20,20);

//side anchors
        b1.translateXProperty().bind(bt.translateXProperty().subtract(5));
        b1.translateYProperty().bind(bt.translateYProperty().add(28));
        b2.translateXProperty().bind(bt.translateXProperty().add(125));
        b2.translateYProperty().bind(bt.translateYProperty().add(28));

//top and down anchors
        b3.translateXProperty().bind(bt.translateXProperty().add(90));
        b3.translateYProperty().bind(bt.translateYProperty().subtract(7));
        b4.translateXProperty().bind(bt.translateXProperty().add(90));
        b4.translateYProperty().bind(bt.translateYProperty().add(75));

        b3.getTransforms().add(new Rotate(90));
        b4.getTransforms().add(new Rotate(90));

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


        line.startXProperty().bind(node1.translateXProperty().subtract(12));
        line.startYProperty().bind(node1.translateYProperty().add(5));
        line.endXProperty().bind(node2.translateXProperty().subtract(10));
        line.endYProperty().bind(node2.translateYProperty().subtract(6));

        p.getChildren().add(line);

        Button b = new Button();
        b.setMaxSize(20,20);
        b.getStyleClass().add("arrow");
        if(!side) {
            b.getTransforms().add(new Rotate(90));
            b.translateXProperty().bind(node2.translateXProperty().add(2));
            b.translateYProperty().bind(node2.translateYProperty().subtract(11));
        }
        else
        {b.translateXProperty().bind(node2.translateXProperty().subtract(9));
            b.translateYProperty().bind(node2.translateYProperty().subtract(7));}

        p.getChildren().add(b);
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
}
