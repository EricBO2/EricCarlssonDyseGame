package se.eric.dyse_game;

import java.util.Scanner;

public class Player {
    private String name;
    private int wins = 0;
    private int dyseRolle;                      //deklarerar variabler

    public Player(String name) {                //construktor
        this.name = name;
    }

    public Player() {                            //andra consstruktor
        System.out.print("What is player 2 name: ");
        Scanner scan = new Scanner(System.in);
        name = scan.nextLine();
    }

    public String getName() {                   //get och seters
        return name;
    }

    public int getWins() {
        return wins;
    }

    public void restetWins(){
        wins = 0;
    }

    public int getDyseRolle() {
        return dyseRolle;
    }

    public void setDyseRolle(int dyseRolle) {
        this.dyseRolle = dyseRolle;
    }

    public void hasWon() {                      //metod för att spara att speleren har vunnit en gång
        wins++;
    }

}
