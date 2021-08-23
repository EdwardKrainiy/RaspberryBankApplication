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
import model.Account;
import service.AccountInfoService;
import service.AccountService;

public class SignUpWindowController {

    private static int createdAccountId;

    public static int getCreatedAccountId() {
        return createdAccountId;
    }

    public void setCreatedAccountId(int createdAccountId) {
        SignUpWindowController.createdAccountId = createdAccountId;
    }

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
    private Text signUpErrorText;

    @FXML
    private Button signUpBackButton;

    @FXML
    void initialize() {
        assert signUpLoginField != null : "fx:id=\"signUpLoginField\" was not injected: check your FXML file 'signUpWindow.fxml'.";
        assert signUpNextButton != null : "fx:id=\"signUpNextButton\" was not injected: check your FXML file 'signUpWindow.fxml'.";
        assert signUpPasswordField != null : "fx:id=\"signUpPasswordField\" was not injected: check your FXML file 'signUpWindow.fxml'.";
        assert signUpRepeatPasswordField != null : "fx:id=\"signUpRepeatPasswordField\" was not injected: check your FXML file 'signUpWindow.fxml'.";
        assert signUpErrorText != null : "fx:id=\"signUpErrorText\" was not injected: check your FXML file 'signUpWindow.fxml'.";
        assert signUpBackButton != null : "fx:id=\"signUpCancelButton\" was not injected: check your FXML file 'signUpWindow.fxml'.";

        initializeBackButton();
        initializeEnterLoginAndPasswordButton();
    }

    private void initializeEnterLoginAndPasswordButton(){
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

                        setCreatedAccountId(AccountService.createAccount(newAccount));

                        try {
                            UiUtil.goToNextWindow(WindowPath.SIGN_UP_ENTER_PERSONAL_WINDOW, event);

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    else {
                        signUpErrorText.setVisible(true);
                        signUpErrorText.setText("Пароли не совпадают!");
                    }
                }
                else {
                    signUpErrorText.setVisible(true);
                    signUpErrorText.setText("Пользователь с таким логином уже существует.");
                }
            }
            else {
                signUpErrorText.setVisible(true);
                signUpErrorText.setText("Введите логин и пароль!");
            }
        });
    }

    public void initializeBackButton(){
        signUpBackButton.setOnAction(event -> {
            try {
                UiUtil.goToNextWindow(WindowPath.SIGN_IN_WINDOW, event);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}



