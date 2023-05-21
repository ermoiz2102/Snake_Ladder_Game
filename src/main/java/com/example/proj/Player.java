package com.example.proj;

import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.transform.Translate;
import javafx.util.Duration;

public class Player {
    private Circle Coin;

    private int current;

    private String name;

   private static board gameB= new board();

    public Player(int tilesize, Color coinclr,String player){
        Coin = new Circle(tilesize/2);
        Coin.setFill(coinclr);
        current=0;
        moveplayer(1);
        name=player;


    }
    public void moveplayer(int dicevalue){
        if(current+dicevalue<=100) {
            current += dicevalue;

        }
        TranslateTransition secondMove=null, firstMove=  translateAnimation(dicevalue);
        int newPosition=gameB.getNewPos(current);
        if(newPosition!=current&&newPosition!=-1){
            current=newPosition;
            secondMove=translateAnimation(6);
        }
        if(secondMove==null)
            firstMove.play();
        else{
            SequentialTransition sequentialTransition= new SequentialTransition(firstMove,new PauseTransition(Duration.millis(500)),secondMove);
            sequentialTransition.play();
        }


//        int x= gameB.getXCoordinate(current);
//        int y= gameB.getYCoordinate(current);
//        Coin.setTranslateX(x);
//        Coin.setTranslateY(y);


    }
    private TranslateTransition translateAnimation(int dicevalue){
        TranslateTransition animate = new TranslateTransition(Duration.millis(dicevalue*200),Coin);
        animate.setToX(gameB.getXCoordinate(current));
        animate.setToY(gameB.getYCoordinate(current));
        animate.setAutoReverse(false);
         return animate;
    }


    public void startingPosition(){
        current=0;
        moveplayer(1);
    }
    boolean playerWon(){
        if(current==100)
            return true;
        return false;
    }

    public Circle getCoin() {
        return Coin;
    }

    public int getCurrent() {
        return current;
    }

    public String getName() {
        return name;
    }
}
