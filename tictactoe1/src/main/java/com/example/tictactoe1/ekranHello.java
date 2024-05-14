package com.example.tictactoe1;

import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class ekranHello extends BorderPane{


    ekranHello(){

        Label label =new Label("Witamy w GRZE!");
        label.setStyle("-fx-font-size: 60");
        this.setId("ekranHelloMain");
        this.setCenter(label);
    }
}
