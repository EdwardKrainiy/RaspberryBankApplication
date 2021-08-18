import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        String fxmlFile = "/fxml/signInWindow.fxml";
        FXMLLoader loader = new FXMLLoader();
        Parent root = loader.load(getClass().getResourceAsStream(fxmlFile));
        primaryStage.setTitle("BankApplication");
        primaryStage.setScene(new Scene(root, 700, 500));
        primaryStage.show();
    }

    public static void main(String[] args){
        launch(args);
    }
}
