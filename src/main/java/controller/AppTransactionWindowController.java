package controller;

import Util.UiUtil;
import Util.WindowPath;
import dao.AccountInfoRepository;
import dao.CardRepository;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import model.Account;
import model.AccountInfo;
import model.Card;
import service.AccountInfoService;
import service.AccountService;
import service.CardService;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AppTransactionWindowController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField transferAmountField;

    @FXML
    private Text signInErrorText;

    @FXML
    private Text greetingText;

    @FXML
    private Text balanceText;

    @FXML
    private TextField recipientLoginField;

    @FXML
    private TextField secureCodeField;

    @FXML
    private Button submitTransactionButton;

    @FXML
    private Text errorText;

    @FXML
    private Button backButton;

    @FXML
    void initialize() {
        assert transferAmountField != null : "fx:id=\"transferAmountField\" was not injected: check your FXML file 'appTransaсtionWindow.fxml'.";
        assert signInErrorText != null : "fx:id=\"signInErrorText\" was not injected: check your FXML file 'appTransaсtionWindow.fxml'.";
        assert greetingText != null : "fx:id=\"greetingText\" was not injected: check your FXML file 'appTransaсtionWindow.fxml'.";
        assert balanceText != null : "fx:id=\"balanceText\" was not injected: check your FXML file 'appTransaсtionWindow.fxml'.";
        assert recipientLoginField != null : "fx:id=\"recipientLoginField\" was not injected: check your FXML file 'appTransaсtionWindow.fxml'.";
        assert secureCodeField != null : "fx:id=\"secureCodeField\" was not injected: check your FXML file 'appTransaсtionWindow.fxml'.";
        assert submitTransactionButton != null : "fx:id=\"submitTransactionButton\" was not injected: check your FXML file 'appTransaсtionWindow.fxml'.";
        assert errorText != null : "fx:id=\"errorText\" was not injected: check your FXML file 'appTransaсtionWindow.fxml'.";
        assert backButton != null : "fx:id=\"backButton\" was not injected: check your FXML file 'appTransaсtionWindow.fxml'.";

        initializeBackButton();
        initializeSubmitTransactionButton();
    }

    private void initializeBackButton(){
        backButton.setOnAction(event -> {
            try {
                UiUtil.goToNextWindow(WindowPath.APP_MAIN_WINDOW, event);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private void initializeSubmitTransactionButton(){
        submitTransactionButton.setOnAction(event -> {

        String recipientLogin = recipientLoginField.getText();
        String secureCode = secureCodeField.getText();

        AccountInfo userAccountInfo = new AccountInfoRepository().findById(AppMainWindowController.getUserId());
        Account recipientAccount = AccountService.findByLogin(recipientLogin);

        boolean isRecipientAccountExists = recipientAccount != null;

        double transferAmount;
        double userBalance = userAccountInfo.getBalance();

        if(!recipientLogin.equals("")){

            if(isRecipientAccountExists){

                int recipientAccountId = recipientAccount.getId();
                AccountInfo recipientAccountInfo = AccountInfoService.findAccountInfoById(recipientAccountId);
                Card recipientCard = CardService.findCardByAccountId(recipientAccountInfo.getAccountId());

                if(!secureCode.equals("")){
                    if(secureCode.equals(recipientCard.getSecureCode())){
                        if (transferAmountField.getText().matches("\\d+(?:\\.\\d+)?")) {
                            transferAmount = Double.parseDouble(transferAmountField.getText());
                            if(!(userBalance - transferAmount < 0)){
                                AccountInfoService accountInfoService = new AccountInfoService();
                                recipientAccountInfo.setBalance(recipientAccountInfo.getBalance() + transferAmount);
                                userAccountInfo.setBalance(userAccountInfo.getBalance() - transferAmount);
                                accountInfoService.updateAccountInfo(recipientAccountInfo);
                                accountInfoService.updateAccountInfo(userAccountInfo);
                            }
                            else{
                                errorText.setText("Недостаточно средств!");
                                errorText.setVisible(true);
                                transferAmountField.setText("");
                            }
                        } else {
                            errorText.setText("Некорректное значение в поле 'Сумма перевода'!");
                            errorText.setVisible(true);
                            transferAmountField.setText("");
                        }
                    }
                    else{
                        errorText.setText("CVV-код получателя введен неверно!");
                        errorText.setVisible(true);
                    }
                }
                else{
                    errorText.setText("Введите CVV-код!");
                    errorText.setVisible(true);
                }
            }
            else{
                errorText.setText("Логин получателя введен неверно!");
                errorText.setVisible(true);
                recipientLoginField.setText("");
                System.out.println("Hello");
            }
        }
        else{
            errorText.setText("Введите логин!");
            errorText.setVisible(true);
        }
    });
    }
}
