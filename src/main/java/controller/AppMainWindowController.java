package controller;

import Util.UiUtil;
import Util.WindowPath;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import service.AccountInfoService;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AppMainWindowController {

    private static String userFirstName;
    private static String userLastName;
    private static int userId;

    public static String getUserFirstName() {
        return userFirstName;
    }

    public static void setUserFirstName(String userFirstName) {
        AppMainWindowController.userFirstName = userFirstName;
    }

    public static String getUserLastName() {
        return userLastName;
    }

    public static void setUserLastName(String userLastName) {
        AppMainWindowController.userLastName = userLastName;
    }

    public static int getUserId() {
        return userId;
    }

    public static void setUserId(int userId) {
        AppMainWindowController.userId = userId;
    }

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button transactionButton;

    @FXML
    private Text signInErrorText;

    @FXML
    private Text greetingText;

    @FXML
    private Button checkBalanceButton;

    @FXML
    private Text balanceText;

    @FXML
    private Button accountRefillingButton;

    @FXML
    private Button exitButton;

    @FXML
    private Button signOutButton;

    @FXML
    void initialize() {
        assert transactionButton != null : "fx:id=\"transactionButton\" was not injected: check your FXML file 'appMainWindow.fxml'.";
        assert signInErrorText != null : "fx:id=\"signInErrorText\" was not injected: check your FXML file 'appMainWindow.fxml'.";
        assert greetingText != null : "fx:id=\"greetingText\" was not injected: check your FXML file 'appMainWindow.fxml'.";
        assert checkBalanceButton != null : "fx:id=\"checkBalanceButton\" was not injected: check your FXML file 'appMainWindow.fxml'.";
        assert balanceText != null : "fx:id=\"balanceText\" was not injected: check your FXML file 'appMainWindow.fxml'.";
        assert accountRefillingButton != null : "fx:id=\"accountRefillingButton\" was not injected: check your FXML file 'appMainWindow.fxml'.";
        assert exitButton != null : "fx:id=\"exitButton\" was not injected: check your FXML file 'appMainWindow.fxml'.";
        assert signOutButton != null : "fx:id=\"signOutButton\" was not injected: check your FXML file 'appMainWindow.fxml'.";

        initializeGreetingText();
        initializeCheckBalanceButton();
        initializeExitButton();
        initializeTransactionButton();
        initializeSignOutButton();
        initializeAccountRefillingButton();
    }

    private void initializeGreetingText(){
        greetingText.setText("Добро пожаловать, " + getUserFirstName() + " " + getUserLastName());
    }

    private void initializeExitButton(){
        exitButton.setOnAction(UiUtil::closeWindow);
        exitButton.setCancelButton(true);
    }

    private void initializeCheckBalanceButton(){
        double userBalance = AccountInfoService.findAccountInfoById(getUserId()).getBalance();
        balanceText.setText("Ваш баланс: " + userBalance);

        checkBalanceButton.setOnAction(event -> {
            UiUtil.createFadeTextAnimation(balanceText, 1, 1.5).playFromStart();
        });
    }

    private void initializeTransactionButton(){
        transactionButton.setOnAction(event -> {
            try {
                UiUtil.goToNextWindow(WindowPath.APP_TRANSACTION_WINDOW, event);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private void initializeSignOutButton(){
        signOutButton.setOnAction(event -> {
            try {
                UiUtil.goToNextWindow(WindowPath.SIGN_IN_WINDOW, event);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
    
    private void initializeAccountRefillingButton(){
        accountRefillingButton.setOnAction(event -> {
            try {
                UiUtil.goToNextWindow(WindowPath.APP_REFILLING_WINDOW, event);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
