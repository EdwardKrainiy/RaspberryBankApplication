package controller;

import Util.UiUtil;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;

public class AppMainWindowContoller {
    private static String userFirstName;
    private static String userLastName;

    public static String getUserFirstName() {
        return userFirstName;
    }

    public static void setUserFirstName(String userFirstName) {
        AppMainWindowContoller.userFirstName = userFirstName;
    }

    public static String getUserLastName() {
        return userLastName;
    }

    public static void setUserLastName(String userLastName) {
        AppMainWindowContoller.userLastName = userLastName;
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

        initializeGreetingText();
        initializeExitButton();
    }

    private void initializeGreetingText(){
        greetingText.setText("Добро пожаловать, " + getUserFirstName() + " " + getUserLastName());
    }

    private void initializeExitButton(){
        exitButton.setOnAction(UiUtil::closeWindow);
    }
}
