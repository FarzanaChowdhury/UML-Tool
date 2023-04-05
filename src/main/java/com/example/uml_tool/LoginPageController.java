package com.example.uml_tool;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginPageController implements Initializable {

    private String username="zannatulferdous@iut-dhaka.edu";
    private String password="123";
    private String username2="farzana4@iut-dhaka.edu";
    private String password2="123";
    @FXML
    private TextField emailaddressTextField;

    @FXML
    private Button googleloginButton;

    @FXML
    private Button loginButton;

    @FXML
    private PasswordField passwordPasswordField;
    
    @FXML
    private Label messageLabel;
    
    @FXML
    private Button resetButton;

    @FXML
    private Button signButton;
    
    private Stage stage;
    private Scene scene;
    private Parent root;
    
    @FXML
    void loginButtonOnAction(ActionEvent event) throws IOException {
         if (emailaddressTextField.getText().isBlank()) {
             messageLabel.setTextFill(Color.web("#CF000F"));
            messageLabel.setText("Enter Email!");
        } else if (passwordPasswordField.getText().isBlank()) {
            messageLabel.setTextFill(Color.web("#CF000F"));
            messageLabel.setText("Enter Password!");

        }
//         else if(passwordPasswordField.getText()!= "123"){
//             System.out.println("Login unsuccessful!");
//             messageLabel.setTextFill(Color.web("#CF000F"));
//             messageLabel.setText("Wrong email or password!!");
//         }
         else {
            if (ValidateLogin()) {
                messageLabel.setText("Login Successful");
                 Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
            }
        }
    }
     @FXML
    void signUpButtonOnAction(ActionEvent event)throws IOException {
          Parent root = FXMLLoader.load(getClass().getResource("RegisterPage.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);

//        stage.setResizable(true);
        stage.show();
//        Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
//        stage.setX((primScreenBounds.getWidth() - stage.getWidth()) / 2);
//        stage.setY((primScreenBounds.getHeight() - stage.getHeight()) / 2);
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public boolean ValidateLogin() {
        if(emailaddressTextField.getText().equals(username) && passwordPasswordField.getText().equals(password)||
                emailaddressTextField.getText().equals(username2) && passwordPasswordField.getText().equals(password2))
            return true;
        else return false;
//        databaseCon connectNow = new databaseCon();
//        Connection conDB = connectNow.getConnection();
//
//        String email = emailaddressTextField.getText();
//        String password = DigestUtils.md5Hex(passwordPasswordField.getText());
//
//        String verifyLogin = "SELECT count(1) FROM user_info WHERE emailAddress = '" + email + "' AND password= '" + password + "';";
//
//        try {
//            Statement stmt = conDB.createStatement();
//            ResultSet rset = stmt.executeQuery(verifyLogin);
//
//            while (rset.next()) {
//                if (rset.getInt(1) == 1) {
//                    System.out.println("Login Successful");
//                    messageLabel.setTextFill(Color.web("#26A65B"));
//                    messageLabel.setText("Login Successful!!" + " WELCOME ");
//                    return true;
//                } else {
//                    System.out.println("Login unsuccessful!");
//                    messageLabel.setTextFill(Color.web("#CF000F"));
//                    messageLabel.setText("Wrong email or password!!");
//                }
//            }
//        } catch (SQLException e) {
//        }
//        return false;
    }
}
