package com.example.tictactoe1;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Line;


public class gra extends GridPane {
    int ktoWygral;
    buttonGame[][] plan;
    boolean koniecGry;
    buttonNadPlanszowy buttonNadPlanszowy;
    gra(graBack graBack,buttonNadPlanszowy buttonNadPlanszowy){
        this.buttonNadPlanszowy=buttonNadPlanszowy;
        this.setId("GridPaneGraMala");
        plan =new buttonGame[3][3];

        String[] styleDoKratki = {
                "0 1 1 0", "0 1 1 1", "0 0 1 1",
                "1 1 1 0", "1 1 1 1", "1 0 1 1",
                "1 1 0 0", "1 1 0 1", "1 0 0 1"
        };
        int licznikKratek = 0;
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                buttonGame buttonGame1= new buttonGame(graBack,this,buttonNadPlanszowy);
                String stylKratki = styleDoKratki[licznikKratek];
                buttonGame1.setStyle("-fx-border-color: #e9ebf8;-fx-border-width: " + stylKratki);
                buttonGame1.setTranslateX((y));
                buttonGame1.setTranslateY((x));
                this.add(buttonGame1,y,x);
                plan[y][x]=buttonGame1;


                licznikKratek++;
                        }
                    }





    }

    public void wygranaPlanszyCoDalej(buttonNadPlanszowy buttonNadPlanszowy){
       if (remis()){
           buttonNadPlanszowy.setVisible(true);
           buttonNadPlanszowy.WygranaPlansza=3;
       }
        if(caleZasadyGry()){
                if(ktoWygral==1){
                    System.out.println("WYGRAL X");
                            newSVGShape svgS= new newSVGShape(220,220,"#e9ebf8",4,"#B8860B","M376.6 84.5c11.3-13.6 9.5-33.8-4.1-45.1s-33.8-9.5-45.1 4.1L192 206 56.6 43.5C45.3 29.9 25.1 28.1 11.5 39.4S-3.9 70.9 7.4 84.5L150.3 256 7.4 427.5c-11.3 13.6-9.5 33.8 4.1 45.1s33.8 9.5 45.1-4.1L192 306 327.4 468.5c11.3 13.6 31.5 15.4 45.1 4.1s15.4-31.5 4.1-45.1L233.7 256 376.6 84.5z");
                            buttonNadPlanszowy.setGraphic(svgS);
                            buttonNadPlanszowy.setVisible(true);
                            buttonNadPlanszowy.WygranaPlansza=1;
                } else if (ktoWygral==0) {
                    System.out.println("WYGRAL O");
                    newSVGShape svgS= new newSVGShape(220,220,"#e9ebf8",4,"#B8860B","M224 96a160 160 0 1 0 0 320 160 160 0 1 0 0-320zM448 256A224 224 0 1 1 0 256a224 224 0 1 1 448 0z");
                    buttonNadPlanszowy.setGraphic(svgS);
                    buttonNadPlanszowy.setVisible(true);
                    buttonNadPlanszowy.WygranaPlansza=0;
                }
        }
    }

    public boolean caleZasadyGry(){
        if(zasadaPion()||zasadaPoziom()||zasadaPrzekontnaLgDoPd()||zasadaPrzekontnaPgDoLd()){
            koniecGry=true;
            for (int x = 0; x < 3; x++) {for (int y = 0; y < 3; y++) {plan[y][x].setDisable(true);}}
            return true;
        }
        return false;
    }

    public boolean zasadaPion(){
        for(int j = 0;j<3;j++){
        if((plan[j][0].znak==plan[j][1].znak&&plan[j][0].znak==plan[j][2].znak)&& !(plan[j][0].znak ==-1)){
            ktoWygral= plan[j][0].znak;
            return true;
        }
    }
        return false;
    }
    public boolean zasadaPoziom(){
        for(int j = 0;j<3;j++){
            if((plan[0][j].znak==plan[1][j].znak&&plan[0][j].znak==plan[2][j].znak)&& !(plan[0][j].znak ==-1)){
                ktoWygral= plan[0][j].znak;
                return true;
            }
        }
        return false;
    }
    public boolean zasadaPrzekontnaLgDoPd(){
        if( plan[2][0].znak == plan[1][1].znak && plan[2][0].znak == plan[0][2].znak && !(plan[2][0].znak == -1)){
            ktoWygral= plan[2][0].znak;
            return true;
        }
        return false;
    }
    public boolean zasadaPrzekontnaPgDoLd(){
        if( plan[0][0].znak == plan[1][1].znak && plan[0][0].znak == plan[2][2].znak && !(plan[0][0].znak == -1)){
            ktoWygral= plan[0][0].znak;
            return true;
        }
        return false;
    }
    public boolean remis() {
        if (!koniecGry) {
            for (int x = 0; x < 3; x++) {
                for (int y = 0; y < 3; y++) {
                    if ((plan[y][x].znak == -1)) {
                        return false;
                    }
                }
            }
            koniecGry=true;
        }
        return true;
    }





}
