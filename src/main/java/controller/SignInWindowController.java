package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Util.UiUtil;
import Util.WindowPath;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class SignInWindowController {

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

        openSignUpWindow();

    }

    private void openSignUpWindow(){
        signUpButton.setOnAction(event -> {
            try {
                UiUtil.goToNextWindow(WindowPath.SIGN_UP_WINDOW, event);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
