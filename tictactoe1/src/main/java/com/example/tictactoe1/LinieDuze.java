package com.example.tictactoe1;

import javafx.scene.layout.StackPane;
import javafx.scene.shape.Line;

public class LinieDuze extends StackPane {
    LinieDuze(){
        Line line1 =new Line();
        Line line2 =new Line();
        Line line3 =new Line();
        Line line4 =new Line();

        this.getChildren().addAll(line1,line2,line3,line4);
    }
}
