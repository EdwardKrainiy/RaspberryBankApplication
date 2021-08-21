package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Util.UiUtil;
import Util.WindowPath;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import service.AccountService;

public class SignUpEnterPersonalController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField personalDataLastNameField;

    @FXML
    private TextField personalDataFirstNameField;

    @FXML
    private TextField personalDataPatronymicField;

    @FXML
    private TextField personalDataPhoneNumberField;

    @FXML
    private TextField cardNumber;

    @FXML
    private Button signUpCompleteButton;

    @FXML
    private Button signUpCancelButton;

    @FXML
    private Text enterPersonalErrorText;

    @FXML
    void initialize() {
        assert personalDataLastNameField != null : "fx:id=\"personalDataLastNameField\" was not injected: check your FXML file 'signUpEnterPersonalWindow.fxml'.";
        assert personalDataFirstNameField != null : "fx:id=\"personalDataFirstNameField\" was not injected: check your FXML file 'signUpEnterPersonalWindow.fxml'.";
        assert personalDataPatronymicField != null : "fx:id=\"personalDataPatronymicField\" was not injected: check your FXML file 'signUpEnterPersonalWindow.fxml'.";
        assert personalDataPhoneNumberField != null : "fx:id=\"personalDataPhoneNumberField\" was not injected: check your FXML file 'signUpEnterPersonalWindow.fxml'.";
        assert cardNumber != null : "fx:id=\"cardNumber\" was not injected: check your FXML file 'signUpEnterPersonalWindow.fxml'.";
        assert signUpCompleteButton != null : "fx:id=\"signUpCompleteButton\" was not injected: check your FXML file 'signUpEnterPersonalWindow.fxml'.";
        assert signUpCancelButton != null : "fx:id=\"signUpCancelButton\" was not injected: check your FXML file 'signUpEnterPersonalWindow.fxml'.";
        assert enterPersonalErrorText != null : "fx:id=\"enterPersonalErrorText\" was not injected: check your FXML file 'signUpEnterPersonalWindow.fxml'.";

        initializeCancelButton();

        signUpCompleteButton.setOnAction(event -> {
            System.out.println("hello");
        });
    }

    private void initializeCancelButton(){
        signUpCancelButton.setOnAction(event -> {
            try {
                UiUtil.goToNextWindow(WindowPath.SIGN_IN_WINDOW, event);
                AccountService.deleteAccount(AccountService.findAccount(SignUpWindowController.getCreatedAccountId()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
