package Util;

import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.Objects;

public class UiUtil {
    public static void goToNextWindow(String FXMLPath, ActionEvent event) throws IOException {
        Parent blah = FXMLLoader.load(Objects.requireNonNull(UiUtil.class.getResource(FXMLPath)));
        Scene scene = new Scene(blah);
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appStage.setScene(scene);
        appStage.show();
    }

    public static void closeWindow(ActionEvent event){
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    public static Animation createFadeTextAnimation(Text text, double fadeDuration, double pauseDuration){
        FadeTransition fadeTrans = new FadeTransition(Duration.seconds(fadeDuration));
        fadeTrans.setFromValue(0);
        fadeTrans.setToValue(1);

        PauseTransition pauseTrans = new PauseTransition(Duration.seconds(pauseDuration));

        SequentialTransition seqTrans = new SequentialTransition(text, fadeTrans, pauseTrans);
        seqTrans.setAutoReverse(true);

        seqTrans.setCycleCount(2);

        return seqTrans;
    }
}
