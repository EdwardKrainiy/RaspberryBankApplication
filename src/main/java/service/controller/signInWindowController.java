package service.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class signInWindowController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField login_field;

    @FXML
    private Button signInButton;

    @FXML
    private PasswordField password_field;

    @FXML
    private Button signUpButton;

    @FXML
    void initialize() {
        assert login_field != null : "fx:id=\"login_field\" was not injected: check your FXML file 'signInWindow.fxml'.";
        assert signInButton != null : "fx:id=\"signInButton\" was not injected: check your FXML file 'signInWindow.fxml'.";
        assert password_field != null : "fx:id=\"password_field\" was not injected: check your FXML file 'signInWindow.fxml'.";
        assert signUpButton != null : "fx:id=\"signUpButton\" was not injected: check your FXML file 'signInWindow.fxml'.";

        signInButton.setOnAction(event -> {
            System.out.println("Login!");
        });
    }
}
