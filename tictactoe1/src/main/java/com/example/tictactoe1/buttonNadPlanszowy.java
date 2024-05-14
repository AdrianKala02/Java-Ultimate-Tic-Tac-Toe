package com.example.tictactoe1;

import javafx.scene.control.Button;

public class buttonNadPlanszowy extends Button {
    int WygranaPlansza=-1;
    buttonNadPlanszowy(){
        this.setText("REMIS");
        this.setId("buttonNadPlansza");
        this.setStyle("-fx-font-size: 60");
        this.setVisible(false);
    }

}
