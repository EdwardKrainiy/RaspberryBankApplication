package controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
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
    private Text emptyFieldsText;

    @FXML
    private Text checkPasswordText;

    @FXML
    void initialize() {
        assert signUpLoginField != null : "fx:id=\"signUpLoginField\" was not injected: check your FXML file 'signUpWindow.fxml'.";
        assert signUpNextButton != null : "fx:id=\"signUpNextButton\" was not injected: check your FXML file 'signUpWindow.fxml'.";
        assert signUpPasswordField != null : "fx:id=\"signUpPasswordField\" was not injected: check your FXML file 'signUpWindow.fxml'.";
        assert signUpRepeatPasswordField != null : "fx:id=\"signUpRepeatPasswordField\" was not injected: check your FXML file 'signUpWindow.fxml'.";
        assert loginErrorText != null : "fx:id=\"loginErrorText\" was not injected: check your FXML file 'signUpWindow.fxml'.";
        assert emptyFieldsText != null : "fx:id=\"emptyFieldsText\" was not injected: check your FXML file 'signUpWindow.fxml'.";
        assert checkPasswordText != null : "fx:id=\"checkPasswordText\" was not injected: check your FXML file 'signUpWindow.fxml'.";

        enterLoginAndPassword();
    }
    public void enterLoginAndPassword(){
        signUpNextButton.setOnAction(event -> {
            String loginText = signUpLoginField.getText().trim();
            String passwordText = signUpPasswordField.getText().trim();
            String repeatPasswordText = signUpRepeatPasswordField.getText().trim();

            List<Account> accountList = AccountService.findAllAccounts();

            boolean isLoginExisting = false;

            for(Account a: accountList){
                if(loginText.equals(a.getLogin())){
                    isLoginExisting = true;
                }
            }

            if(!loginText.equals("") && !passwordText.equals("")){
                if(!isLoginExisting){
                    if(repeatPasswordText.equals(passwordText))
                    {
                        Account newAccount = new Account(loginText, passwordText);
                    }
                    else {
                        emptyFieldsText.setVisible(false);
                        loginErrorText.setVisible(false);
                        checkPasswordText.setVisible(true);
                    }
                }
                else {
                    emptyFieldsText.setVisible(false);
                    checkPasswordText.setVisible(false);
                    loginErrorText.setVisible(true);
                }
            }
            else {
                checkPasswordText.setVisible(false);
                loginErrorText.setVisible(false);
                emptyFieldsText.setVisible(true);
            }
        });
    }
}



