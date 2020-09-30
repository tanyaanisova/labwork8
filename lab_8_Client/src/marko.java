import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class marko extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        // Create the Canvas
        Canvas canvas = new Canvas(450, 450);
        // Set the width of the Canvas

// Create the Pane
        Pane root = new Pane();
        // Add the Canvas to the Pane
        root.getChildren().add(canvas);
        // Create the Scene
        Scene scene = new Scene(root);
        // Add the Scene to the Stage
        stage.setScene(scene);
        // Set the Title of the Stage
        stage.setTitle("Creation of a Canvas");
        // Display the Stage
        stage.show();

        // Get the graphics context of the canvas
        GraphicsContext gc = canvas.getGraphicsContext2D();
        //gc.drawImage(new Image("file:\\C:\\Users\\Tiloaria\\Desktop\\Sic Mundus Creatus Est\\Marco.png"),50,0, 350, 450);

        //голова
        gc.setLineWidth(2.5);
        gc.beginPath();
        gc.moveTo(173,115);
        gc.quadraticCurveTo(220,165,290,130);
        gc.quadraticCurveTo(310,120,290,90);
        gc.quadraticCurveTo(300,80,280,50);
        gc.lineTo(170,50);
        gc.lineTo(157,85);
        gc.quadraticCurveTo(145,80,143,100);
        gc.quadraticCurveTo(150,125,173,115);
        gc.closePath();
        gc.setFill(Color.rgb(232,171,155));
        gc.fill();
        gc.stroke();

        //нос и рот
        //gc.setLineWidth(1.0);
        gc.moveTo(245,92);
        gc.quadraticCurveTo(245,95,255,100);
        gc.quadraticCurveTo(252, 104,248,105);
        gc.stroke();
        gc.moveTo(220,110);
        gc.quadraticCurveTo(235,120,260,115);
        gc.stroke();

        gc.setLineWidth(2.5);

        //глаза
        gc.setFill(Color.WHITE);
        gc.strokeOval(185,71,46,31);
        gc.fillOval(186,72,44,29);
        gc.strokeOval(254,70,40,30);
        gc.fillOval(255,71,38,28);

        gc.setFill(Color.rgb(138,70,52));
        gc.strokeOval(210,78,22,22);
        gc.fillOval(211,79,20,20);
        gc.strokeOval(275,78,20,20);
        gc.fillOval(276,79,18,18);

        gc.setFill(Color.BLACK);
        gc.fillOval(217,83,15,15);
        gc.fillOval(280,82,15,15);

        //уши
        gc.moveTo(150,95);
        gc.quadraticCurveTo(155,90,165,105);
        gc.quadraticCurveTo(150,105,160,110);
        gc.stroke();

        //волосы
        gc.beginPath();
        gc.moveTo(160,45);
        gc.quadraticCurveTo(150,17,220,20);
        gc.quadraticCurveTo(240,20,260,10);
        gc.quadraticCurveTo(260,20,255,20);
        gc.quadraticCurveTo(300,20,315,50);
        gc.quadraticCurveTo(300,40,295,40);
        gc.quadraticCurveTo(315,60,310,75);
        gc.quadraticCurveTo(280,50,240,60);
        gc.quadraticCurveTo(210,70,180,60);
        gc.quadraticCurveTo(182,67,180,80);
        gc.quadraticCurveTo(177,87,180,97);
        gc.quadraticCurveTo(175,97,170,90);
        gc.quadraticCurveTo(170,97,175,105);
        gc.quadraticCurveTo(165,105,155,85);
        gc.quadraticCurveTo(150,83,146,87);
        gc.quadraticCurveTo(120,60,160,45);
        gc.closePath();
        gc.setFill(Color.rgb(61,36,35));
        gc.fill();
        gc.stroke();

        //кофта
        gc.beginPath();
        gc.moveTo(190,160);
        gc.lineTo(155,230);
        gc.quadraticCurveTo(150,260,210,260);
        gc.lineTo(205,265);
        gc.lineTo(208,268);
        gc.lineTo(206,278);
        gc.quadraticCurveTo(235,282,270,278);
        gc.lineTo(270,270);
        gc.lineTo(278,260);
        gc.quadraticCurveTo(320,240,300,220);
        gc.lineTo(260,160);
        gc.quadraticCurveTo(255,145,230,150);
        gc.quadraticCurveTo(195,140,190,160);
        gc.closePath();
        gc.setFill(Color.RED);
        gc.fill();

        gc.strokeLine(210,180,200,230);
        gc.strokeLine(260,180,270,230);
        gc.moveTo(180,230);
        gc.quadraticCurveTo(190,230,220,240);
        gc.moveTo(290,225);
        gc.quadraticCurveTo(275,225,265,235);

        gc.moveTo(210,260);
        gc.quadraticCurveTo(225,250,220,235);
        gc.lineTo(260,233);
        gc.lineTo(278,260);
        gc.moveTo(270,270);
        gc.quadraticCurveTo(238,275,208,268);
        gc.moveTo(250,273);
        gc.quadraticCurveTo(255,250,245,235);
        gc.lineTo(240,190);
        gc.lineTo(260,160);
        gc.moveTo(240,190);
        gc.quadraticCurveTo(200,150,190,160);
        gc.stroke();

        //футболка
        gc.beginPath();
        gc.moveTo(240,180);
        gc.lineTo(215,155);
        gc.quadraticCurveTo(230,160,248,155);
        gc.lineTo(240,180);
        gc.closePath();
        gc.setFill(Color.rgb(199,200,205));
        gc.fill();
        gc.stroke();

        //шея
        gc.beginPath();
        gc.moveTo(215,155);
        gc.quadraticCurveTo(225,150,220,145);
        gc.quadraticCurveTo(230,148,240,145);
        gc.quadraticCurveTo(235,150,245,155);
        gc.quadraticCurveTo(230,160,215,155);
        gc.closePath();
        gc.setFill(Color.rgb(232,171,155));
        gc.fill();
        gc.stroke();

        //кроссы
        //левый
        gc.beginPath();
        gc.moveTo(195,415);
        gc.lineTo(170,426);
        gc.quadraticCurveTo(145,438,175,442);
        gc.quadraticCurveTo(195,440,227,420);
        gc.lineTo(195,415);
        gc.closePath();
        gc.setFill(Color.WHITE);
        gc.fill();
        gc.stroke();

        gc.moveTo(170,426);
        gc.quadraticCurveTo(155,433,175,435);
        gc.lineTo(185,433);
        gc.stroke();

        gc.beginPath();
        gc.moveTo(195,415);
        gc.lineTo(170,426);
        gc.quadraticCurveTo(180,425,185,433);
        gc.lineTo(220,420);
        gc.lineTo(195,415);
        gc.closePath();
        gc.setFill(Color.rgb(157,125,81));
        gc.fill();
        gc.stroke();

        //правый

        gc.beginPath();
        gc.moveTo(275,405);
        gc.lineTo(305,408);
        gc.quadraticCurveTo(335,420,298,428);
        gc.lineTo(255,418);
        gc.lineTo(255, 410);
        gc.lineTo(275,405);
        gc.closePath();
        gc.setFill(Color.WHITE);
        gc.fill();
        gc.stroke();

        gc.beginPath();
        gc.moveTo(275,405);
        gc.lineTo(305,408);
        gc.quadraticCurveTo(295,417,298,420);
        gc.lineTo(255,413);
        gc.lineTo(255, 410);
        gc.lineTo(275,405);
        gc.closePath();
        gc.setFill(Color.rgb(157,125,81));
        gc.fill();
        gc.stroke();

        gc.moveTo(275,405);
        gc.lineTo(305,408);
        gc.quadraticCurveTo(327,417,298,420);
        gc.stroke();

        //штаны
        gc.beginPath();
        gc.moveTo(208,278);
        gc.lineTo(200,378);
        gc.quadraticCurveTo(190,400,200,405);
        gc.quadraticCurveTo(180,410,210,420);
        gc.quadraticCurveTo(235,425,235,390);
        gc.lineTo(235,350);
        gc.lineTo(245,300);
        gc.lineTo(240,325);
        gc.lineTo(245,380);
        gc.quadraticCurveTo(240,415,265,410);
        gc.quadraticCurveTo(295,405,280,395);
        gc.quadraticCurveTo(285,390,275,375);
        gc.lineTo(263,280);
        gc.quadraticCurveTo(235,282,208,278);
        gc.closePath();
        gc.setFill(Color.rgb(55,48,48));
        gc.fill();
        gc.stroke();



    }
}
