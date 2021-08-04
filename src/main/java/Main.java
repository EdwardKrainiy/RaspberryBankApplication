import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.PersonEntity;
import org.hibernate.Session;
import utils.HibernateSessionFactory;

import java.sql.*;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        String fxmlFile = "/fxml/sample.fxml";
        FXMLLoader loader = new FXMLLoader();
        Parent root = loader.load(getClass().getResourceAsStream(fxmlFile));
        primaryStage.setTitle("BankApplication");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
        System.out.println("Hibernate tutorial");

        Session session = HibernateSessionFactory.getSessionFactory().openSession();

        session.beginTransaction();

        PersonEntity personEntity = new PersonEntity();

        personEntity.setFirstname("Nick");
        personEntity.setSecondname("VN");
        personEntity.setSurname("Bruh");
        personEntity.setCardNumber("112");
        personEntity.setPhoneNumber("333333");

        session.save(personEntity);
        session.getTransaction().commit();

        session.close();
    }
}
