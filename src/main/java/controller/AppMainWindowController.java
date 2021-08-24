package controller;

import Util.UiUtil;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import service.AccountInfoService;

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
    private Button exitButton;

    @FXML
    void initialize() {
        assert transactionButton != null : "fx:id=\"transactionButton\" was not injected: check your FXML file 'appMainWindow.fxml'.";
        assert signInErrorText != null : "fx:id=\"signInErrorText\" was not injected: check your FXML file 'appMainWindow.fxml'.";
        assert greetingText != null : "fx:id=\"greetingText\" was not injected: check your FXML file 'appMainWindow.fxml'.";
        assert checkBalanceButton != null : "fx:id=\"checkBalanceButton\" was not injected: check your FXML file 'appMainWindow.fxml'.";
        assert balanceText != null : "fx:id=\"balanceText\" was not injected: check your FXML file 'appMainWindow.fxml'.";
        assert exitButton != null : "fx:id=\"exitButton\" was not injected: check your FXML file 'appMainWindow.fxml'.";

        initializeGreetingText();
        initializeExitButton();
        initializeCheckBalanceButton();
    }

    private void initializeGreetingText(){
        greetingText.setText("Добро пожаловать, " + getUserFirstName() + " " + getUserLastName());
    }

    private void initializeExitButton(){
        exitButton.setOnAction(UiUtil::closeWindow);
        exitButton.setCancelButton(true);
    }

    private void initializeCheckBalanceButton(){
        int userBalance = AccountInfoService.findAccountInfoById(getUserId()).getBalance();
        balanceText.setText("Ваш баланс: " + userBalance);

        checkBalanceButton.setOnAction(event -> {
            UiUtil.createFadeTextAnimation(balanceText, 1, 1.5).playFromStart();
        });
    }
}
