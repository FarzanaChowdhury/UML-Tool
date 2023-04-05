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
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;
import javafx.scene.text.TextFlow;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ClassDiagramController {
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
        TextFlow text_flow = new TextFlow();
        @FXML
        private HBox B;
        @FXML
        private Canvas canvas;
        @FXML
        Button cls;
        @FXML
        private AnchorPane p;
        @FXML
        private ScrollPane scroll;

        private Button bt;
        Node node1,node2;
        int dark;
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

        public void classText()
        {
                text = new TextField();
                text.setMaxSize(90,200);
                text.getStyleClass().add("text-field");
                text.translateXProperty().bind(bt.translateXProperty());
                text.translateYProperty().bind(bt.translateYProperty());
                p.getChildren().add(text);
        }
        public void addButton(Button btn) {
                bt = btn;
                bt.getStyleClass().add("second-button");
                bt.setMinSize(100, 100);
                p.getChildren().add(bt);
                bt.setOnMousePressed(mouseHandler);
                bt.setOnMouseDragged(mouseHandler);
               /* bt.setOnKeyPressed(new EventHandler<KeyEvent>() {
                        *//*@Override
                        public void handle(KeyEvent ke) {
                                if (ke.getCode().equals(KeyCode.ENTER)) {
                                        Make_TextField();
                                }
                        }*//*

                });*/
                Make_TextField();
                classText();
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
                text2 = new TextArea();
                text2.setMaxSize(90,62);
                text2.getStyleClass().add("text-field");
           //     text2.translateXProperty().bind(bt.widthProperty());
            //    text2.translateYProperty().bind(bt.heightProperty().divide(2));

                text2.setPadding(new Insets(0,0,0,0));
                text2.translateXProperty().bind(bt.translateXProperty());
                text2.translateYProperty().bind(bt.translateYProperty().add(35));


                p.getChildren().add(text2);
            //    text_flow.getChildren().add(text2);




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
                b1.translateXProperty().bind(bt.translateXProperty().subtract(7));
                b1.translateYProperty().bind(bt.translateYProperty().add(50));
                b2.translateXProperty().bind(bt.translateXProperty().add(95));
                b2.translateYProperty().bind(bt.translateYProperty().add(50));

//top and down anchors
                b3.translateXProperty().bind(bt.translateXProperty().add(60));
                b3.translateYProperty().bind(bt.translateYProperty().subtract(10));
                b4.translateXProperty().bind(bt.translateXProperty().add(60));
                b4.translateYProperty().bind(bt.translateYProperty().add(90));

                b1.getStyleClass().add("anchor");
                b2.getStyleClass().add("anchor");
                b3.getStyleClass().add("anchor");
                b4.getStyleClass().add("anchor");

                b3.getTransforms().add(new Rotate(90));
                b4.getTransforms().add(new Rotate(90));

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


                line.startXProperty().bind(node1.translateXProperty().subtract(2));
                line.startYProperty().bind(node1.translateYProperty().add(9));
                line.endXProperty().bind(node2.translateXProperty().subtract(2));
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
                {b.translateXProperty().bind(line.endXProperty().subtract(10));
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
                {b.translateXProperty().bind(line.endXProperty().subtract(10));
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


        private void saveTextToFile(String content, File file) {
                try {
                        PrintWriter writer;
                        writer = new PrintWriter(file);
                        writer.println(content);
                        writer.close();
                } catch (IOException ex) {
                        Logger.getLogger(ClassDiagramController.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
        int bg = 0;
        @FXML
        MenuBar menubar;
        @FXML
        Label classLb;
        public void bgColor()
        {
                if(bg==0)


                {ColorPicker colorPicker = new ColorPicker();
                p.getChildren().add(colorPicker);
                colorPicker.valueProperty().addListener((observable -> {
                        p.setStyle(
                                "-fx-background-color: #" + colorPicker.getValue().toString().substring(2, 8) + ";"
                        );
                        classLb.setStyle(
                                "-fx-background-color: #" + colorPicker.getValue().toString().substring(2, 8) + ";"
                        );
                        menubar.setStyle(
                                "-fx-background-color: #" + colorPicker.getValue().toString().substring(2, 8) + ";"
                        );
                }));
                bg=1;
        }
                else bg = 0;}
        public void Default()
        {
                bg = 0;
                p.setStyle("-fx-background-color: #f4f4f4");
                menubar.setStyle("-fx-background-color: #3a88a9");
                classLb.setStyle("-fx-background-color: #9bc6d9");

        }
        public void darkMode()
        {
                dark = 1;
                p.getStyleClass().add("panedark");

                System.out.println("Dark");


        }
        protected String address;
        public void Save(ActionEvent e)
        {

          /*      WritableImage image = p.snapshot(new SnapshotParameters(), null);
                try {
                     //   address = "src\\main\\myDocuments\\" + static + "\\" + fileName + ".png";
                        ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", new File(address));
                } catch (IOException e) {
                        e.printStackTrace();
                }
        }*/

               /* WritableImage img = scrollPane.snapshot(new SnapshotParameters(), null);
                FileChooser chooser = new FileChooser();
                chooser.setCurrentDirectory(new File(System.getProperty("user.home")));
                // File fileToSave = chooser.getSelectedFile();//Remove this line.
                BufferedImage img2 = SwingFXUtils.fromFXImage(img, null);
                int result = chooser.showSaveDialog(null);
                if (result == FileChooser.APPROVE_OPTION) {
                        try {
                                File fileToSave = chooser.getSelectedFile();
                                ImageIO.write(img2, "png", fileToSave);
                        } catch (IOException ex) {
                                Logger.getLogger(GuiClass.class.getName()).log(Level.SEVERE, null, ex);
                        }
                }*/
                FileChooser fileChooser = new FileChooser();

                /*///Set extension filter for text files
                FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
                fileChooser.getExtensionFilters().add(extFilter);

                //Show save file dialog
                File file = fileChooser.showSaveDialog(primaryStage);

                if (file != null) {
                        saveTextToFile(sampleText, file);

*/

                fileChooser.setTitle("Save");
                fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("All Files", "*.jpg"));
                Stage stage = (Stage) p.getScene().getWindow();
                File file = fileChooser.showSaveDialog(stage);

             /*   if (file != null) {
                        saveTextToFile(sampleText, file);*/

                System.out.println("Saved");
        }


TextField t= new TextField();
        TextField t2= new TextField();
        TextField s=new TextField();
        TextField c=new TextField();
        Label type = new Label();
        Label code = new Label();
        Stage stage = new Stage();
        public void GenerateCode()
        {
               /* StringBuilder sb = new StringBuilder();
                for (Node node : text.getChildren()) {
                        if (node instanceof Text) {
                                sb.append(((Text) node).getText());
                        }
                }
                String fullText = sb.toString();*/
                String str = text2.getText();
                text2.getText().replaceAll("\n", System.getProperty("line.separator"));


                char firstChar = str.charAt(0);
                if(firstChar=='-')
                t.setText("Private ");
                else if (firstChar=='+')
                t.setText("Public ");
                else if(firstChar=='#')
                t.setText("Protected ");
                VBox layout= new VBox(5);
                t2.setText(text2.getText().substring(1));
                s.setText(";");

                code.setText( "class " + text.getText()+"{\n"+t.getText()+ t2.getText() +s.getText()+"\n}");
                layout.getChildren().addAll(code);

                Scene scene1= new Scene(layout, 300, 250);
                stage.setScene(scene1);

                stage.show();

        }

}