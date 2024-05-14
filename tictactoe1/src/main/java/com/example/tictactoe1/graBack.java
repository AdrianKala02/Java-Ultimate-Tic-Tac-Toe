package com.example.tictactoe1;

import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;

public class graBack extends BorderPane{

    GridPane test1;
    Label label;
    Character czyjaTura;
    gra[][] plan2;
    boolean turaBota;
    boolean koniecGryDuzy;
    int ktoWygralDuzy;
    ListView <String>listView;
    Integer MrLiczyKruk =0;
    boolean ruchWykonany;
    int lvlMiniona;

    graBack(char czyjaTura,int lvlMiniona){
        this.lvlMiniona=lvlMiniona;
        this.czyjaTura=czyjaTura;
        label = new Label();
        label.setText("Rozpoczyna: "+czyjaTura);
        label.setStyle("-fx-font-size: 40;-fx-translate-x: -200");
        label.setAlignment(Pos.CENTER);
        this.setTop(label);
        this.setId("graMain");
        BorderPane.setAlignment(label,Pos.CENTER);
        //============LOG-GRY-SCROLLPANE-I-INNE===========
        listView = new ListView<>();
        listView.setId("listViewLogRozgrywki");
        listView.getItems().add("Nr. || Tura || Główna Plansza || Mała Plansza");
        Label logRozgrywki = new Label("Log Gry");
        logRozgrywki.setStyle("-fx-font-size: 40;-fx-border-radius: 0");
        VBox vBox = new VBox();
        vBox.getChildren().add(logRozgrywki);
        vBox.getChildren().add(listView);
        VBox.setVgrow(listView, Priority.ALWAYS);
        vBox.setStyle("-fx-border-width: 0 0 0 3;-fx-border-color: #e9ebf8");

        this.setRight(vBox);
        //========================================




       plan2 =new gra[3][3];
       test1 = new GridPane();

        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
               buttonNadPlanszowy buttonNadPlanszowy =new buttonNadPlanszowy();
                gra gra1= new gra( this,buttonNadPlanszowy);
                gra1.setTranslateX((y));
                gra1.setTranslateY((x));
                gra1.setDisable(false);
                //============LOGIKADUŻEJPLANSZY======
                 StackPane stackPane= new StackPane(gra1,buttonNadPlanszowy);
                 gra1.setAlignment(Pos.CENTER);
                test1.add(stackPane,y,x);
                plan2[y][x]=gra1;
            }
        }
        this.setCenter(test1);
        this.test1.setAlignment(Pos.CENTER);
        if(czyjaTura=='o') {
            new minion(this, true, false, lvlMiniona);
        }
}
//    public void handleKeyPress(KeyEvent event) {
//
//        KeyCode[] klawisze ={KeyCode.DIGIT1,KeyCode.DIGIT2,KeyCode.DIGIT3,KeyCode.DIGIT4,KeyCode.DIGIT5,KeyCode.DIGIT6,KeyCode.DIGIT7,KeyCode.DIGIT8,KeyCode.DIGIT9};
//
//            if (event.getCode() == klawisze[0]) {
//                System.out.println("SSSSSS");
//                plan2[0][0].plan[0][0].fire();
//            }else if (event.getCode() == klawisze[1]) {
//                plan2[0][0].plan[0][1].fire();
//            }else if (event.getCode() == klawisze[2]) {
//                plan2[0][0].plan[0][2].fire();
//            }
//
//        }


    public void zmianaGracza(){

        label.setText("Tura gracza: "+czyjaTura);
        if (remisDuzy()){
            label.setText("REMIS...");
        }
        caleZasadyGryDuzy();
        if(!koniecGryDuzy) {
            new minion(this, turaBota,ruchWykonany,lvlMiniona);
        }
    }
    public void FlipFlopGraczy(){
        if(czyjaTura=='x'){
            czyjaTura='o';
            turaBota=true;
        }else {
            turaBota=false;
            czyjaTura='x';
        }
    }
    public void FlipFlopGraczy2(){
        if(czyjaTura=='o'){
            czyjaTura='x';
            turaBota=true;
        }else {
            turaBota=false;
            czyjaTura='o';
        }
    }
    public void caleZasadyGryDuzy(){
        if( zasadaPionDuzy() || zasadaPoziomDuzy() || zasadaPrzekontnaLgDoPdDuzy() || zasadaPrzekontnaPgDoLdDuzy()){
            koniecGryDuzy=true;
            for (int x = 0; x < 3; x++) {for (int y = 0; y < 3; y++) {plan2[y][x].setDisable(true);}}
            if (ktoWygralDuzy == 1) {
                label.setText("WYGRYWA GRACZ X");
            } else if (ktoWygralDuzy == 0) {
                label.setText("WYGRYWA GRACZ O");
            }
        }
    }
    public boolean zasadaPionDuzy(){
        for (int j = 0; j < 3; j++) {
            if((plan2[j][0].buttonNadPlanszowy.WygranaPlansza==plan2[j][1].buttonNadPlanszowy.WygranaPlansza&&plan2[j][0].buttonNadPlanszowy.WygranaPlansza==plan2[j][2].buttonNadPlanszowy.WygranaPlansza)&&!(plan2[j][0].buttonNadPlanszowy.WygranaPlansza==-1)){
                koniecGryDuzy=true;
                if(plan2[j][0].buttonNadPlanszowy.WygranaPlansza==1){
                    System.out.println("X wygrywa PION");
                    label.setText("X wygrywa PION");
                    ktoWygralDuzy=1;
                    return true;
                } else if (plan2[j][0].buttonNadPlanszowy.WygranaPlansza==0) {
                    System.out.println("O wygrywa PION");
                    label.setText("O wygrywa PION");
                    ktoWygralDuzy=0;
                    return true;
                }
            }
            }
        return false;
    }
    public boolean zasadaPoziomDuzy(){
        for (int j = 0; j < 3; j++) {
            if((plan2[0][j].buttonNadPlanszowy.WygranaPlansza==plan2[1][j].buttonNadPlanszowy.WygranaPlansza&&plan2[0][j].buttonNadPlanszowy.WygranaPlansza==plan2[2][j].buttonNadPlanszowy.WygranaPlansza)&&!(plan2[0][j].buttonNadPlanszowy.WygranaPlansza==-1)){
                koniecGryDuzy=true;
                if(plan2[0][j].buttonNadPlanszowy.WygranaPlansza==1){
                    System.out.println("X wygrywa POZIOM");
                    label.setText("X wygrywa POZIOM");
                    ktoWygralDuzy=1;
                    return true;
                } else if (plan2[0][j].buttonNadPlanszowy.WygranaPlansza==0) {
                    System.out.println("O wygrywa POZIOM");
                    label.setText("O wygrywa POZIOM");
                    ktoWygralDuzy=0;
                    return true;
                }
            }
        }
        return false;
    }
    public boolean zasadaPrzekontnaLgDoPdDuzy(){
        if( plan2[2][0].buttonNadPlanszowy.WygranaPlansza== plan2[1][1].buttonNadPlanszowy.WygranaPlansza && plan2[2][0].buttonNadPlanszowy.WygranaPlansza == plan2[0][2].buttonNadPlanszowy.WygranaPlansza && !(plan2[2][0].buttonNadPlanszowy.WygranaPlansza == -1)){
            koniecGryDuzy=true;
            if(plan2[2][0].buttonNadPlanszowy.WygranaPlansza==1){
                System.out.println("X wygrywa SKOSLgDoPdDuzy");
                label.setText("X wygrywa SKOSLgDoPdDuzy");
                ktoWygralDuzy=1;
                return true;
            } else if (plan2[2][0].buttonNadPlanszowy.WygranaPlansza==0) {
                System.out.println("O wygrywa SKOSLgDoPdDuzy");
                label.setText("O wygrywa SKOSLgDoPdDuzy");
                ktoWygralDuzy=0;
                return true;
            }
        }
        return false;
    }
    public boolean zasadaPrzekontnaPgDoLdDuzy(){
        if( plan2[0][0].buttonNadPlanszowy.WygranaPlansza== plan2[1][1].buttonNadPlanszowy.WygranaPlansza && plan2[0][0].buttonNadPlanszowy.WygranaPlansza == plan2[2][2].buttonNadPlanszowy.WygranaPlansza && !(plan2[0][0].buttonNadPlanszowy.WygranaPlansza == -1)){
            koniecGryDuzy=true;
            if(plan2[0][0].buttonNadPlanszowy.WygranaPlansza==1){
                System.out.println("X wygrywa SKOSPgDoLdDuzy");
                label.setText("X wygrywa SKOSPgDoLdDuzy");
                ktoWygralDuzy=1;
                return true;
            } else if (plan2[0][0].buttonNadPlanszowy.WygranaPlansza==0) {
                System.out.println("O wygrywa SKOSPgDoLdDuzy");
                label.setText("O wygrywa SKOSPgDoLdDuzy");
                ktoWygralDuzy=0;
                return true;
            }
        }
        return false;
    }
    public boolean remisDuzy() {
        if (!koniecGryDuzy) {
            for (int x = 0; x < 3; x++) {
                for (int y = 0; y < 3; y++) {
                    if (plan2[y][x].buttonNadPlanszowy.WygranaPlansza==-1) {
                        return false;
                    }
                }
            }
            koniecGryDuzy=true;
        }
        return true;
    }









    ///=======end
}

