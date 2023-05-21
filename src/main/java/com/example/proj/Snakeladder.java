package com.example.proj;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Scanner;

public class Snakeladder extends Application {
    public static final int tilesize=40,width=10,height=10;
    public static final  int buttonsize=height*tilesize+50,infoline =buttonsize-30;

    private static  Dice dice = new Dice();
    private  Player p1,p2;
    private boolean gameStarted=false,p1turn=false,p2turn=false;
    public  Pane createcontent(){
        Pane root = new Pane();
        root.setPrefSize(width*tilesize,height*tilesize+100);
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                Tile tile = new Tile(tilesize);
                tile.setTranslateX(j*tilesize);
                tile.setTranslateY(i*tilesize);
                root.getChildren().add(tile);

            }

        }
        Image img= new Image("C:\\Users\\dell\\IdeaProjects\\mini\\proj\\src\\main\\img.png");
        ImageView board = new ImageView();
        board.setImage(img);
        board.setFitHeight(height*tilesize);
        board.setFitWidth(width*tilesize);
        Button playerone= new Button("player:1");
        Button playertwo= new Button("player:2");
        Button startbutton= new Button("start");

        playerone.setTranslateY(buttonsize);
        playerone.setTranslateX(30);
        playerone.setDisable(true);
        playertwo.setTranslateX(310);
        playertwo.setTranslateY(buttonsize);
        playertwo.setDisable(true);
        startbutton.setTranslateY(buttonsize);
        startbutton.setTranslateX(170);

        Label playerOneLabel= new Label("");
        Label startgame= new Label("Start The Game");
        Label playerTwoLabel= new Label("");
 
        playerOneLabel.setTranslateY(infoline);
        playerOneLabel.setTranslateX(30);
        playerTwoLabel.setTranslateY(infoline);
        playerTwoLabel.setTranslateX(310);
        startgame.setTranslateY(infoline);
        startgame.setTranslateX(150);
        Scanner sc = new Scanner(System.in);
        String first=sc.nextLine();
        String second=sc.nextLine();

        p1= new Player(tilesize, Color.BLACK,first);
        p2= new Player(tilesize-5,Color.WHITE,second);

        playerone.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(gameStarted){
                    if(p1turn){

                        if(p1.playerWon()){
                            startgame.setText("Winner is : "+p1.getName());
                            p1turn=false;
                            playerone.setDisable(true);
                            playerOneLabel.setText("");
                            p2turn=false;
                            playertwo.setDisable(true);
                            playerTwoLabel.setText("");

                            startbutton.setDisable(false);
                            startbutton.setText("Restart");

                            gameStarted=false;
                        }
                        else {


                            int diceValue = dice.getValue();
                            startgame.setText("Dice Value" + diceValue);
                            p1.moveplayer(diceValue);

                            p1turn = false;
                            playerone.setDisable(true);
                            playerOneLabel.setText("");

                            p2turn = true;
                            playertwo.setDisable(false);
                            playerTwoLabel.setText("Your turn:" + p2.getName());
                        }
                    }
                }
            }
        });
        playertwo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(gameStarted){
                    if(p2turn){



                        if(p2.playerWon()){
                            startgame.setText("Winner is : "+p2.getName());
                            p1turn=false;
                            playerone.setDisable(true);
                            playerOneLabel.setText("");
                            p2turn=false;
                            playertwo.setDisable(true);
                            playerTwoLabel.setText("");

                            startbutton.setDisable(false);
                            startbutton.setText("Restart");

                            gameStarted=false;
                        }
                     else {
                            int diceValue= dice.getValue();
                            startgame.setText("Dice Value: "+ diceValue);
                            p2.moveplayer(diceValue);
                            p2turn = false;
                            playertwo.setDisable(true);
                            playerTwoLabel.setText("");

                            p1turn = true;
                            playerone.setDisable(false);
                            playerOneLabel.setText("Your turn: " + p1.getName());
                        }
                    }
                }
            }
        });
        startbutton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                gameStarted=true;
                startgame.setText("Game started");
                startbutton.setDisable(true);
                playerOneLabel.setText("Your turn:"+p1.getName());
                playerone.setDisable(false);
                p1turn=true;
                p1.startingPosition();
                p2turn=false;
                playerTwoLabel.setText("");
                playertwo.setDisable(true);
                p2.startingPosition();
            }
        });



        root.getChildren().addAll(board,playerone,playertwo,startbutton,playerOneLabel,playerTwoLabel,startgame,p1.getCoin(),p2.getCoin());
        return  root;
    }
    @Override
    public void start(Stage stage) throws IOException {

        Scene scene = new Scene(createcontent());
        stage.setTitle("Snakeladder");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}