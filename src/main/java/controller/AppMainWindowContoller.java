package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class AppMainWindowContoller {
    private static String userLogin;

    public static String getUserLogin() {
        return userLogin;
    }

    public static void setUserLogin(String userLogin) {
        AppMainWindowContoller.userLogin = userLogin;
    }

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Text signInErrorText;

    @FXML
    private Text greetingText;

    @FXML
    private Button exitButton;

    @FXML
    void initialize() {
        assert signInErrorText != null : "fx:id=\"signInErrorText\" was not injected: check your FXML file 'appMainWindow.fxml'.";
        assert greetingText != null : "fx:id=\"greetingText\" was not injected: check your FXML file 'appMainWindow.fxml'.";
        assert exitButton != null : "fx:id=\"exitButton\" was not injected: check your FXML file 'appMainWindow.fxml'.";

        initializeLoginText();
    }

    private void initializeLoginText(){
        greetingText.setText("Добро пожаловать, " + userLogin);
    }
}
