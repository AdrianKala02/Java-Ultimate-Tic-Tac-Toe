package com.example.tictactoe1;
import javafx.scene.control.Button;

import java.util.concurrent.TimeUnit;

public class buttonGame extends Button {
    int znak = -1;
    buttonGame(graBack graBack,gra gra,buttonNadPlanszowy buttonNadPlanszowy){






        this.setOnAction(actionEvent -> {

            int xMaly=(int) this.getTranslateX();
            int yMaly=(int) this.getTranslateY();
            int xDuzy =(int) gra.getTranslateX();
            int yDuzy =(int) gra.getTranslateY();
            String xM = PozycjaX.getStringValueFromInt(xMaly);
            String yM = PozycjaY.getStringValueFromInt(yMaly);
            String xD = PozycjaX.getStringValueFromInt(xDuzy);
            String yD = PozycjaY.getStringValueFromInt(yDuzy);

            graBack.listView.getItems().add((graBack.MrLiczyKruk++)+"   ||   "+graBack.czyjaTura+"  ||       "+xD+yD+"       ||       "+xM+yM);


            imgAddToButton(graBack,gra);
            gra.wygranaPlanszyCoDalej(buttonNadPlanszowy);
            zasadyGryUltimate(graBack,xMaly,yMaly);

            graBack.FlipFlopGraczy();

            graBack.zmianaGracza();
        });
        this.getStyleClass().clear();
        this.getStyleClass().add("buttonGame");
        this.setCenterShape(true);
        this.setDisable(false);
    }
   public void imgAddToButton(graBack graBack,gra gra){
       if(gra.koniecGry||graBack.koniecGryDuzy){
           this.setDisable(true);
       } else if (znak ==-1) {

                if(graBack.czyjaTura=='x') {
                    newSVGShape xShape = new newSVGShape("M376.6 84.5c11.3-13.6 9.5-33.8-4.1-45.1s-33.8-9.5-45.1 4.1L192 206 56.6 43.5C45.3 29.9 25.1 28.1 11.5 39.4S-3.9 70.9 7.4 84.5L150.3 256 7.4 427.5c-11.3 13.6-9.5 33.8 4.1 45.1s33.8 9.5 45.1-4.1L192 306 327.4 468.5c11.3 13.6 31.5 15.4 45.1 4.1s15.4-31.5 4.1-45.1L233.7 256 376.6 84.5z");
                    znak = 1;
                    this.setGraphic(xShape);
                    this.setDisable(true);
                }else if(graBack.czyjaTura=='o'){
                    newSVGShape oShape = new newSVGShape("M224 96a160 160 0 1 0 0 320 160 160 0 1 0 0-320zM448 256A224 224 0 1 1 0 256a224 224 0 1 1 448 0z");
                    znak = 0;
                    this.setGraphic(oShape);
                    this.setDisable(true);
                }else {
               System.out.println("brak gracza, coś poszło nie tak....");
                        }
       }
    }
    public void zasadyGryUltimate(graBack graBack,int xMaly, int yMaly){

        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                graBack.plan2[x][y].setDisable(true);
                graBack.plan2[x][y].setStyle("-fx-background-color: #A7CAE5");
            }}
        if(!graBack.koniecGryDuzy) {
        graBack.plan2[xMaly][yMaly].setDisable(false);
        graBack.plan2[xMaly][yMaly].setStyle("-fx-background-color: #F9EAC2;");

            if (!graBack.plan2[xMaly][yMaly].isDisable() && graBack.plan2[xMaly][yMaly].buttonNadPlanszowy.WygranaPlansza != -1) {
                for (int x = 0; x < 3; x++) {
                    for (int y = 0; y < 3; y++) {
                        graBack.plan2[x][y].setDisable(false);
                        graBack.plan2[x][y].setStyle("-fx-background-color: #A7CAE5");

                    }
                }
            }
        if(graBack.plan2[xMaly][yMaly].isDisable()){
            if(!(graBack.plan2[xMaly][yMaly].buttonNadPlanszowy.WygranaPlansza==-1)){
                for (int x = 0; x < 3; x++) {
                    for (int y = 0; y < 3; y++) {
                        graBack.plan2[x][y].setDisable(false);
                        graBack.plan2[x][y].setStyle("-fx-background-color: #001e09");

                    }}}

        }


    }}
}