package com.example.proj;

import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;

public class Tile extends Rectangle {

    public Tile(int Size){
        setWidth(Size);
        setHeight(Size);
        setFill(Color.AZURE);
        setStroke(Color.BLACK);
    }
}
