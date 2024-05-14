package com.example.tictactoe1;

import javafx.scene.layout.Region;
import javafx.scene.shape.SVGPath;
public class newSVGShape extends Region {
    newSVGShape(int wysokosc, int szerokosc, String hexKolorIkony, int grobosc, String hexKolorBorderu,String opisTworczy){
        SVGPath svgPath = new SVGPath();
        svgPath.setContent(opisTworczy);
        this.setMinWidth(szerokosc);
        this.setMinHeight(wysokosc);
        this.setShape(svgPath);
        this.setStyle("-fx-background-color:"+hexKolorIkony+";-fx-border-width:"+grobosc+";-fx-border-color:"+hexKolorBorderu+";");
    }
    newSVGShape(String opisTworczy){
        SVGPath svgPath = new SVGPath();
        svgPath.setContent(opisTworczy);
        this.setShape(svgPath);
        this.setId("UstawieniaDlaIkon");
    }
}
