package com.example.tictactoe1;

import java.util.Random;

public class minion {
    minion(graBack graBack,boolean turaBota,boolean ruchWykonany,int lvlMiniona) {
        if(lvlMiniona==-1){
          //  System.out.println("pvp: -1");
        }
       else if(lvlMiniona==0){
          //  System.out.println("Bot LoopPion: 0");
            myTurn0(graBack,turaBota);
        }
       else if(lvlMiniona==1) {
           // System.out.println("Bot Random: 1");
            myTurn1(graBack, turaBota, ruchWykonany);
        }
       else if(lvlMiniona==2) {
            // System.out.println("Bot Loop(Random): 4");
            myTurn2(graBack,turaBota,ruchWykonany);
        }
       else if(lvlMiniona==3) {
            System.out.println("Bot Loop(Random): 3");
            myTurn4(graBack,turaBota,ruchWykonany);
        }
//       else if(lvlMiniona==4) {
//           // System.out.println("Bot Loop(Random): 4");
//            myTurn4(graBack,turaBota,ruchWykonany);
//        }
//       else if(lvlMiniona==5) {
//           // System.out.println("Bot Loop(Random): 5");
//            myTurn5(graBack,turaBota,ruchWykonany);
//        }




}

        //Ten bot leci cały czas w dół
           public void myTurn0(graBack graBack, boolean turaBota){
            if(turaBota){
                xx:
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        for (int k = 0; k < 3; k++) {
                            for (int l = 0; l < 3; l++) {
                                if ((!(graBack.plan2[i][j].plan[k][l].isDisable()))&&(!graBack.plan2[i][j].isDisable())) {
                                        graBack.plan2[i][j].plan[k][l].fire();
                                    break xx;
                                }
                            }
                        }
                    }
                }
            }

           }

           //Ten bot wybiera losowe pole
    public void myTurn1(graBack graBack, boolean turaBota,boolean ruchWykonany){
        if(turaBota&&(!graBack.koniecGryDuzy)){
            do {
                Random random = new Random();
                int randomX = random.nextInt(3);
                int randomY = random.nextInt(3);
                int randomDuzyX = random.nextInt(3);
                int randomDuzyY = random.nextInt(3);
                if (((!(graBack.plan2[randomDuzyX][randomDuzyY].plan[randomX][randomY].isDisable())) && (!graBack.plan2[randomDuzyX][randomDuzyY].isDisable())&&(graBack.plan2[randomDuzyX][randomDuzyY].plan[randomX][randomY].znak!=1)&&((graBack.plan2[randomDuzyX][randomDuzyY].plan[randomX][randomY].znak!=0)))) {
                    graBack.plan2[randomDuzyX][randomDuzyY].plan[randomX][randomY].fire();
                    System.out.println("BOT : <3");
                    ruchWykonany=true;
                    //
                    turaBota=false;
                    break;
                }
            }while (!ruchWykonany);
        }

    }

    //Ten bot używa algorytmu minmax
    public void myTurn2(graBack graBack, boolean turaBota, boolean ruchWykonany) {
        if(turaBota){
            xx:
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    for (int k = 0; k < 3; k++) {
                        for (int l = 0; l < 3; l++) {
                            if ((!(graBack.plan2[j][i].plan[l][k].isDisable()))&&(!graBack.plan2[j][i].isDisable())) {
                                graBack.plan2[j][i].plan[l][k].fire();
                                break xx;
                            }
                        }
                    }
                }
            }
        }
    }

    public void myTurn3(graBack graBack,boolean turaBota,boolean ruchWykonany){
       buttonGame[] buttonArray = new buttonGame[3];

        boolean kolejnosc=false;
        xx:
        for(int i =0;i<3;i++){
            for(int j=0;j<3;j++) {
                if(!graBack.plan2[i][i].plan[j][j].isDisable()) {
                  buttonGame b1= graBack.plan2[i][i].plan[j][j];
                  buttonArray[0]=b1;

                    kolejnosc=true;
                    ruchWykonany=true;
                    break xx;
                }
            }
        }
    }
    //Bot Edzio ;3
    public void myTurn4(graBack graBack, boolean turaBota, boolean ruchWykonany){
        if(turaBota){
            xx:
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    for (int k = 0; k < 3; k++) {
                        for (int l = 0; l < 3; l++) {
                            gra plansza  = graBack.plan2[i][j];
                            if(!plansza.isDisable()){
                                Random random = new Random();
                                int ff = random.nextInt(7);
                                switch (ff){
                                    case 0:
                                        if (!plansza.plan[k][l].isDisable()) {
                                            plansza.plan[k][l].fire();
                                            break xx;
                                        }
                                    case 1:
                                        if (!plansza.plan[l][k].isDisable()) {
                                            plansza.plan[l][k].fire();
                                            break xx;
                                        }
                                    case 2:
                                        if (!plansza.plan[0][0].isDisable()) {
                                            plansza.plan[0][0].fire();
                                            break xx;
                                        }
                                    case 3:
                                        if (!plansza.plan[1][1].isDisable()) {
                                            plansza.plan[1][1].fire();
                                            break xx;
                                        }
                                    case 4:
                                        if (!plansza.plan[2][2].isDisable()) {
                                            plansza.plan[2][2].fire();
                                            break xx;
                                        }
                                    case 5:
                                        if (!plansza.plan[0][2].isDisable()) {
                                            plansza.plan[0][2].fire();
                                            break xx;
                                        }
                                    case 6:
                                        if (!plansza.plan[2][0].isDisable()) {
                                            plansza.plan[2][0].fire();
                                            break xx;
                                        }
                                    default:

                                }

                            }
                        }
                    }
                }
            }
        }
    }

    public void myTurn5(graBack graBack, boolean turaBota, boolean ruchWykonany){
        if(turaBota&&(!graBack.koniecGryDuzy)){
            do {
                for(int i =0;i<3;i++) {
                    Random random = new Random();
                    int randomX = random.nextInt(3);
                    int randomDuzyX = random.nextInt(3);
                    int randomDuzyY = random.nextInt(3);
                    if (((!(graBack.plan2[randomDuzyX][randomDuzyY].plan[randomX][i].isDisable())) && (!graBack.plan2[randomDuzyX][randomDuzyY].isDisable()) && (graBack.plan2[randomDuzyX][randomDuzyY].plan[randomX][i].znak != 1) && ((graBack.plan2[randomDuzyX][randomDuzyY].plan[randomX][i].znak != 0)))) {
                        graBack.plan2[randomDuzyX][randomDuzyY].plan[randomX][i].fire();
                        System.out.println("BOT : <3");
                        ruchWykonany = true;
                        //
                        turaBota = false;
                        break;
                    } else if (((!(graBack.plan2[randomDuzyX][randomDuzyY].plan[i][randomX].isDisable())) && (!graBack.plan2[randomDuzyX][randomDuzyY].isDisable()) && (graBack.plan2[randomDuzyX][randomDuzyY].plan[i][randomX].znak != 1) && ((graBack.plan2[randomDuzyX][randomDuzyY].plan[i][randomX].znak != 0)))) {
                        graBack.plan2[randomDuzyX][randomDuzyY].plan[i][randomX].fire();
                        System.out.println("BOT : <3");
                        ruchWykonany = true;
                        //
                        turaBota = false;
                        break;
                    }
                }
            }while (!ruchWykonany);
        }
    }



}
