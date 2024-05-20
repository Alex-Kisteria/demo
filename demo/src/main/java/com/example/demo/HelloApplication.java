package com.example.demo;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class HelloApplication extends Application {

    private ArrayList<ImageView> cardList = new ArrayList<>();
    private ArrayList<Button> betButtons = new ArrayList<>();
    private ArrayList<Rectangle> glowCard = new ArrayList<>();
    private TextField[] betFields = new TextField[6]; // Array to store bet fields
    private int[] userInputBets = new int[6]; // Array to store user bets
    Random random = new Random();

    public static void main(String[] args) {
        launch();
    }


    @Override
    public void start(Stage stage) throws IOException {
        //FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        AnchorPane pnMain = new AnchorPane();
        GridPane grid = new GridPane();

        pnMain.getChildren().add(grid);
        grid.setAlignment(Pos.CENTER);
        grid.setGridLinesVisible(true); //SET IT TO FALSE IF MANA OVERALL PROJECT!!!!

        grid.getColumnConstraints().add(new ColumnConstraints(38));
        grid.getColumnConstraints().add(new ColumnConstraints(70));
        grid.getColumnConstraints().add(new ColumnConstraints(70));
        grid.getColumnConstraints().add(new ColumnConstraints(70));
        grid.getColumnConstraints().add(new ColumnConstraints(70));
        grid.getColumnConstraints().add(new ColumnConstraints(70));
        grid.getColumnConstraints().add(new ColumnConstraints(70));
        grid.getColumnConstraints().add(new ColumnConstraints(70));
        grid.getColumnConstraints().add(new ColumnConstraints(70));
        grid.getColumnConstraints().add(new ColumnConstraints(70));
        grid.getColumnConstraints().add(new ColumnConstraints(70));
        grid.getColumnConstraints().add(new ColumnConstraints(70));
        grid.getColumnConstraints().add(new ColumnConstraints(70));
        grid.getColumnConstraints().add(new ColumnConstraints(70));
        grid.getColumnConstraints().add(new ColumnConstraints(70));
        grid.getColumnConstraints().add(new ColumnConstraints(70));
        grid.getColumnConstraints().add(new ColumnConstraints(70));
        grid.getColumnConstraints().add(new ColumnConstraints(37));

        //QUESTION: Ngano di mu show up if ColumnConstraints ra naa pero wala pa RowConstraints?
        grid.getRowConstraints().add(new RowConstraints(70));
        grid.getRowConstraints().add(new RowConstraints(70));
        grid.getRowConstraints().add(new RowConstraints(70));
        grid.getRowConstraints().add(new RowConstraints(70));
        grid.getRowConstraints().add(new RowConstraints(70));
        grid.getRowConstraints().add(new RowConstraints(70));
        grid.getRowConstraints().add(new RowConstraints(70));
        grid.getRowConstraints().add(new RowConstraints(70));
        grid.getRowConstraints().add(new RowConstraints(70));
        grid.getRowConstraints().add(new RowConstraints(60));

        // UNSAY PURPOSE ANI?
//        Text sceneTitle = new Text(" ");
//        sceneTitle.setTextAlignment(TextAlignment.CENTER);
//        sceneTitle.setStrokeWidth(50);
//        sceneTitle.setFill(Paint.valueOf("#325622"));
//        sceneTitle.setFont(Font.font("Arial", FontWeight.BOLD, 40));
//        GridPane.setHalignment(sceneTitle, HPos.CENTER);
//        GridPane.setColumnSpan(sceneTitle, 5);
//        GridPane.setRowSpan(sceneTitle, 1);
//        grid.add(sceneTitle, 0, 1);



        //FOR TITLE NA PNG
//        Image gameTitle = new Image(getClass().getResourceAsStream("Color Game Blocks.png"));
//        ImageView imageTitle = new ImageView(gameTitle);
//        imageTitle.setFitWidth(300);
//        imageTitle.setFitHeight(300);
//        grid.add(imageTitle,  1, 1);



        Rectangle rectangle1 = new Rectangle();
        rectangle1.setHeight(200);
        rectangle1.setWidth(150);
        rectangle1.setFill(Color.BLACK);
        rectangle1.getStyleClass().add("rectangle_glow");
        rectangle1.setOpacity(0);
        grid.add(rectangle1,4,2);
        glowCard.add(rectangle1);

        //Image image = new Image(new FileInputStream("src/main/java/com/example/demo/1.png"));
        Image diamondAce = new Image(Objects.requireNonNull(getClass().getResourceAsStream("1.png")));
        ImageView imageDiaAce = new ImageView(diamondAce);
        imageDiaAce.setFitWidth(150);
        imageDiaAce.setFitHeight(200);
                            //x    //y
        grid.add(imageDiaAce,  4, 2);
        cardList.add(imageDiaAce);


        Button bet_diamondAce = new Button();
        bet_diamondAce.setText("Bet");
        bet_diamondAce.setOnAction(event -> openBetStage(0));
        bet_diamondAce.setPrefSize(100,12);
        grid.add(bet_diamondAce,4,4,2,1);
        GridPane.setHalignment(bet_diamondAce,HPos.CENTER);

        //
        TextField diamondAce_betInput = new TextField();
        diamondAce_betInput.setEditable(false);
        diamondAce_betInput.setAlignment(Pos.CENTER);
        grid.add(diamondAce_betInput, 4, 0,2,1);
        GridPane.setHalignment(diamondAce_betInput, HPos.CENTER);
        betFields[0] = diamondAce_betInput;

        Rectangle rectangle2 = new Rectangle();
        rectangle2.setHeight(200);
        rectangle2.setWidth(150);
        rectangle2.setFill(Color.BLACK);
        rectangle2.getStyleClass().add("rectangle_glow");
        rectangle2.setOpacity(0);
        grid.add(rectangle2,7,2,5,1);
        glowCard.add(rectangle2);

        Image diamondQueen = new Image(Objects.requireNonNull(getClass().getResourceAsStream("2.png")));
        ImageView imageDiaQueen = new ImageView(diamondQueen);
        imageDiaQueen.setFitWidth(150);
        imageDiaQueen.setFitHeight(200);
        grid.add(imageDiaQueen,  7, 2);
        cardList.add(imageDiaQueen);

        Button bet_diamondQueen = new Button();
        bet_diamondQueen.setText("Bet");
        bet_diamondQueen.setOnAction(event -> openBetStage(1));
        bet_diamondQueen.setPrefSize(100,12);
        grid.add(bet_diamondQueen,7,4,2,1);
        GridPane.setHalignment(bet_diamondQueen,HPos.CENTER);

        Rectangle rectangle3 = new Rectangle();
        rectangle3.setHeight(200);
        rectangle3.setWidth(150);
        rectangle3.setFill(Color.BLACK);
        rectangle3.getStyleClass().add("rectangle_glow");
        rectangle3.setOpacity(0);
        grid.add(rectangle3,10,2,5,1);
        glowCard.add(rectangle3);

        Image diamondKing = new Image(Objects.requireNonNull(getClass().getResourceAsStream("3.png")));
        ImageView imageDiaKing = new ImageView(diamondKing);
        imageDiaKing.setFitWidth(150);
        imageDiaKing.setFitHeight(200);
        grid.add(imageDiaKing,  10, 2);
        cardList.add(imageDiaKing);

        Button bet_diamondKing = new Button();
        bet_diamondKing.setText("Bet");
        bet_diamondKing.setOnAction(event -> openBetStage(2));
        bet_diamondKing.setPrefSize(100,12);
        grid.add(bet_diamondKing,10,4,2,1);
        GridPane.setHalignment(bet_diamondKing,HPos.CENTER);

        Rectangle rectangle4 = new Rectangle();
        rectangle4.setHeight(200);
        rectangle4.setWidth(150);
        rectangle4.setFill(Color.BLACK);
        rectangle4.getStyleClass().add("rectangle_glow");
        rectangle4.setOpacity(0);
        grid.add(rectangle4,4,6,5,1);
        glowCard.add(rectangle4);

        Image club8 = new Image(Objects.requireNonNull(getClass().getResourceAsStream("4.png")));
        ImageView imageClub8 = new ImageView(club8);
        imageClub8.setFitWidth(150);
        imageClub8.setFitHeight(200);
        grid.add(imageClub8,  4, 6);
        cardList.add(imageClub8);

        Button bet_club8 = new Button();
        bet_club8.setText("Bet");
        bet_club8.setOnAction(event -> openBetStage(3));
        bet_club8.setPrefSize(100,12);
        grid.add(bet_club8,4,8,2,1);
        GridPane.setHalignment(bet_club8,HPos.CENTER);

        Rectangle rectangle5 = new Rectangle();
        rectangle5.setHeight(200);
        rectangle5.setWidth(150);
        rectangle5.setFill(Color.BLACK);
        rectangle5.getStyleClass().add("rectangle_glow");
        rectangle5.setOpacity(0);
        grid.add(rectangle5,7,6,5,1);
        glowCard.add(rectangle5);

        Image dia3 = new Image(Objects.requireNonNull(getClass().getResourceAsStream("5.png")));
        ImageView imageDia3 = new ImageView(dia3);
        imageDia3.setFitWidth(150);
        imageDia3.setFitHeight(200);
        grid.add(imageDia3,  7, 6);
        cardList.add(imageDia3);

        Button bet_dia3 = new Button();
        bet_dia3.setText("Bet");
        bet_dia3.setOnAction(event -> openBetStage(4));
        bet_dia3.setPrefSize(100,12);
        grid.add(bet_dia3,7,8,2,1);
        GridPane.setHalignment(bet_dia3,HPos.CENTER);

        Rectangle rectangle6 = new Rectangle();
        rectangle6.setHeight(200);
        rectangle6.setWidth(150);
        rectangle6.setFill(Color.BLACK);
        rectangle6.getStyleClass().add("rectangle_glow");
        rectangle6.setOpacity(0);
        grid.add(rectangle6,10,6,5,1);
        glowCard.add(rectangle6);

        Image heartAce = new Image(Objects.requireNonNull(getClass().getResourceAsStream("6.png")));
        ImageView imageHeartAce = new ImageView(heartAce);
        imageHeartAce.setFitWidth(150);
        imageHeartAce.setFitHeight(200);
        grid.add(imageHeartAce,10, 6);
        cardList.add(imageHeartAce);

        Button bet_heartAce = new Button();
        bet_heartAce.setText("Bet");
        bet_heartAce.setOnAction(event -> openBetStage(5));
        bet_heartAce.setPrefSize(100,12);
        grid.add(bet_heartAce,10,8,2,1);
        GridPane.setHalignment(bet_heartAce,HPos.CENTER);

        //Btn for randomizer chooser
        Button rando_btn = new Button();
        rando_btn.setText("Start Randomizer");
        rando_btn.setOnAction(event -> startRandomizer());
        rando_btn.setPrefSize(100,12);
        grid.add(rando_btn,13,8,2,1);
        GridPane.setHalignment(rando_btn,HPos.CENTER);




        Scene scene = new Scene(pnMain, 1200, 700);
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        stage.setTitle("Perya_DropBall");
        stage.setScene(scene);
        stage.show();
    }//start


    private void startRandomizer() {
        System.out.println("randomizer button clicked");

        // Track the start time
        long startTime = System.currentTimeMillis();

        // Create a Timeline to repeatedly execute the logic
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(50), event -> {
            // Check if 5 seconds have passed
            if (System.currentTimeMillis() - startTime >= 5000) {
                // Stop the timeline
                ((Timeline)event.getSource()).stop();
                return;
            }

            // Get a random index
            int randomIndex = random.nextInt(cardList.size());

            // Iterate over cardList and update the opacity
            for (int i = 0; i < cardList.size(); i++) {
                final int index = i;

                Platform.runLater(() -> {
                    if (index == randomIndex) {
                        glowCard.get(index).setOpacity(1);
                        System.out.println("current index: " + index);
                    } else {
                        glowCard.get(index).setOpacity(0);
                    }
                });
            }
        }));

        // Set the timeline to repeat indefinitely
        timeline.setCycleCount(Timeline.INDEFINITE);

        // Start the timeline
        timeline.play();
    }


    private void openBetStage(int cardIndex) {
        try {
            //FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("moneyConversion-view.fxml"));
            Stage stage = new Stage();

            // Set the modality to block input events from being delivered to other stages
            stage.initModality(Modality.WINDOW_MODAL);

            // Make the bet window modal to the main application window
            stage.initOwner(getStage());

            AnchorPane pnBet = new AnchorPane();
            pnBet.getStyleClass().add("betStage_bg");
            GridPane grid = new GridPane();


            pnBet.getChildren().add(grid);
            grid.setAlignment(Pos.CENTER);
            grid.setGridLinesVisible(true); //SET IT TO FALSE IF MANA OVERALL PROJECT!!!!

            grid.getColumnConstraints().add(new ColumnConstraints(35));
            grid.getColumnConstraints().add(new ColumnConstraints(35));
            grid.getColumnConstraints().add(new ColumnConstraints(20));
            grid.getColumnConstraints().add(new ColumnConstraints(20));
            grid.getColumnConstraints().add(new ColumnConstraints(35));
            grid.getColumnConstraints().add(new ColumnConstraints(35));
            grid.getColumnConstraints().add(new ColumnConstraints(35));
            grid.getColumnConstraints().add(new ColumnConstraints(30));
            grid.getColumnConstraints().add(new ColumnConstraints(15));
            grid.getColumnConstraints().add(new ColumnConstraints(35));

            grid.getRowConstraints().add(new RowConstraints(35));
            grid.getRowConstraints().add(new RowConstraints(35));
            grid.getRowConstraints().add(new RowConstraints(35));
            grid.getRowConstraints().add(new RowConstraints(35));
            grid.getRowConstraints().add(new RowConstraints(35));
            grid.getRowConstraints().add(new RowConstraints(30));
            grid.getRowConstraints().add(new RowConstraints(28));
            grid.getRowConstraints().add(new RowConstraints(45));
            grid.getRowConstraints().add(new RowConstraints(35));
            grid.getRowConstraints().add(new RowConstraints(35));

            //set background image using the given parameters
            BackgroundImage myBI = new BackgroundImage(
                    new Image(getClass().getResource("EnterBet.png").toExternalForm(),
                            350, 350, false, true),
                    BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT,
                    BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
            pnBet.setBackground(new Background(myBI));

            //TextField for Bet Amount
            TextField betField = new TextField ();
            betField.setPromptText("Set Amount");
            betField.setAlignment(Pos.CENTER);
            grid.add(betField,3, 6,6,2);

            Button placeBet_btn = new Button();
            placeBet_btn.setText(" ");
            placeBet_btn.setOnAction(event -> {
                int bet = Integer.parseInt(betField.getText());
                if(bet <= 0){
                    betField.clear();
                    betField.setPromptText("Invalid Input");
                } else {
                    userInputBets[cardIndex] = bet;
                    betFields[cardIndex].setText(String.valueOf(bet));
                    stage.close();
                }
            });
            grid.add(placeBet_btn,4,8,8,1); //NGANO DI SIYA MU SPAN PROPERLY????
            //GridPane.setHalignment(placeBet_btn,HPos.CENTER);

            Scene scene = new Scene(pnBet, 350, 350);
            scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
            stage.setTitle("Bet Forms");
            stage.setScene(scene);
            stage.show();




        } catch (Exception e) {
            System.out.println("Can't load new window");
        }
    }

    // Helper method to get the primary stage
    private Stage getStage() {
        return (Stage) cardList.get(0).getScene().getWindow();
    }


}//HelloApplication