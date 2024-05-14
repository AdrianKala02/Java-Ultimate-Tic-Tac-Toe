package com.example.tictactoe1;

import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class informacion extends BorderPane{
    informacion(){
        Label label = new Label("tu pojawią się informacje jak grać");
        this.setId("informacionMain");
        this.setCenter(label);
    }
}
