package controllers;

import TCPClient.TCPSender;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicReference;

public class RemoveByIdController {
    TCPSender sender;
    String command;
    private ResourceBundle bundleMain;

    RemoveByIdController(TCPSender sender, String command, ResourceBundle bundleMain){
        this.sender = sender;
        this.command = command;
        this.bundleMain = bundleMain;
    }

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField idField;

    @FXML
    private Button okButton;

    @FXML
    private Label answerLabel;

    @FXML
    void initialize() {
        answerLabel.setMaxWidth(340);
        answerLabel.setWrapText(true);
        okButton.setOnAction(event -> {
            try {
                sender.sender(command, Integer.parseInt(idField.getText()));
                String answer = (String) sender.getReturnObjects().get(1);
                answerLabel.setText(answer);
            } catch (NumberFormatException|NullPointerException ex) {
                answerLabel.setText(bundleMain.getString("field1") + bundleMain.getString("field2") + "Integer");
            }
        });
    }
}
