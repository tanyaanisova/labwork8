package controllers;

import TCPClient.DialogMessage;
import TCPClient.TCPSender;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.util.NoSuchElementException;
import java.util.ResourceBundle;
import java.util.TreeMap;
import java.util.TreeSet;

import Object.*;
import javafx.scene.paint.Color;

public class NewElementController {

    private String command;
    private TCPSender sender;
    private TreeSet<StudyGroup> collection;
    private Integer userId;
    private ResourceBundle bundleMain;
    private int idUpdate;
    private boolean fill = false;

    NewElementController(TCPSender sender, String command, TreeSet<StudyGroup> collection, Integer userId, ResourceBundle bundleMain){
        this.sender = sender;
        this.command = command;
        this.collection = collection;
        this.userId = userId;
        this.bundleMain = bundleMain;
    }

    NewElementController(TCPSender sender, String command, TreeSet<StudyGroup> collection, Integer userId, ResourceBundle bundleMain, int idUpdate){
        this.sender = sender;
        this.command = command;
        this.collection = collection;
        this.userId = userId;
        this.bundleMain = bundleMain;
        this.idUpdate = idUpdate;
        fill = true;
    }

        @FXML
        private ResourceBundle resources;

        @FXML
        private URL location;

        @FXML
        private Label keyIdLabel;

        @FXML
        private Label askIdLabel;

        @FXML
        private Label mapNameLabel;

        @FXML
        private Label mapCoordinatesLabel;

        @FXML
        private Label mapStudentsCountLabel;

        @FXML
        private Label mapExpelledStudentsLabel;

        @FXML
        private Label mapAverageMarkLabel;

        @FXML
        private Label mapSemesterLabel;

        @FXML
        private Label mapPersonLabel;

        @FXML
        private Label mapName1Label;

        @FXML
        private Label mapHeightLabel;

        @FXML
        private Label mapWeightLabel;

        @FXML
        private Label mapLocationLabel;

        @FXML
        private TextField keyIdField;

        @FXML
        private Button idButton;

        @FXML
        private TextField nameField;

        @FXML
        private TextField xLabel;

        @FXML
        private TextField yLabel;

        @FXML
        private TextField studentsCountLabel;

        @FXML
        private TextField expelledStudentsLabel;

        @FXML
        private TextField averageMarkLabel;

        @FXML
        private ComboBox<String> semesterBox;

        @FXML
        private TextField namePersonField;

        @FXML
        private TextField heightLabel;

        @FXML
        private TextField weightLabel;

        @FXML
        private TextField xLoactionLabel;

        @FXML
        private TextField yLocationLabel;

        @FXML
        private TextField zLocationLabel;

        @FXML
        private Label mapLocationNameLabel;

        @FXML
        private TextField nameLoactionLabel;

        @FXML
        private Button okButton;


    @FXML
    void initialize() {
        UPDLanguage();
        if (fill) fillFields(idUpdate);
        else keyIdField.setText("");
        semesterBox.getItems().addAll("SECOND",
                "THIRD",
                "FOURTH");
        semesterBox.getSelectionModel().selectFirst();
        switch (command) {
            case "add":
            case "add_if_max":
            case "add_if_min":
                keyIdLabel.setVisible(false);
                keyIdField.setVisible(false);
                askIdLabel.setVisible(false);
                idButton.setVisible(false);
                break;
            case "remove_greater":
                keyIdLabel.setVisible(false);
                keyIdField.setVisible(false);
                askIdLabel.setVisible(false);
                idButton.setVisible(false);
                keyIdField.setText("0");
                break;
            case "update":
                keyIdLabel.setText("Id:");
                keyIdField.setVisible(true);
                askIdLabel.setVisible(true);
                idButton.setVisible(true);
                break;
        }
        String firstExceptionString = bundleMain.getString("incorrectInsert") + "\n";
        String finalIdString = "id";
        idButton.setOnAction(event -> {
            try {
                int id = Integer.parseInt(keyIdField.getText());
                fillFields(id);
            }catch(NumberFormatException e){
                new DialogMessage().warningNewElement(firstExceptionString, bundleMain.getString("field1") + "Id" + bundleMain.getString("field1") +"int. \n");
            }catch (NoSuchElementException e){
                new DialogMessage().warningNewElement(firstExceptionString, bundleMain.getString("noId") +"\n");
            }
        });
        okButton.setOnAction(event -> {
            int keyOrId = 0;
            String name;
            float x = 0;
            long y = 0;
            int studentsCount = 0;
            long expelledStudents = 0;
            float averageMark = 0;
            try {
                String makeError = "";
                if (command.equals("update")) {
                    try {
                        keyOrId = Integer.parseInt(keyIdField.getText());
                    } catch (NumberFormatException e) {
                        makeError = makeError + bundleMain.getString("field1") + finalIdString + bundleMain.getString("field2") + "int \n";
                    }
                }
                name =  nameField.getText();
                if (name.equals(""))
                    makeError = makeError + bundleMain.getString("field1") + bundleMain.getString("name")+bundleMain.getString("field5")+"\n";
                try {
                    x = Float.parseFloat(xLabel.getText());
                }catch(NumberFormatException e){
                    makeError  = makeError + bundleMain.getString("field1") + "x"+bundleMain.getString("field2")+"float. \n";
                }
                try {
                    y = Long.parseLong(yLabel.getText());
                }catch (NumberFormatException e){
                    makeError = makeError + bundleMain.getString("field1") + "y"+bundleMain.getString("field2")+"long. \n";
                }
                ZonedDateTime zonedDateTime = ZonedDateTime.now();
                try{
                    studentsCount = Integer.parseInt(studentsCountLabel.getText());
                    if(studentsCount <= 0) makeError = makeError + bundleMain.getString("field1")+bundleMain.getString("studentsCount")+bundleMain.getString("field2")+bundleMain.getString("field3")+"0. \n";
                }catch (NumberFormatException e){
                    makeError = makeError + bundleMain.getString("field1")+bundleMain.getString("studentsCount")+bundleMain.getString("field2")+"int. \n";
                }
                try{
                    expelledStudents = Long.parseLong(expelledStudentsLabel.getText());
                    if (expelledStudents <= 0) makeError = makeError + bundleMain.getString("field1") + bundleMain.getString("expelledStudents")+bundleMain.getString("field2")+bundleMain.getString("field3")+"0. \n";
                }catch(NumberFormatException e){
                    makeError = makeError + bundleMain.getString("field1") + bundleMain.getString("expelledStudents")+ bundleMain.getString("field2") +"long. \n";
                }
                try{
                    averageMark = Float.parseFloat(expelledStudentsLabel.getText());
                    if (averageMark <= 0) makeError = makeError + bundleMain.getString("field1") + bundleMain.getString("averageMark")+bundleMain.getString("field2")+bundleMain.getString("field3")+"0. \n";
                }catch(NumberFormatException e){
                    makeError = makeError + bundleMain.getString("field1") + bundleMain.getString("averageMark")+ bundleMain.getString("field2") +"float. \n";
                }
                String personName = nameField.getText();
                if(personName.equals(""))
                    makeError = makeError + bundleMain.getString("field1") + bundleMain.getString("name") + bundleMain.getString("field5") +"\n";
                double height = 0;
                try{
                    height = Double.parseDouble(heightLabel.getText());
                    if(height <= 0) makeError = makeError + bundleMain.getString("field1") + bundleMain.getString("height")+bundleMain.getString("field2")+bundleMain.getString("field3") +"0. \n";
                }catch (NumberFormatException e){
                    makeError = makeError + bundleMain.getString("field1") + bundleMain.getString("height")+bundleMain.getString("field2")+"double.\n";
                }
                long weight = 0;
                try{
                    weight = Long.parseLong(weightLabel.getText());
                    if(weight <= 0) makeError = makeError + bundleMain.getString("field1") + bundleMain.getString("weight")+bundleMain.getString("field2")+bundleMain.getString("field3")+"0. \n";
                }catch (NumberFormatException e){
                    makeError = makeError + bundleMain.getString("field1") +bundleMain.getString("weight")+ bundleMain.getString("field2") +"long.\n";
                }
                String locationName = nameLoactionLabel.getText();
                if(locationName.equals(""))
                    makeError = makeError + bundleMain.getString("field1") + bundleMain.getString("locationName") + bundleMain.getString("field5") +"\n";
                double xLocation = 0;
                try{
                    xLocation = Double.parseDouble(xLoactionLabel.getText());
                    if(xLocation <= 0) makeError = makeError + bundleMain.getString("field1") + "x " +bundleMain.getString("field2")+bundleMain.getString("field3") +"0. \n";
                }catch (NumberFormatException e){
                    makeError = makeError + bundleMain.getString("field1") + "x " +bundleMain.getString("field2")+"double.\n";
                }
                long yLocation = 0;
                try{
                    yLocation = Long.parseLong(yLocationLabel.getText());
                    if(yLocation <= 0) makeError = makeError + bundleMain.getString("field1") + "y "+bundleMain.getString("field2")+bundleMain.getString("field3")+"0. \n";
                }catch (NumberFormatException e){
                    makeError = makeError + bundleMain.getString("field1") + "y " + bundleMain.getString("field2") +"long.\n";
                }
                int zLocation = 0;
                try{
                    zLocation = Integer.parseInt(zLocationLabel.getText());
                    if(zLocation <= 0) makeError = makeError + bundleMain.getString("field1")+ "z "+bundleMain.getString("field2")+bundleMain.getString("field3")+"0. \n";
                }catch (NumberFormatException e){
                    makeError = makeError + bundleMain.getString("field1")+ "z "+ bundleMain.getString("field2")+"int. \n";
                }
                if(makeError.equals("")) {
                    StudyGroup group = new StudyGroup(0, name, new Coordinates(x, y), zonedDateTime, studentsCount, expelledStudents, averageMark,
                            Semester.valueOf(semesterBox.getSelectionModel().getSelectedItem()),
                            new Person(personName, height, weight, new Location(xLocation, yLocation, zLocation, locationName)), userId, Color.BLACK.toString());
                    if (command.equals("update")) {
                        sender.sender(command + " " + keyOrId, group);
                    }
                    else sender.sender(command, group);
                    String answer = (String) sender.getReturnObjects().get(1);
                    new DialogMessage().info(answer);
                }
                else{
                    new DialogMessage().warningNewElement(firstExceptionString, makeError);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }


    private void fillFields(int id) {
        System.out.println(id);
        keyIdField.setText("" + id);
        StudyGroup idGroup = collection.stream().filter(group -> group.getId() == id).peek(flat -> System.out.println(flat.getId())).findFirst().get();
        nameField.setText(idGroup.getName());
        xLabel.setText(idGroup.getCoordinates().getX()+"");
        yLabel.setText(idGroup.getCoordinates().getY()+"");
        studentsCountLabel.setText(idGroup.getStudentsCount() + "");
        expelledStudentsLabel.setText(idGroup.getExpelledStudents() + "");
        averageMarkLabel.setText(idGroup.getAverageMark() + "");
        semesterBox.getSelectionModel().select(idGroup.getSemesterEnum().toString());
        namePersonField.setText(idGroup.getGroupAdmin().getName());
        heightLabel.setText(idGroup.getGroupAdmin().getHeight() + "");
        weightLabel.setText(idGroup.getGroupAdmin().getWeight() + "");
        xLoactionLabel.setText(idGroup.getGroupAdmin().getLocation().getX()+"");
        yLocationLabel.setText(idGroup.getGroupAdmin().getLocation().getY()+"");
        zLocationLabel.setText(idGroup.getGroupAdmin().getLocation().getZ()+"");
        nameLoactionLabel.setText(idGroup.getGroupAdmin().getLocation().getName());
    }
    void UPDLanguage(){
        mapNameLabel.setText(bundleMain.getString("name")+ ":");
        mapCoordinatesLabel.setText(bundleMain.getString("coordinates")+ ":");
        mapStudentsCountLabel.setText(bundleMain.getString("studentsCount")+ ":");
        mapExpelledStudentsLabel.setText(bundleMain.getString("expelledStudents")+ ":");
        mapAverageMarkLabel.setText(bundleMain.getString("averageMark")+ ":");
        mapSemesterLabel.setText(bundleMain.getString("semester")+ ":");
        mapPersonLabel.setText(bundleMain.getString("person")+ ":");
        mapName1Label.setText(bundleMain.getString("name")+ ":");
        mapHeightLabel.setText(bundleMain.getString("height")+ ":");
        mapWeightLabel.setText(bundleMain.getString("weight")+ ":");
        mapLocationLabel.setText(bundleMain.getString("location")+ ":");
        mapLocationNameLabel.setText(bundleMain.getString("name")+ ":");
        askIdLabel.setText(bundleMain.getString("question"));
        idButton.setText(bundleMain.getString("yes"));
    }
}