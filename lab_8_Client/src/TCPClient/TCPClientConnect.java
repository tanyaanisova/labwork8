package TCPClient;

import controllers.EnterController;
import controllers.HostAndPortWindowController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

//TODO: languages

/**
 * Класс для подключения к серверу
 */
public class TCPClientConnect extends Application {
    private static String host;
    private static int port;

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../Resources/views/hostAnPortWindow.fxml"));
        loader.setController(new HostAndPortWindowController());
        loader.load();
        Parent root = loader.getRoot();
        primaryStage.setTitle("Connection");
        primaryStage.setScene(new Scene(root, 483, 326));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        //initialization();
        launch(args);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> System.out.println("Работа программы завершена!")));
    }
}

