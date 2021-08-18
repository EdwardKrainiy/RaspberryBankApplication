package controller;

import java.net.URL;
import java.util.ResourceBundle;

import Util.UiUtil;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import model.Account;
import service.AccountService;

public class signUpWindowController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField signUpLoginField;

    @FXML
    private Button signUpNextButton;

    @FXML
    private PasswordField signUpPasswordField;

    @FXML
    private PasswordField signUpRepeatPasswordField;

    @FXML
    private Text loginErrorText;

    @FXML
    void initialize() {
        assert signUpLoginField != null : "fx:id=\"signUpLoginField\" was not injected: check your FXML file 'signUpWindow.fxml'.";
        assert signUpNextButton != null : "fx:id=\"signUpNextButton\" was not injected: check your FXML file 'signUpWindow.fxml'.";
        assert signUpPasswordField != null : "fx:id=\"signUpPasswordField\" was not injected: check your FXML file 'signUpWindow.fxml'.";
        assert signUpRepeatPasswordField != null : "fx:id=\"signUpRepeatPasswordField\" was not injected: check your FXML file 'signUpWindow.fxml'.";
        assert loginErrorText != null : "fx:id=\"loginErrorText\" was not injected: check your FXML file 'signUpWindow.fxml'.";

        enterLoginAndPassword();
    }
    public void enterLoginAndPassword(){
        signUpNextButton.setOnAction(event -> {
            String loginText = signUpLoginField.getText().trim();
            String passwordText = signUpPasswordField.getText();
            String repeatPasswordText = signUpRepeatPasswordField.getText();

            boolean isLoginExisting = AccountService.findByLogin(loginText) != null;

            if(!loginText.equals("") && !passwordText.equals("")){
                if(!isLoginExisting){
                    if(repeatPasswordText.equals(passwordText))
                    {
                        Account newAccount = new Account(loginText, passwordText);
                        AccountService.saveAccount(newAccount);

                        UiUtil.goToNextWindow("/fxml/signUpEnterPersonalWindow.fxml", signUpNextButton);
                    }
                    else {
                        loginErrorText.setVisible(true);
                        loginErrorText.setText("Пароли не совпадают!");
                    }
                }
                else {
                    loginErrorText.setVisible(true);
                    loginErrorText.setText("Пользователь с таким логином уже существует.");
                }
            }
            else {
                loginErrorText.setVisible(true);
                loginErrorText.setText("Введите логин и пароль!");
            }
        });
    }
}



