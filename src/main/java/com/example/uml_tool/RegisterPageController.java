package com.example.uml_tool;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.apache.commons.codec.digest.DigestUtils;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RegisterPageController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TextField emailAddressTextField;

    @FXML
    private TextField firstNameTextField;

    @FXML
    private TextField lastNameTextField;

    @FXML
    private PasswordField passwordPasswordField;
    
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    void loginRedirectOnAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("LoginPage.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
//        stage.setFullScreen(true);
//        stage.setResizable(true);
        stage.show();
    }

    @FXML
    void signUpButtonOnAction(ActionEvent event) throws IOException {
        String firstName = firstNameTextField.getText();
        String lastName = lastNameTextField.getText();
        String email = emailAddressTextField.getText();
        String password = DigestUtils.md5Hex(passwordPasswordField.getText());

        System.out.println("Registered Succesfully");
        Parent root = FXMLLoader.load(getClass().getResource("LoginPage.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
//        databaseCon connectNow = new databaseCon();
//        Connection conDB = connectNow.getConnection();
//
//        try{
//            PreparedStatement stmt = conDB.prepareStatement("insert into user_info(FirstName,LastName, emailAddress, password) values(?,?,?,?)");
//
//            stmt.setString(1, firstName);
//            stmt.setString(2, lastName);
//            stmt.setString(3, email);
//            stmt.setString(4, password);
//
//            int status = stmt.executeUpdate();
//            System.out.println("Registered Succesfully");
//            Parent root = FXMLLoader.load(getClass().getResource("LoginPage.fxml"));
//        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show();
//
//        }
//        catch (SQLException e) {
//                System.out.println("Error while connecting to the database.Exception code: " + e);
//        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
