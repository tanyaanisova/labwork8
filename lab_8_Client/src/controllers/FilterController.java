package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import Object.*;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.TreeMap;

public class FilterController {

    private Filter filter;
    private ResourceBundle bundleMain;

    FilterController(Filter filter, ResourceBundle bundleMain) {
        this.filter = filter;
        this.bundleMain = bundleMain;
    }

    @FXML
    private ResourceBundle resources;

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
    private Label mapHeightLabel;

    @FXML
    private Label mapWeightLabel;

    @FXML
    private Label mapLocationLabel;

    @FXML
    private Text from;

    @FXML
    private TextField idFromfield;

    @FXML
    private Text to1;

    @FXML
    private TextField idToField;

    @FXML
    private Text from1;

    @FXML
    private TextField xFromField;

    @FXML
    private Text to2;

    @FXML
    private TextField xToField;

    @FXML
    private Text from2;

    @FXML
    private TextField yFromField;

    @FXML
    private Text to3;

    @FXML
    private TextField yToField;

    @FXML
    private Text from3;

    @FXML
    private TextField studentsCountFromField;

    @FXML
    private Text to4;

    @FXML
    private TextField studentsCountToField;

    @FXML
    private Text from4;

    @FXML
    private TextField expelledStudentsFromField;

    @FXML
    private Text to5;

    @FXML
    private TextField expelledStudentsToField;

    @FXML
    private Text from5;

    @FXML
    private TextField averageMarkFromField;

    @FXML
    private Text to6;

    @FXML
    private TextField averageMarkToField;

    @FXML
    private ComboBox<String> semesterBox;

    @FXML
    private Text from6;

    @FXML
    private TextField heightFromField;

    @FXML
    private Text to7;

    @FXML
    private TextField heightToField;

    @FXML
    private Text from7;

    @FXML
    private TextField weightFromfield;

    @FXML
    private Text to8;

    @FXML
    private TextField weightToField;

    @FXML
    private Text from8;

    @FXML
    private TextField xLocationFromField;

    @FXML
    private Text to9;

    @FXML
    private TextField xLocationToField;

    @FXML
    private Text from9;

    @FXML
    private TextField yLocationFromField;

    @FXML
    private Text to10;

    @FXML
    private TextField yLocationToField;

    @FXML
    private Text from10;

    @FXML
    private TextField zLocationFromField;

    @FXML
    private Text to;

    @FXML
    private TextField zLocationToField;

    @FXML
    private CheckBox elementsCheckBox;

    @FXML
    private Button applyButton;

    @FXML
    private Button clearButton;

    @FXML
    void initialize() {
        UPDLanguage();
        semesterBox.getItems().addAll("all",
                "SECOND",
                "THIRD",
                "FOURTH");
        semesterBox.getSelectionModel().selectFirst();

        if(filter.getIdFrom() != null)idFromfield.setText(filter.getIdFrom().toString());
        if(filter.getIdTo() != null)idToField.setText(filter.getIdTo().toString());
        if(filter.getxFrom() != null)xFromField.setText(filter.getxFrom().toString());
        if(filter.getxTo() != null)xToField.setText(filter.getxTo().toString());
        if(filter.getyFrom() != null)yFromField.setText(filter.getyFrom().toString());
        if(filter.getyTo() != null)yToField.setText(filter.getyTo().toString());
        if(filter.getStudentsCountFrom() != null)studentsCountFromField.setText(filter.getStudentsCountFrom().toString());
        if(filter.getStudentsCountTo() != null)studentsCountToField.setText(filter.getStudentsCountTo().toString());
        if(filter.getExpelledStudentsFrom() != null)expelledStudentsFromField.setText(filter.getExpelledStudentsFrom().toString());
        if(filter.getExpelledStudentsTo()!= null)expelledStudentsToField.setText(filter.getExpelledStudentsTo().toString());
        if(filter.getAverageMarkFrom() != null)averageMarkFromField.setText(filter.getAverageMarkFrom().toString());
        if(filter.getAverageMarkTo()!= null)averageMarkToField.setText(filter.getAverageMarkTo().toString());
        semesterBox.getSelectionModel().select(filter.getSemester());
        if(filter.getHeightFrom() != null)heightFromField.setText(filter.getHeightFrom().toString());
        if(filter.getHeightTo() != null)heightToField.setText(filter.getHeightTo().toString());
        if(filter.getWeightFrom() != null)weightFromfield.setText(filter.getWeightFrom().toString());
        if(filter.getWeightTo() != null)weightToField.setText(filter.getWeightTo().toString());
        if(filter.getLocalXFrom() != null)xLocationFromField.setText(filter.getLocalXFrom().toString());
        if(filter.getLocalXTo()!= null)xLocationToField.setText(filter.getLocalXTo().toString());
        if(filter.getLocalYFrom() != null)yLocationFromField.setText(filter.getLocalYFrom().toString());
        if(filter.getLocalYTo()!= null)yLocationToField.setText(filter.getLocalYTo().toString());
        if(filter.getLocalZFrom() != null)zLocationFromField.setText(filter.getLocalZFrom().toString());
        if(filter.getLocalZTo()!= null)zLocationToField.setText(filter.getLocalZTo().toString());
        elementsCheckBox.setSelected(filter.isShowOnlyMyElement());

        //clearField();
        clearButton.setOnAction(event -> {
            clearField();
        });


        applyButton.setOnAction(event -> {
            filter.clearVars();
            try {
                filter.setIdFrom(Integer.parseInt(idFromfield.getText()));
            } catch(NumberFormatException e) {}
            try {
                filter.setIdTo(Integer.parseInt(idToField.getText()));
            } catch(NumberFormatException e) {}
            try {
                filter.setxFrom(Float.parseFloat(xFromField.getText()));
            } catch(NumberFormatException e) {}
            try {
                filter.setxTo(Float.parseFloat(xToField.getText()));
            } catch(NumberFormatException e) {}
            try {
                filter.setyFrom(Long.parseLong(yFromField.getText()));
            } catch(NumberFormatException e) {}
            try {
                filter.setyTo(Long.parseLong(yToField.getText()));
            } catch(NumberFormatException e) {}
            try {
                filter.setStudentsCountFrom(Integer.parseInt(studentsCountFromField.getText()));
            } catch(NumberFormatException e) {}
            try {
                filter.setStudentsCountTo(Integer.parseInt(studentsCountToField.getText()));
            } catch(NumberFormatException e) {}
            try {
                filter.setExpelledStudentsFrom(Long.parseLong(expelledStudentsFromField.getText()));
            } catch(NumberFormatException e) {}
            try {
                filter.setExpelledStudentsTo(Long.parseLong(expelledStudentsToField.getText()));
            } catch(NumberFormatException e) {}
            try {
                filter.setAverageMarkFrom(Float.parseFloat(averageMarkFromField.getText()));
            } catch(NumberFormatException e) {}
            try {
                filter.setAverageMarkTo(Float.parseFloat(averageMarkToField.getText()));
            } catch(NumberFormatException e) {}
            try {
                filter.setHeightFrom(Double.parseDouble(heightFromField.getText()));
            } catch(NumberFormatException e) {}
            try {
                filter.setHeightTo(Double.parseDouble(heightToField.getText()));
            } catch(NumberFormatException e) {}
            try {
                filter.setWeightFrom(Long.parseLong(weightFromfield.getText()));
            } catch(NumberFormatException e) {}
            try {
                filter.setWeightTo(Long.parseLong(weightToField.getText()));
            } catch(NumberFormatException e) {}
            try {
                filter.setLocalXFrom(Double.parseDouble(xLocationFromField.getText()));
            } catch(NumberFormatException e) {}
            try {
                filter.setLocalXTo(Double.parseDouble(xLocationToField.getText()));
            } catch(NumberFormatException e) {}
            try {
                filter.setLocalYFrom(Long.parseLong(yLocationFromField.getText()));
            } catch(NumberFormatException e) {}
            try {
                filter.setLocalYTo(Long.parseLong(yLocationToField.getText()));
            } catch(NumberFormatException e) {}
            try {
                filter.setLocalZFrom(Integer.parseInt(zLocationFromField.getText()));
            } catch(NumberFormatException e) {}
            try {
                filter.setLocalZTo(Integer.parseInt(zLocationToField.getText()));
            } catch(NumberFormatException e) {}
            filter.setShowOnlyMyElement(elementsCheckBox.isSelected());
            if (!semesterBox.getSelectionModel().getSelectedItem().equals("all"))
                filter.setSemester(semesterBox.getSelectionModel().getSelectedItem());
        });
    }

    public void clearField() {
        filter.clearVars();
        idToField.setText("");
        idFromfield.setText("");
        xToField.setText("");
        xFromField.setText("");
        yFromField.setText("");
        yToField.setText("");
        studentsCountFromField.setText("");
        studentsCountToField.setText("");
        expelledStudentsFromField.setText("");
        expelledStudentsToField.setText("");
        averageMarkFromField.setText("");
        averageMarkToField.setText("");
        heightFromField.setText("");
        heightToField.setText("");
        weightFromfield.setText("");
        weightToField.setText("");
        xLocationFromField.setText("");
        xLocationToField.setText("");
        yLocationFromField.setText("");
        yLocationToField.setText("");
        zLocationFromField.setText("");
        zLocationToField.setText("");
        elementsCheckBox.setSelected(false);
        semesterBox.getSelectionModel().selectFirst();
    }


    void UPDLanguage(){
        mapCoordinatesLabel.setText(bundleMain.getString("coordinates")+ ":");
        mapStudentsCountLabel.setText(bundleMain.getString("studentsCount")+ ":");
        mapExpelledStudentsLabel.setText(bundleMain.getString("expelledStudents")+ ":");
        mapAverageMarkLabel.setText(bundleMain.getString("averageMark")+ ":");
        mapSemesterLabel.setText(bundleMain.getString("semester")+ ":");
        mapPersonLabel.setText(bundleMain.getString("person")+ ":");
        mapHeightLabel.setText(bundleMain.getString("height")+ ":");
        mapWeightLabel.setText(bundleMain.getString("weight")+ ":");
        mapLocationLabel.setText(bundleMain.getString("location")+ ":");
        elementsCheckBox.setText(bundleMain.getString("only.my"));
        applyButton.setText(bundleMain.getString("apply"));
        clearButton.setText(bundleMain.getString("cl"));
        from.setText(bundleMain.getString("from"));
        from1.setText(bundleMain.getString("from"));
        from2.setText(bundleMain.getString("from"));
        from3.setText(bundleMain.getString("from"));
        from4.setText(bundleMain.getString("from"));
        from5.setText(bundleMain.getString("from"));
        from6.setText(bundleMain.getString("from"));
        from7.setText(bundleMain.getString("from"));
        from8.setText(bundleMain.getString("from"));
        from9.setText(bundleMain.getString("from"));
        from10.setText(bundleMain.getString("from"));
        to.setText(bundleMain.getString("to"));
        to1.setText(bundleMain.getString("to"));
        to2.setText(bundleMain.getString("to"));
        to3.setText(bundleMain.getString("to"));
        to4.setText(bundleMain.getString("to"));
        to5.setText(bundleMain.getString("to"));
        to6.setText(bundleMain.getString("to"));
        to7.setText(bundleMain.getString("to"));
        to8.setText(bundleMain.getString("to"));
        to9.setText(bundleMain.getString("to"));
        to10.setText(bundleMain.getString("to"));

    }
}
