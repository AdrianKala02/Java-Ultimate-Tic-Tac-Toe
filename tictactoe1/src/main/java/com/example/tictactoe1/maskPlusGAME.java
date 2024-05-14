package com.example.tictactoe1;

import javafx.scene.layout.StackPane;
import javafx.scene.shape.Line;

public class maskPlusGAME extends StackPane {
    maskPlusGAME(char czyjaTura,int lvlMiniona){

        Line line1 =new Line(0,750,0,0);
        line1.setStrokeWidth(6);
        line1.setTranslateX(-325);
        line1.setTranslateY(40);
        line1.setStyle("-fx-stroke: #88d18a");


        Line line2 =new Line(0,750,0,0);
        line2.setStrokeWidth(6);
        line2.setTranslateX(-75);
        line2.setTranslateY(40);
        line2.setStyle("-fx-stroke: #88d18a");

        Line line3 =new Line(750,0,0,0);
        line3.setStrokeWidth(6);
        line3.setTranslateX(-200);
        line3.setTranslateY(-84);
        line3.setStyle("-fx-stroke: #88d18a");

        Line line4 =new Line(750,0,0,0);
        line4.setStrokeWidth(6);
        line4.setTranslateX(-200);
        line4.setTranslateY(166);
        line4.setStyle("-fx-stroke: #88d18a");

        this.getChildren().addAll(new graBack(czyjaTura,lvlMiniona));
        this.getChildren().addAll(line1,line2,line3,line4);
    }
}
