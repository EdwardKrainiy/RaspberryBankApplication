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
import javafx.scene.text.Text;
import service.AccountService;

public class SignInWindowController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField signInLoginField;

    @FXML
    private Button signInButton;

    @FXML
    private PasswordField signInPasswordField;

    @FXML
    private Text signInErrorText;

    @FXML
    private Button signUpButton;

    @FXML
    private Button exitButton;

    @FXML
    void initialize() {
        assert signInLoginField != null : "fx:id=\"signInLoginField\" was not injected: check your FXML file 'signInWindow.fxml'.";
        assert signInButton != null : "fx:id=\"signInButton\" was not injected: check your FXML file 'signInWindow.fxml'.";
        assert signInPasswordField != null : "fx:id=\"signInPasswordField\" was not injected: check your FXML file 'signInWindow.fxml'.";
        assert signInErrorText != null : "fx:id=\"signInErrorText\" was not injected: check your FXML file 'signInWindow.fxml'.";
        assert signUpButton != null : "fx:id=\"signUpButton\" was not injected: check your FXML file 'signInWindow.fxml'.";
        assert exitButton != null : "fx:id=\"exitButton\" was not injected: check your FXML file 'signInWindow.fxml'.";

        initializeSignUpButton();
        initializeSignInButton();
        initializeExitButton();

    }

    private void initializeSignUpButton(){
        signUpButton.setOnAction(event -> {
            try {
                UiUtil.goToNextWindow(WindowPath.SIGN_UP_WINDOW, event);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private void initializeSignInButton(){
        signInButton.setOnAction(event -> {
            String loginText = signInLoginField.getText();
            String passwordText = signInPasswordField.getText();

            boolean isLoginExisting = AccountService.findByLogin(loginText) != null;

            if(!loginText.equals("") && !passwordText.equals("")){

                String accountPassword = AccountService.findByLogin(loginText).getPassword();

                if(isLoginExisting && accountPassword.equals(passwordText)){
                    try {
                        UiUtil.goToNextWindow(WindowPath.APP_MAIN_WINDOW, event);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                else{
                    signInErrorText.setVisible(true);
                    signInErrorText.setText("Логин и/или пароль введены неверно!");
                }
            }
            else {
                signInErrorText.setVisible(true);
                signInErrorText.setText("Введите логин и пароль!");
            }
        });
    }

    private void initializeExitButton(){
        exitButton.setOnAction(UiUtil::closeWindow);
    }
}

