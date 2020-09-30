package controllers;

import TCPClient.DialogMessage;
import TCPClient.TCPSender;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import Object.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.*;
import java.util.List;

public class TableAndMapController {

    private File file;
    private TreeSet<StudyGroup> localCollection = new TreeSet<StudyGroup>();
    private Desktop desktop = Desktop.getDesktop();
    private String host;
    private int port;
    private String login;
    private TCPSender sender;
    private ArrayList<String> loginAndPassword = new ArrayList<>();
    private GraphicsContext gc;
    private String password;
    private javafx.scene.paint.Color myColor;
    private Integer userID;
    private MapDrawing mapDrawing;
    private Filter filter;
    TreeSet<StudyGroup> newCollection;
    ResourceBundle bundleRu = ResourceBundle.getBundle("controllers.Bundles.Resource", new Locale("ru"));
    ResourceBundle bundleEs = ResourceBundle.getBundle("controllers.Bundles.Resource", new Locale("es", "MX"));
    ResourceBundle bundleHu = ResourceBundle.getBundle("controllers.Bundles.Resource", new Locale("hu"));
    ResourceBundle bundleNo = ResourceBundle.getBundle("controllers.Bundles.Resource", new Locale("no"));
    static ResourceBundle bundleMain;
    static String lang = "default";

    TableAndMapController(String host, int port, String login, String  password, Integer userID){
        this.host = host;
        this.port = port;
        this.login = login;
        this.password = password;
        loginAndPassword.add(login);
        loginAndPassword.add(password);
        sender = new TCPSender(host, port, true, loginAndPassword);
        this.userID = userID;
        bundleMain = bundleRu;
        lang = "ru";
        filter = new Filter(userID, bundleMain);
    }

    @FXML
    private MenuBar hightMenu;

    @FXML
    private Menu languageMenu;

    @FXML
    private RadioMenuItem RussianMenuItem;

    @FXML
    private ToggleGroup Language;

    @FXML
    private RadioMenuItem NorskMenuItem;

    @FXML
    private RadioMenuItem MagyarMenuItem;

    @FXML
    private RadioMenuItem EspanolMenuItem;

    @FXML
    private Menu commandMenu;

    @FXML
    private MenuItem averageItem;

    @FXML
    private MenuItem countAdminItem;

    @FXML
    private MenuItem countGreaterThenAdminItem;

    @FXML
    private MenuItem addItem;

    @FXML
    private MenuItem addMaxItem;

    @FXML
    private MenuItem addMinItem;

    @FXML
    private MenuItem updateItem;

    @FXML
    private MenuItem removeItem;

    @FXML
    private MenuItem clearItem;

    @FXML
    private MenuItem historyItem;

    @FXML
    private MenuItem executeScriptItem;

    @FXML
    private Menu moreMenu;

    @FXML
    private MenuItem helpItem;

    @FXML
    private MenuItem infoItem;

    @FXML
    private MenuItem chooseFileItem;

    @FXML
    private Label userName;

    @FXML
    private TabPane choosePlane;

    @FXML
    private Tab tableTab;

    @FXML
    private TableView<StudyGroup> tableView;

    @FXML
    private TableColumn<StudyGroup, Integer> idColumn;

    @FXML
    private TableColumn<StudyGroup, String> nameColumn;

    @FXML
    private TableColumn<StudyGroup, Coordinates> coordinatesColumn;

    @FXML
    private TableColumn<StudyGroup, Float> xColumn;

    @FXML
    private TableColumn<StudyGroup, Long> yColumn;

    @FXML
    private TableColumn<StudyGroup, String> dateColumn;

    @FXML
    private TableColumn<StudyGroup, Integer> studentsCountColumn;

    @FXML
    private TableColumn<StudyGroup, Long> expelledStudentsColumn;

    @FXML
    private TableColumn<StudyGroup, Float> averageMarkColumn;

    @FXML
    private TableColumn<StudyGroup, Semester> semesterColumn;

    @FXML
    private TableColumn<StudyGroup, Person> personColumn;

    @FXML
    private TableColumn<StudyGroup, String> personNameColumn;

    @FXML
    private TableColumn<StudyGroup, Double> personHeightColumn;

    @FXML
    private TableColumn<StudyGroup, Long> personWeightColumn;

    @FXML
    private TableColumn<StudyGroup, Location> locationColumn;

    @FXML
    private TableColumn<StudyGroup, Double> localXColumn;

    @FXML
    private TableColumn<StudyGroup, Long> localYColumn;

    @FXML
    private TableColumn<StudyGroup, Integer> localZColumn;

    @FXML
    private TableColumn<StudyGroup, String> localNameColumn;

    @FXML
    private Button filterButton;

    @FXML
    private Tab mapTab;

    @FXML
    private HBox mapBox;

    @FXML
    private Pane mapPane;

    @FXML
    private Canvas mapCanvas;

    @FXML
    private VBox informBox;

    @FXML
    private Label mapNameLabel;

    @FXML
    private Label mapCoordinatesLabel;

    @FXML
    private Label mapDateLabel;

    @FXML
    private Label mapStudentsCountLabel;

    @FXML
    private Label mapExpelledStudentsLabel;

    @FXML
    private Label mapAverageMarkLabel;

    @FXML
    private Label mapSemesterLabel;

    @FXML
    private VBox informPlaceBox;

    @FXML
    private Label idLabel;

    @FXML
    private Label nameLabel;

    @FXML
    private Label xLabel;

    @FXML
    private Label yLabel;

    @FXML
    private Label dateLabel;

    @FXML
    private Label studentsCountLabel;

    @FXML
    private Label expelledStudentsLabel;

    @FXML
    private Label averageMarkLabel;

    @FXML
    private Label semesterLabel;

    @FXML
    private Button updateButton;

    @FXML
    private VBox informBox1;

    @FXML
    private Label mapPersonLabel;

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
    private Label mapLocationXLabel;

    @FXML
    private Label mapLocationYLabel;

    @FXML
    private Label mapLocationZLabel;

    @FXML
    private Button removeButton;

    @FXML
    private VBox informPlaceBox1;

    @FXML
    private Label roomsLabel;

    @FXML
    private Label personNameLabel;

    @FXML
    private Label personHeightLabel;

    @FXML
    private Label personWeightLabel;

    @FXML
    private Label locationNameLabel;

    @FXML
    private Label locationXLabel;

    @FXML
    private Label locationYLabel;

    @FXML
    private Label locationZLabel;


    private void initializeColumn(){
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        xColumn.setCellValueFactory(new PropertyValueFactory<>("coordinatesX"));
        yColumn.setCellValueFactory(new PropertyValueFactory<>("coordinatesY"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("localCreationDate"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        studentsCountColumn.setCellValueFactory(new PropertyValueFactory<>("studentsCount"));
        expelledStudentsColumn.setCellValueFactory(new PropertyValueFactory<>("expelledStudents"));
        averageMarkColumn.setCellValueFactory(new PropertyValueFactory<>("averageMark"));
        semesterColumn.setCellValueFactory(new PropertyValueFactory<>("semesterEnum"));
        personNameColumn.setCellValueFactory(new PropertyValueFactory<>("GroupAdminName"));
        personWeightColumn.setCellValueFactory(new PropertyValueFactory<>("groupAdminWeight"));
        personHeightColumn.setCellValueFactory(new PropertyValueFactory<>("groupAdminHeight"));
        localXColumn.setCellValueFactory(new PropertyValueFactory<>("locationX"));
        localYColumn.setCellValueFactory(new PropertyValueFactory<>("locationY"));
        localZColumn.setCellValueFactory(new PropertyValueFactory<>("locationZ"));
        localNameColumn.setCellValueFactory(new PropertyValueFactory<>("locationName"));
    }

    private void printElement(String command){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../Resources/views/newElement.fxml"));
        loader.setController(new NewElementController(new TCPSender(host, port, true, loginAndPassword), command, newCollection, userID, bundleMain));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle(command);
        stage.show();
    }

    private void updateElement(int id){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../Resources/views/newElement.fxml"));
        loader.setController(new NewElementController(new TCPSender(host, port, true, loginAndPassword), "update", newCollection, userID, bundleMain, id));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("update");
        stage.show();
    }

    private void openFile(File file) {
        try {
            this.desktop.open(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void request(String answer){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../Resources/views/warningOrResult.fxml"));
        loader.setController(new WarningOrResultController(answer));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    void initialize() {
        userName.setText("user" + ": " + login);

        UPDLanguage();
       RussianMenuItem.setOnAction(event -> {
               bundleMain = bundleRu;
               lang = "ru";
               UPDLanguage();
       });
       NorskMenuItem.setOnAction(event -> {
           bundleMain = bundleNo;
           lang = "no";
           UPDLanguage();
       });
       EspanolMenuItem.setOnAction(event -> {
           bundleMain = bundleEs;
           lang = "es_MX";
           UPDLanguage();
       });
       MagyarMenuItem.setOnAction(event -> {
           bundleMain = bundleHu;
           lang = "hu";
           UPDLanguage();
       });

        mapDrawing = new MapDrawing(gc, localCollection, mapCanvas);
        clearInfoNearMap();
        initializeColumn();
        //userName.setText("User: " + login);

        historyItem.setOnAction(event -> {
            sender.sender("history", "mew");
            request((String) sender.getReturnObjects().get(1));
        });

        addItem.setOnAction(event -> {
            printElement("add");
        });

        addMaxItem.setOnAction(event -> {
            printElement("add_if_max");
        });

        addMinItem.setOnAction(event -> {
            printElement("add_if_min");
        });

        updateItem.setOnAction(event -> {
            printElement("update");
        });

        removeItem.setOnAction(event -> {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("../Resources/views/RemoveById.fxml"));
            loader.setController(new RemoveByIdController(new TCPSender(host, port, true, loginAndPassword), "remove_by_id", bundleMain));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
            stage.setResizable(false);
        });

        averageItem.setOnAction(event -> {
            sender.sender("average_of_students_count", "mew");
            request((String) sender.getReturnObjects().get(1));
        });

        countAdminItem.setOnAction(event -> {
            count("count_by_group_admin");
        });

        countGreaterThenAdminItem.setOnAction(event -> {
            count("count_greater_than_group_admin");
        });

        infoItem.setOnAction(event -> {
            sender.sender("info", "mew");
            request((String) sender.getReturnObjects().get(1));
        });
        helpItem.setOnAction(event -> {
            sender.sender("help", "mew");
            request((String) sender.getReturnObjects().get(1));
        });
        clearItem.setOnAction(event -> {
           if(new DialogMessage().closeWarring("Вы действительно хотите удалить все свои объекты?")){
                sender.sender("clear", "mew");
           }
        });
        filterButton.setOnAction(event -> {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("../Resources/views/filter.fxml"));
            loader.setController(new FilterController(filter, bundleMain));
            try{
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setResizable(false);
            stage.show();
        });

        removeButton.setOnAction(event -> {
            sender.sender("remove_by_id", Integer.parseInt(idLabel.getText()));
            String answer = (String) sender.getReturnObjects().get(1);
            if (answer.equals("Команда успешно выполнена.")) {
                clearInfoNearMap();
                new DialogMessage().info(answer);
            } else new DialogMessage().warning(answer);
        });

        updateButton.setOnAction(event -> {
            updateElement(Integer.parseInt(idLabel.getText()));
        });

        chooseFileItem.setOnAction(event -> {
            //textArea.clear();
            FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("TEXT files (*.txt)", "*.txt"));
            file = fileChooser.showOpenDialog(filterButton.getScene().getWindow());
        });

        executeScriptItem.setOnAction(event -> {
            BufferedReader commandReader = null;
            try {
                String str = sender.checker(new String[] {"execute_script", file.getAbsolutePath()}, commandReader);
                request(str + "скрипт успешно выполнен.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        //TODO:BagFix
        mapCanvas.setOnMouseClicked(event -> {
            double plusSize = mapDrawing.getPlusSize();
            double finalCoordX = (event.getSceneX() ) * (plusSize / mapCanvas.getWidth()) - plusSize / 2.0;
            double finalCoordY = (event.getSceneY()) * (plusSize / mapCanvas.getWidth()) - plusSize / 2.0;

            StudyGroup group = localCollection.stream().filter(flat1 ->
                    Math.abs(flat1.getCoordinates().getX() - finalCoordX) < plusSize * 0.05)
                    .filter(flat1 ->
                            Math.abs(flat1.getCoordinates().getY() - finalCoordY + 40* (plusSize / mapCanvas.getWidth())) < plusSize * 0.05)
                    .findAny().orElse(null);
            if (group != null) {
                idLabel.setText(group.getId() + "");
                nameLabel.setText(group.getName());
                xLabel.setText(group.getCoordinates().getX() + "");
                yLabel.setText(group.getCoordinates().getY() + "");
                dateLabel.setText(group.getCreationDate().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM, FormatStyle.MEDIUM).withLocale(bundleMain.getLocale())));
                studentsCountLabel.setText(group.getStudentsCount() + "");
                expelledStudentsLabel.setText(group.getExpelledStudents() + "");
                averageMarkLabel.setText(group.getAverageMark() + "");
                semesterLabel.setText(group.getSemesterEnum().toString());
                personNameLabel.setText(group.getGroupAdmin().getName());
                personHeightLabel.setText(group.getGroupAdmin().getHeight() + "");
                personWeightLabel.setText(group.getGroupAdmin().getWeight() + "");
                locationNameLabel.setText(group.getGroupAdmin().getLocation().getName());
                locationXLabel.setText(group.getGroupAdmin().getLocation().getX() + "");
                locationYLabel.setText(group.getGroupAdmin().getLocation().getY() + "");
                locationZLabel.setText(group.getGroupAdmin().getLocation().getZ() + "");
            } else {
                clearInfoNearMap();
            }
        });

        rewriteTable();
    }

    private void count(String command) {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../Resources/views/countByGroupAdmin.fxml"));
        loader.setController(new CountByGroupAdminController(new TCPSender(host, port, true, loginAndPassword), command, bundleMain));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
        stage.setResizable(false);
    }

    private void clearInfoNearMap() {
        idLabel.setText("");
        nameLabel.setText("");
        xLabel.setText("");
        yLabel.setText("");
        dateLabel.setText("");
        studentsCountLabel.setText("");
        expelledStudentsLabel.setText("");
        averageMarkLabel.setText("");
        semesterLabel.setText("");
        personNameLabel.setText("");
        personHeightLabel.setText("");
        personWeightLabel.setText("");
        locationNameLabel.setText("");
        locationXLabel.setText("");
        locationYLabel.setText("");
        locationZLabel.setText("");
    }

    private void rewriteTable() {
        Thread thread = new Thread(() -> {
            TCPSender sender = new TCPSender(host, port, true, loginAndPassword);
            while (true) {
                sender.sender("show", "mew");
                newCollection = (TreeSet<StudyGroup>) sender.getReturnObjects().get(1);
                    tableView.getItems().clear();
                    List<LocalStudyGroup> filteredCollect = filter.filter(newCollection);
                    tableView.getItems().addAll(filteredCollect);
                    tableView.sort();
                    mapDrawing.startDrawMap(newCollection);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.setDaemon(true);
        thread.start();
    }

    void UPDLanguage(){
        userName.setText(bundleMain.getString("user") + ": " + login);
        filterButton.setText(bundleMain.getString("filter"));
        //table columns
        coordinatesColumn.setText(bundleMain.getString("coordinates"));
        nameColumn.setText(bundleMain.getString("name"));
        studentsCountColumn.setText(bundleMain.getString("studentsCount"));
        expelledStudentsColumn.setText(bundleMain.getString("expelledStudents"));
        averageMarkColumn.setText(bundleMain.getString("averageMark"));
        semesterColumn.setText(bundleMain.getString("semester"));
        dateColumn.setText(bundleMain.getString("date"));
        personColumn.setText(bundleMain.getString("person"));
        personNameColumn.setText(bundleMain.getString("name"));
        personHeightColumn.setText(bundleMain.getString("height"));
        personWeightColumn.setText(bundleMain.getString("weight"));
        locationColumn.setText(bundleMain.getString("location"));
        localNameColumn.setText(bundleMain.getString("name"));
        //menu
        tableTab.setText(bundleMain.getString("table"));
        mapTab.setText(bundleMain.getString("map"));
        languageMenu.setText(bundleMain.getString("lang"));
        commandMenu.setText(bundleMain.getString("commands"));
        moreMenu.setText(bundleMain.getString("more"));
        infoItem.setText(bundleMain.getString("info"));
        helpItem.setText(bundleMain.getString("help"));
        chooseFileItem.setText(bundleMain.getString("chose_script"));
        //commands
        averageItem.setText(bundleMain.getString("average"));
        countGreaterThenAdminItem.setText(bundleMain.getString("countGreater"));
        countAdminItem.setText(bundleMain.getString("count"));
        addItem.setText(bundleMain.getString("add"));
        addMaxItem.setText(bundleMain.getString("addMax"));
        addMinItem.setText(bundleMain.getString("addMin"));
        updateItem.setText(bundleMain.getString("update"));
        removeItem.setText(bundleMain.getString("remove"));
        clearItem.setText(bundleMain.getString("clear"));
        historyItem.setText(bundleMain.getString("history"));
        executeScriptItem.setText(bundleMain.getString("execute"));
        //map
        mapNameLabel.setText(bundleMain.getString("name")+ ":");
        mapCoordinatesLabel.setText(bundleMain.getString("coordinates")+ ":");
        mapDateLabel.setText(bundleMain.getString("date")+ ":");
        mapStudentsCountLabel.setText(bundleMain.getString("studentsCount")+ ":");
        mapExpelledStudentsLabel.setText(bundleMain.getString("expelledStudents")+ ":");
        mapAverageMarkLabel.setText(bundleMain.getString("averageMark")+ ":");
        mapSemesterLabel.setText(bundleMain.getString("semester")+ ":");
        mapPersonLabel.setText(bundleMain.getString("person")+ ":");
        mapPersonNameLabel.setText(bundleMain.getString("name")+ ":");
        mapPersonHeightLabel.setText(bundleMain.getString("height")+ ":");
        mapPersonWeightLabel.setText(bundleMain.getString("weight")+ ":");
        mapLocationLabel.setText(bundleMain.getString("location")+ ":");
        mapLocationNameLabel.setText(bundleMain.getString("name")+ ":");
        removeButton.setText(bundleMain.getString("removeButton"));
        updateButton.setText(bundleMain.getString("update"));
    }

}
