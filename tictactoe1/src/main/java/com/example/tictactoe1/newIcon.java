package com.example.tictactoe1;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class newIcon extends ImageView{
    ImageView imageView;

    newIcon(String iconname, int szerokosc, int wysokosc){
        Image image = new Image(iconname);
        imageView = new ImageView(image);
        imageView.setFitWidth(szerokosc);
        imageView.setFitHeight(wysokosc);
        imageView.setPreserveRatio(true);
    }
}
