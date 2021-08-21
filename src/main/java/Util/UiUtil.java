package Util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class UiUtil {
    public static void goToNextWindow(String FXMLPath, javafx.event.ActionEvent event) throws IOException {

        Parent blah = FXMLLoader.load(UiUtil.class.getResource(FXMLPath));
        Scene scene = new Scene(blah);
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appStage.setScene(scene);
        appStage.show();
    }
}
