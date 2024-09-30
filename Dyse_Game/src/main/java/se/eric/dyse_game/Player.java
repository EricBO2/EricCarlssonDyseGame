package se.eric.dyse_game;


public class Player {
    private String name;
    private int wins = 0;           //deklarerar variabler

    public Player(String name) {                //constructor
        this.name = name;
    }


    public String getName() {                   //get och setters
        return name;
    }

    public int getWins() {
        return wins;
    }

    public void restetWins(){
        wins = 0;
    }



    public void hasWon() {                      //metod för att spara att speleren har vunnit en gång
        wins++;
    }

}
