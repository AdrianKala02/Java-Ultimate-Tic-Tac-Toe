package com.example.tictactoe1;

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.*;

public class menu extends BorderPane{
    final VBox menuMain;
    Button buttonStartGame;


    menu() {
        menuMain = new VBox();
        menuMain.setId("menuMain");

        Label label2 =new Label();
        label2.setText("Wybierz rodzaj rozgrywki: ");

        Label label3 =new Label();
        label3.setText("Kto zaczyna: ");

        Label label4 =new Label();
        label4.setText("Wybierz poziom bota: ");

        BorderPane borderPane0 = new BorderPane();
        borderPane0.getStyleClass().add("menuPane");
        buttonStartGame = new Button("START");
        buttonStartGame.setId("buttonStartGame");

        borderPane0.setCenter(buttonStartGame);




        RadioButton radioButton0 = new RadioButton("pz 0");
        RadioButton radioButton1 = new RadioButton("pz 1");
        RadioButton radioButton2 = new RadioButton("pz 2");
        RadioButton radioButton3 = new RadioButton("pz 3");

        ToggleGroup toggleGroup2 = new ToggleGroup();

        radioButton0.setToggleGroup(toggleGroup2);
        radioButton1.setToggleGroup(toggleGroup2);
        radioButton2.setToggleGroup(toggleGroup2);
        radioButton3.setToggleGroup(toggleGroup2);

        radioButton0.setSelected(true);



        TilePane tilePane2 = new TilePane();
        tilePane2.getChildren().add(radioButton0);
        tilePane2.getChildren().add(radioButton1);
        tilePane2.getChildren().add(radioButton2);
        tilePane2.getChildren().add(radioButton3);
        tilePane2.getStyleClass().add("menuPane");
        tilePane2.setAlignment(Pos.CENTER);
        tilePane2.setPadding(new Insets(10));
        tilePane2.setHgap(30);
        tilePane2.setVgap(10);


        RadioButton radioButtonKtoZaczynaJa = new RadioButton("Ja");
        radioButtonKtoZaczynaJa.setOnAction(actionEvent -> {
            menuMain.getChildren().remove(label4);             // wybierz poziom bota:
            menuMain.getChildren().remove(tilePane2);          // pz0 pz1 pz2 pz3
            menuMain.getChildren().remove(borderPane0);        // start
            menuMain.getChildren().add(label4);             // wybierz poziom bota:
            menuMain.getChildren().add(tilePane2);          // pz0 pz1 pz2 pz3
            menuMain.getChildren().add(borderPane0);        // start
        });

        RadioButton radioButtonKtoZaczynaBot = new RadioButton("Bot");
        radioButtonKtoZaczynaBot.setOnAction(actionEvent -> {
            menuMain.getChildren().remove(label4);             // wybierz poziom bota:
            menuMain.getChildren().remove(tilePane2);          // pz0 pz1 pz2 pz3
            menuMain.getChildren().remove(borderPane0);        // start
            menuMain.getChildren().add(label4);             // wybierz poziom bota:
            menuMain.getChildren().add(tilePane2);          // pz0 pz1 pz2 pz3
            menuMain.getChildren().add(borderPane0);        // start
        });

        ToggleGroup toggleGroup1 = new ToggleGroup();

        radioButtonKtoZaczynaJa.setToggleGroup(toggleGroup1);
        radioButtonKtoZaczynaBot.setToggleGroup(toggleGroup1);

        TilePane tilePane1 = new TilePane();
        tilePane1.getChildren().add(radioButtonKtoZaczynaJa);
        tilePane1.getChildren().add(radioButtonKtoZaczynaBot);

        tilePane1.getStyleClass().add("menuPane");
        tilePane1.setAlignment(Pos.CENTER);
        tilePane1.setPadding(new Insets(10));
        tilePane1.setHgap(30);



        RadioButton radioButtonPve = new RadioButton("pve(bot)");
        radioButtonPve.setOnAction(actionEvent -> {
            menuMain.getChildren().remove(borderPane0);     // start
            menuMain.getChildren().add(label3);             // kto zaczyna
            menuMain.getChildren().add(tilePane1);        // ja bot
        });

        RadioButton radioButtonPvp = new RadioButton("pvp(turowo)");
        radioButtonPvp.setOnAction(actionEvent -> {
            menuMain.getChildren().remove(borderPane0);     // start
            menuMain.getChildren().remove(label3);          // kto zaczyna
            menuMain.getChildren().remove(tilePane1);     // ja bot
            menuMain.getChildren().remove(label4);          // wybierz poziom bota:
            menuMain.getChildren().remove(tilePane2);       // pz0 pz1 pz2 pz3
            menuMain.getChildren().add(borderPane0);        // start
        });

        ToggleGroup toggleGroup0 = new ToggleGroup();
        radioButtonPve.setToggleGroup(toggleGroup0);
        radioButtonPvp.setToggleGroup(toggleGroup0);


        TilePane tilePane0 = new TilePane(Orientation.HORIZONTAL);
        tilePane0.getChildren().add(radioButtonPve);
        tilePane0.getChildren().add(radioButtonPvp);

        tilePane0.getStyleClass().add("menuPane");
        tilePane0.setAlignment(Pos.CENTER);
        tilePane0.setPadding(new Insets(10));
        tilePane0.setHgap(40);


        buttonStartGame.setOnAction(actionEvent -> {
            Character czyjaTura='x';
            if (toggleGroup0.getSelectedToggle().equals(radioButtonPve)){
                if (!toggleGroup1.getSelectedToggle().equals(radioButtonKtoZaczynaJa)) {
                    czyjaTura = 'o';
                }
                if(toggleGroup2.getSelectedToggle().equals(radioButton0)){
                    setCenter(new maskPlusGAME(czyjaTura,0));
                } else if (toggleGroup2.getSelectedToggle().equals(radioButton1)) {
                    setCenter(new maskPlusGAME(czyjaTura,1));
                }else if (toggleGroup2.getSelectedToggle().equals(radioButton2)) {
                    setCenter(new maskPlusGAME(czyjaTura,2));
                }else if (toggleGroup2.getSelectedToggle().equals(radioButton3)) {
                    setCenter(new maskPlusGAME(czyjaTura,3));
                }
            }else{
                setCenter(new maskPlusGAME(czyjaTura,-1));
            }
        });
        menuMain.getChildren().addAll(label2,tilePane0);
            this.setCenter(menuMain);
    }
}
