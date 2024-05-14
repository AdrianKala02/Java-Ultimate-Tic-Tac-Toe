package com.example.tictactoe1;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import java.io.IOException;

public class HelloApplication extends Application {


    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {

//======================================================================
//======================================================================

        BorderPane root = new BorderPane();
        root.setCenter( new ekranHello());
        Scene scene =new Scene(root);
        menuLeft menuLeft1 = new menuLeft();
        root.setLeft(menuLeft1.menuLeftMain);

      //  gra2.czyjaTura='o';             //dodać to do radiobuttona przy wyborze kto zaczyna
      //  root.setCenter(new graBack());   //test GRY po testach usunąć i odkomentować linie 44
      //  menu1.buttonStartGame.setOnAction(actionEvent -> root.setCenter(new graBack('x',1)));
        menuLeft1.buttonPLAY.setOnAction(actionEvent -> root.setCenter(new menu()));
        menuLeft1.buttonMenu.setOnAction(actionEvent -> {root.getChildren().clear();root.setLeft(menuLeft1.menuLeftMain);root.setCenter(new ekranHello());});
        menuLeft1.buttonSetting.setOnAction(actionEvent -> root.setCenter(new setting()));
        menuLeft1.buttonInfo.setOnAction(actionEvent -> root.setCenter(new informacion()));
        //=====================================================================


        //======================================================================
       // stage.initStyle(StageStyle.UNDECORATED);
//        scene.setOnKeyPressed(event -> {
//            graBack gra = new graBack('x',2);
//            gra.handleKeyPress(event);
//            System.out.println(event.getCode());
//        });
        stage.setScene(scene);
        stage.setWidth(800);
        stage.setHeight(800);
        stage.show();
        scene.getStylesheets().add("style.css");
         final StringProperty windowTitle = new SimpleStringProperty();                                                 //do informacji o rozmiarze aplikacji
        windowTitle.bind(stage.widthProperty().asString().concat(" x ").concat(stage.heightProperty().asString()));  //
        stage.titleProperty().bind(windowTitle);                                                                        //

    }
}