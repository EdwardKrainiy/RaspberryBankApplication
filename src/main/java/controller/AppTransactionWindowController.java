package controller;

import Util.UiUtil;
import Util.WindowPath;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

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

        double transferAmount;
        if(transferAmountField.getText().matches("\\d+\\.\\d+")){
            transferAmount = Double.parseDouble(transferAmountField.getText());
        }
        else{
            errorText.setText("Некорректное значение в поле 'Сумма перевода'!");
            errorText.setVisible(true);
            transferAmountField.setText("");
        }
    });
    }
}
