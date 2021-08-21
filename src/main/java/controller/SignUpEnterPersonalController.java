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
import model.AccountInfo;
import model.Card;
import service.AccountInfoService;
import service.AccountService;
import service.CardService;

public class SignUpEnterPersonalController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField lastNameField;

    @FXML
    private TextField firstNameField;

    @FXML
    private TextField patronymicField;

    @FXML
    private TextField phoneNumberField;

    @FXML
    private TextField cardNumberField;

    @FXML
    private TextField secureCodeField;

    @FXML
    private Button signUpCompleteButton;

    @FXML
    private Button signUpCancelButton;

    @FXML
    private Text enterPersonalErrorText;

    @FXML
    void initialize() {
        assert lastNameField != null : "fx:id=\"lastNameField\" was not injected: check your FXML file 'signUpEnterPersonalWindow.fxml'.";
        assert firstNameField != null : "fx:id=\"FirstNameField\" was not injected: check your FXML file 'signUpEnterPersonalWindow.fxml'.";
        assert patronymicField != null : "fx:id=\"patronymicField\" was not injected: check your FXML file 'signUpEnterPersonalWindow.fxml'.";
        assert phoneNumberField != null : "fx:id=\"phoneNumberField\" was not injected: check your FXML file 'signUpEnterPersonalWindow.fxml'.";
        assert cardNumberField != null : "fx:id=\"cardNumberField\" was not injected: check your FXML file 'signUpEnterPersonalWindow.fxml'.";
        assert secureCodeField != null : "fx:id=\"secureCodeField\" was not injected: check your FXML file 'signUpEnterPersonalWindow.fxml'.";
        assert signUpCompleteButton != null : "fx:id=\"signUpCompleteButton\" was not injected: check your FXML file 'signUpEnterPersonalWindow.fxml'.";
        assert signUpCancelButton != null : "fx:id=\"signUpCancelButton\" was not injected: check your FXML file 'signUpEnterPersonalWindow.fxml'.";
        assert enterPersonalErrorText != null : "fx:id=\"enterPersonalErrorText\" was not injected: check your FXML file 'signUpEnterPersonalWindow.fxml'.";

        initializeCancelButton();
        initializeSignUpButton();
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

    private void initializeSignUpButton(){
        signUpCompleteButton.setOnAction(event -> {
            String firstName = firstNameField.getText();
            String lastName = lastNameField.getText();
            String patronymic = patronymicField.getText();
            String phoneNumber = phoneNumberField.getText();
            String cardNumber = cardNumberField.getText();
            String secureCode = secureCodeField.getText();

            if(!firstName.equals("")){
                if(!lastName.equals("")){
                    if(!cardNumber.equals("")){
                        if(!secureCode.equals("")){
                            AccountInfo newAccountInfo = new AccountInfo(SignUpWindowController.getCreatedAccountId(), firstName, lastName, patronymic, phoneNumber, 0);
                            AccountInfoService.saveAccountInfo(newAccountInfo);

                            Card newCard = new Card(SignUpWindowController.getCreatedAccountId(), cardNumber, secureCode);
                            CardService.saveCard(newCard);
                        }
                        else {
                            enterPersonalErrorText.setVisible(true);
                            enterPersonalErrorText.setText("Введите CVV-код!");
                        }
                    }
                    else {
                        enterPersonalErrorText.setVisible(true);
                        enterPersonalErrorText.setText("Введите номер карты!");
                    }
                }
                else{
                    enterPersonalErrorText.setVisible(true);
                    enterPersonalErrorText.setText("Введите фамилию!");
                }
            }
            else{
                enterPersonalErrorText.setVisible(true);
                enterPersonalErrorText.setText("Введите имя!");
            }
        });
    }
}
