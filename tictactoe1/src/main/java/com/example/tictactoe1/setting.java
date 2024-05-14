package com.example.tictactoe1;

import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class setting extends BorderPane{

    setting(){
        Label label = new Label("Tu pojawią się ustawienia");
        this.setId("settingMain");
        this.setCenter(label);

    }
}
