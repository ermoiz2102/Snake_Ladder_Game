package com.example.proj;

import javafx.util.Pair;

import java.util.ArrayList;

public class board {
    ArrayList<Pair<Integer,Integer>> Position;
    ArrayList<Integer>newPosition;
    public board(){
        Position= new ArrayList<>();
        positionFind();
        snakeladder();

    }
    public void positionFind(){
        Position.add(new Pair<>(0,0));
        for (int i = 0; i < Snakeladder.height; i++) {
            for (int j = 0; j < Snakeladder.width; j++) {
                int xcord=0;
                if(i%2==0){
                     xcord = (j*Snakeladder.tilesize)+Snakeladder.tilesize/2;
                }
                else{
                    xcord =Snakeladder.height*Snakeladder.tilesize-(j*Snakeladder.tilesize)-Snakeladder.tilesize/2;
                }
                int ycord =Snakeladder.height*Snakeladder.tilesize-(i*Snakeladder.tilesize)-Snakeladder.tilesize/2;
                Position.add(new Pair<>(xcord,ycord));
            }

        }
    }
    private void snakeladder(){
        newPosition = new ArrayList<>();
        for (int i = 0; i < 101; i++) {
            newPosition.add(i);

        }
        newPosition.set(4,25);
        newPosition.set(27,5);
        newPosition.set(33,49);
        newPosition.set(13,46);
        newPosition.set(40,3);
        newPosition.set(42,63);
        newPosition.set(43,18);
        newPosition.set(50,69);
        newPosition.set(54,31);
        newPosition.set(62,81);
        newPosition.set(66,45);
        newPosition.set(76,58);
        newPosition.set(74,92);
        newPosition.set(89,53);
        newPosition.set(99,41);



    }
    public  int getNewPos(int curr) {
        if(curr>0&&curr<=100)
            return newPosition.get(curr);
        return -1;

    }
    int getXCoordinate(int position){
        if(position>=1&&position<=100)
            return  Position.get(position).getKey();
        return -1;
    }
    int getYCoordinate(int position){
        if(position>=1&&position<=100)
            return  Position.get(position).getValue();
        return -1;
    }

    public static void main(String[] args) {
        board root= new board();
//        for (int i = 0; i < root.Position.size(); i++) {
//            System.out.println(i+"  X:"+root.Position.get(i).getKey()+"  Y:"+root.Position.get(i).getValue());

        }
    }


