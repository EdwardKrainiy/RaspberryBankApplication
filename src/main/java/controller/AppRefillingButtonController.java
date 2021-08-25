package controller;

import utils.UiUtil;
import utils.WindowPath;
import dao.AccountInfoRepository;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import model.AccountInfo;
import service.AccountInfoService;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AppRefillingButtonController {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Text signInErrorText;

    @FXML
    private Text refillingWindowText;

    @FXML
    private TextField refillingAmountField;

    @FXML
    private Button submitRefillingButton;

    @FXML
    private Text errorText;

    @FXML
    private Text sucessfulText;

    @FXML
    private Button backButton;

    public AppRefillingButtonController() {
    }

    @FXML
    void initialize() {
        assert signInErrorText != null : "fx:id=\"signInErrorText\" was not injected: check your FXML file 'appRefillingWindow.fxml'.";
        assert refillingWindowText != null : "fx:id=\"refillingWindowText\" was not injected: check your FXML file 'appRefillingWindow.fxml'.";
        assert refillingAmountField != null : "fx:id=\"refillingAmountField\" was not injected: check your FXML file 'appRefillingWindow.fxml'.";
        assert submitRefillingButton != null : "fx:id=\"submitRefillingButton\" was not injected: check your FXML file 'appRefillingWindow.fxml'.";
        assert errorText != null : "fx:id=\"errorText\" was not injected: check your FXML file 'appRefillingWindow.fxml'.";
        assert sucessfulText != null : "fx:id=\"sucessfulText\" was not injected: check your FXML file 'appRefillingWindow.fxml'.";
        assert backButton != null : "fx:id=\"backButton\" was not injected: check your FXML file 'appRefillingWindow.fxml'.";

        initializeSubmitRefillingButton();
        initializeBackButton();
    }

    private void initializeSubmitRefillingButton(){
        submitRefillingButton.setDefaultButton(true);
        submitRefillingButton.setOnAction(event -> {

            AccountInfo userAccountInfo = new AccountInfoRepository().findById(AppMainWindowController.getUserId());

            String refillingAmount = refillingAmountField.getText();
            if(!refillingAmount.equals("")){
                if(refillingAmount.matches("\\d+(?:\\.\\d+)?")){
                    userAccountInfo.setBalance(userAccountInfo.getBalance() + Double.parseDouble(refillingAmount));

                    AccountInfoService accountInfoService = new AccountInfoService();
                    accountInfoService.updateAccountInfo(userAccountInfo);

                    errorText.setVisible(false);
                    UiUtil.createFadeTextAnimation(sucessfulText, 1, 1.5).playFromStart();
                }
                else{
                    errorText.setVisible(true);
                    errorText.setText("Введите корректную сумму для пополнения!");
                }
            }
        });
    }

    private void initializeBackButton(){
        backButton.setCancelButton(true);
        backButton.setOnAction(event -> {
            try {
                UiUtil.goToNextWindow(WindowPath.APP_MAIN_WINDOW, event);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
