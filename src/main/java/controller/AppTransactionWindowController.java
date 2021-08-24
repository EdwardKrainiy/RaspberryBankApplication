package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class AppTransactionWindowController {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Text signInErrorText;

    @FXML
    private Text greetingText;

    @FXML
    private Text balanceText;

    @FXML
    private TextField cardNumberField;

    @FXML
    private TextField secureCodeField;

    @FXML
    private Button submitTransactionButton;

    @FXML
    private Button backButton;

    @FXML
    void initialize() {
        assert signInErrorText != null : "fx:id=\"signInErrorText\" was not injected: check your FXML file 'appTransaсtionWindow.fxml'.";
        assert greetingText != null : "fx:id=\"greetingText\" was not injected: check your FXML file 'appTransaсtionWindow.fxml'.";
        assert balanceText != null : "fx:id=\"balanceText\" was not injected: check your FXML file 'appTransaсtionWindow.fxml'.";
        assert cardNumberField != null : "fx:id=\"cardNumberField\" was not injected: check your FXML file 'appTransaсtionWindow.fxml'.";
        assert secureCodeField != null : "fx:id=\"secureCodeField\" was not injected: check your FXML file 'appTransaсtionWindow.fxml'.";
        assert submitTransactionButton != null : "fx:id=\"submitTransactionButton\" was not injected: check your FXML file 'appTransaсtionWindow.fxml'.";
        assert backButton != null : "fx:id=\"backButton\" was not injected: check your FXML file 'appTransaсtionWindow.fxml'.";


    }
}
