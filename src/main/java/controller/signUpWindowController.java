package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class signUpWindowController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField signUpLoginFIeld;

    @FXML
    private Button signUpNextButton;

    @FXML
    private PasswordField signUpPasswordField;

    @FXML
    private PasswordField signUpRepeatPasswordField;

    @FXML
    void initialize() {
        assert signUpLoginFIeld != null : "fx:id=\"signUpLoginFIeld\" was not injected: check your FXML file 'signUpWindow.fxml'.";
        assert signUpNextButton != null : "fx:id=\"signUpNextButton\" was not injected: check your FXML file 'signUpWindow.fxml'.";
        assert signUpPasswordField != null : "fx:id=\"signUpPasswordField\" was not injected: check your FXML file 'signUpWindow.fxml'.";
        assert signUpRepeatPasswordField != null : "fx:id=\"signUpRepeatPasswordField\" was not injected: check your FXML file 'signUpWindow.fxml'.";


        signUpNextButton.setOnAction(event -> System.out.println("Works!"));
    }
}

