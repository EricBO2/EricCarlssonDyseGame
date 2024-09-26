package se.eric.dyse_game;

import java.util.Scanner;

public class Main {
    private static Player player1;
    private static Player player2;
    private static Dyse dyse ;
    private static InputHandler inputHandler = new InputHandler();
    private static int rounds;                                          //declarer all mina variable

    public static void main(String[] args) {
        System.out.println("Welcome to Dice Game");
        System.out.print("What is player 1 name: ");
        player1 = new Player(inputHandler.getLine());                   //frågar efter spelarnas name och sparar det
        System.out.print("What is player 2 name: ");
        player2 = new Player(inputHandler.getLine());                             //gjorde på två set för att demonstrate två set att göra det och för att jag gillar att använda overload
        dyse = new Dyse(inputHandler.getInt("How many sided dyes: ", 1));



        boolean cont = true;
        while (cont) {
            cont = playGame();
            player1.restetWins();
            player2.restetWins();
        }
        System.out.println("Thanks for playing!");
        inputHandler.closeScanner();

    }


    private static boolean playGame() {
        rounds =inputHandler.getInt("How many rounds: ",1);


        for (int i = 0; i < rounds; i++) {                                                              //gör en lop av metoden playerRound så många gånger som har sats tidigare
            playerRound();
        }
        System.out.println(player1.getName() + " has won " + player1.getWins() + " times, "             //skriver utt totalen
                + player2.getName() + " has won " + player2.getWins() + " times and there was " +
                (rounds - (player1.getWins() + player2.getWins())) + " ties");

        calkWinner();

        return inputHandler.getContinue();
    }



    private static void calkWinner(){
        if (player1.getWins() < player2.getWins()) {                    //tittar vem som har vunnit och skriver utt det
            System.out.println(player2.getName() + " HAS WON");
        } else if (player2.getWins() < player1.getWins()) {
            System.out.println(player1.getName() + " HAS WON");
        } else if (player1.getWins() == player2.getWins()) {
            System.out.println("This game was a tie");
        } else {
            System.out.println("Error 2 (game winner has gon wrong)");
        }
    }


    private static void playerRound() {                                          //kör en runde av spelet
        player1.setDyseRolle(dyse.playerThrow(player1));
        player2.setDyseRolle(dyse.playerThrow(player2));                          //gör ett tärnings kas för varje spelare och sparar det

        if (player1.getDyseRolle() < player2.getDyseRolle()) {                    //tittar vem som van och sparar det
            player2.hasWon();
            System.out.println(player2.getName() + " won and has won " + player2.getWins() + " times");
        } else if (player2.getDyseRolle() < player1.getDyseRolle()) {
            player1.hasWon();
            System.out.println(player1.getName() + " has won and has won " + player1.getWins() + " times");

        } else if (player1.getDyseRolle() == player2.getDyseRolle()) {
            System.out.println("This round was a tye");
        } else {
            System.out.println("Error 1 (round winn has gone wrong)");                                      //ifall något går fell
        }
        inputHandler.getLine();                                                      //väntar på user input innan det fortsätter
    }
}
