package controllers;


import TCPClient.DialogMessage;
import TCPClient.TCPSender;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import Object.*;
import java.net.URL;
import java.util.ResourceBundle;

public class CountByGroupAdminController {
    String command;
    TCPSender sender;
    private ResourceBundle bundleMain;

    CountByGroupAdminController(TCPSender sender, String command, ResourceBundle bundleMain){
        this.sender = sender;
        this.command = command;
        this.bundleMain = bundleMain;
    }

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label mapPersonNameLabel;

    @FXML
    private Label mapPersonHeightLabel;

    @FXML
    private Label mapPersonWeightLabel;

    @FXML
    private Label mapLocationLabel;

    @FXML
    private Label mapLocationNameLabel;

    @FXML
    private TextField nameField;

    @FXML
    private TextField heightField;

    @FXML
    private TextField weightField;

    @FXML
    private TextField xField;

    @FXML
    private TextField yField;

    @FXML
    private TextField zField;

    @FXML
    private TextField nameLocationField;

    @FXML
    private Button okButton;

    @FXML
    private Label answerLabel;

    @FXML
    void initialize() {
        UPDLanguage();
        answerLabel.setMaxWidth(340);
        answerLabel.setWrapText(true);

        String firstExceptionString = bundleMain.getString("incorrectInsert") + "\n";

        okButton.setOnAction(event -> {
            try {
                String makeError = "";

                String personName = nameField.getText();
                if(personName.equals(""))
                    makeError = makeError + bundleMain.getString("field1") + bundleMain.getString("name") + bundleMain.getString("field5") +"\n";
                double height = 0;
                try{
                    height = Double.parseDouble(heightField.getText());
                    if(height <= 0) makeError = makeError + bundleMain.getString("field1") + bundleMain.getString("height")+bundleMain.getString("field2")+bundleMain.getString("field3") +"0. \n";
                }catch (NumberFormatException e){
                    makeError = makeError + bundleMain.getString("field1") + bundleMain.getString("height")+bundleMain.getString("field2")+"double.\n";
                }
                long weight = 0;
                try{
                    weight = Long.parseLong(weightField.getText());
                    if(weight <= 0) makeError = makeError + bundleMain.getString("field1") + bundleMain.getString("weight")+bundleMain.getString("field2")+bundleMain.getString("field3")+"0. \n";
                }catch (NumberFormatException e){
                    makeError = makeError + bundleMain.getString("field1") +bundleMain.getString("weight")+ bundleMain.getString("field2") +"long.\n";
                }
                String locationName = nameLocationField.getText();
                if(locationName.equals(""))
                    makeError = makeError + bundleMain.getString("field1") + bundleMain.getString("locationName") + bundleMain.getString("field5") +"\n";
                double xLocation = 0;
                try{
                    xLocation = Double.parseDouble(xField.getText());
                    if(xLocation <= 0) makeError = makeError + bundleMain.getString("field1") + "x " +bundleMain.getString("field2")+bundleMain.getString("field3") +"0. \n";
                }catch (NumberFormatException e){
                    makeError = makeError + bundleMain.getString("field1") + "x " +bundleMain.getString("field2")+"double.\n";
                }
                long yLocation = 0;
                try{
                    yLocation = Long.parseLong(yField.getText());
                    if(yLocation <= 0) makeError = makeError + bundleMain.getString("field1") + "y "+bundleMain.getString("field2")+bundleMain.getString("field3")+"0. \n";
                }catch (NumberFormatException e){
                    makeError = makeError + bundleMain.getString("field1") + "y " + bundleMain.getString("field2") +"long.\n";
                }
                int zLocation = 0;
                try{
                    zLocation = Integer.parseInt(zField.getText());
                    if(zLocation <= 0) makeError = makeError + bundleMain.getString("field1")+ "z "+bundleMain.getString("field2")+bundleMain.getString("field3")+"0. \n";
                }catch (NumberFormatException e){
                    makeError = makeError + bundleMain.getString("field1")+ "z "+ bundleMain.getString("field2")+"int. \n";
                }
                if(makeError.equals("")) {
                    Person admin = new Person(personName, height, weight, new Location(xLocation, yLocation, zLocation, locationName));
                    sender.sender(command, admin);
                    String answer = (String) sender.getReturnObjects().get(1);
                    answerLabel.setText(answer);
                }
                else{
                    new DialogMessage().warningNewElement(firstExceptionString, makeError);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    void UPDLanguage(){
        mapPersonNameLabel.setText(bundleMain.getString("name")+ ":");
        mapPersonHeightLabel.setText(bundleMain.getString("height")+ ":");
        mapPersonWeightLabel.setText(bundleMain.getString("weight")+ ":");
        mapLocationLabel.setText(bundleMain.getString("location")+ ":");
        mapLocationNameLabel.setText(bundleMain.getString("name")+ ":");
    }
}
