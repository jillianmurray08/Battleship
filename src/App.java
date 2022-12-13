import javafx.application.Application;
//import javafx.geometry.Pos;
//import javafx.geometry.VPos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.paint.Color;
//import javafx.geometry.VPos;
//import javafx.beans.binding.Bindings;
//import javafx.beans.property.DoubleProperty;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.GridPane;


public class App extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Battleship");
        
        char[][] sGrid = new char[10][10];
        //char hit = 'x';
        //char miss = 'o';
        //char ship = 's';
        char water = 'w';
        Group root1 = new Group();
        Group root2 = new Group();
        Group root3 = new Group();
        Group root4 = new Group();
        Scene welcomeScene = new Scene(root1, 300, 300);
        Scene buildScene = new Scene(root2, 325, 450);
        Scene playerScene = new Scene(root3, 325, 400);
        Scene computerScene = new Scene(root4, 325, 400);
        welcomeScene.setFill(Color.WHITE);
        primaryStage.setScene(welcomeScene);
        primaryStage.show();

        //welcome label
        Label welcomeLbl = new Label("Welcome to Battleship!");
        welcomeLbl.layoutXProperty().set(50);
        welcomeLbl.layoutYProperty().set(100);
        welcomeLbl.setFont(new Font("Arial", 20));
        welcomeLbl.setTextFill(Color.BLACK);

        //instruction label
        Label instructionLbl = new Label("Press button to play");
        instructionLbl.layoutXProperty().set(80);
        instructionLbl.layoutYProperty().set(125);
        instructionLbl.setFont(new Font("Arial", 15));
        instructionLbl.setTextFill(Color.BLACK);

        //play button
        Button playBtn = new Button("PLAY");
        playBtn.layoutXProperty().set(115);
        playBtn.layoutYProperty().set(150);
        playBtn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Button clicked");
                primaryStage.setScene(buildScene);
            }
        });

        //add children to welcome scene
        root1.getChildren().add(welcomeLbl);
        root1.getChildren().add(instructionLbl);
        root1.getChildren().add(playBtn);

        GridPane gridPn = new GridPane();

        //build label
        Label buildLbl1 = new Label("Select 5 squares to place your 5 ships. \nThen hit next.");
        buildLbl1.layoutXProperty().set(25);
        buildLbl1.layoutYProperty().set(330);

        Button nextBtn = new Button("Next");
        nextBtn.layoutXProperty().set(200);
        nextBtn.layoutYProperty().set(390);
        nextBtn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                primaryStage.setScene(playerScene);
            }
        });

        //initialize grid with water
        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 10; col++) {
                sGrid[row][col] = water;
            }
        }

        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 10; col++) {
              Button btn = new Button();
              btn.setPrefSize(30, 30);
              btn.setStyle("-fx-background-color: lightblue; -fx-border-style: solid");
              gridPn.add(btn, col, row);

              btn.setOnAction(new EventHandler<ActionEvent>(){
                boolean btnClicked = false;
                @Override
                public void handle(ActionEvent event) {
                    //if()
                    if (btnClicked == false) {
                        btn.setStyle("-fx-background-color: lightgray; -fx-border-style: solid");
                        //sGrid[row][col] = 's';
                        btnClicked = true;
                    } else {
                        btn.setStyle("-fx-background-color: lightblue; -fx-border-style: solid");
                        btnClicked = false;
                    }
                }
              });
            }
          }
        
        gridPn.setHgap(10);
        gridPn.setVgap(10);
        gridPn.setStyle("-fx-background-color: lightblue; -fx-padding: 2; -fx-hgap: 2; -fx-vgap: 2; -fx-border-style:solid;");

        root2.getChildren().add(gridPn);
        root2.getChildren().add(buildLbl1);
        root2.getChildren().add(nextBtn);
    }

    public static void createMap() {

    }
}