package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class signUpEnterPersonalController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField personalDataLastNameField;

    @FXML
    private TextField personalDataFirstNameField;

    @FXML
    private Button signUpNextButton;

    @FXML
    private TextField personalDataPatronymicField;

    @FXML
    private TextField personalDataPhoneNumberField;

    @FXML
    private TextField cardNumber;

    @FXML
    void initialize() {
        assert personalDataLastNameField != null : "fx:id=\"personalDataLastNameField\" was not injected: check your FXML file 'signUpEnterPersonalWindow.fxml'.";
        assert personalDataFirstNameField != null : "fx:id=\"personalDataFirstNameField\" was not injected: check your FXML file 'signUpEnterPersonalWindow.fxml'.";
        assert signUpNextButton != null : "fx:id=\"signUpNextButton\" was not injected: check your FXML file 'signUpEnterPersonalWindow.fxml'.";
        assert personalDataPatronymicField != null : "fx:id=\"personalDataPatronymicField\" was not injected: check your FXML file 'signUpEnterPersonalWindow.fxml'.";
        assert personalDataPhoneNumberField != null : "fx:id=\"personalDataPhoneNumberField\" was not injected: check your FXML file 'signUpEnterPersonalWindow.fxml'.";
        assert cardNumber != null : "fx:id=\"cardNumber\" was not injected: check your FXML file 'signUpEnterPersonalWindow.fxml'.";

    }
}
