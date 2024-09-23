package se.eric.dyse_game;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    private static Player player1;
    private static Player player2;
    private static Dyse dyse = new Dyse(6);
    private static Scanner scan = new Scanner(System.in);
    private static int rounds;                                          //declarer all mina variable

    public static void main(String[] args) {
        System.out.println("Welcome to Dyse Game");
        System.out.print("What is player 1 name: ");
        player1 = new Player(scan.nextLine());                          //frågar efter spelarnas name och sparar det
        player2 = new Player();                                         //gjorde på två set bara för att jag kan

        boolean conntinus = true;
        while (conntinus) {
            conntinus = playGame();
            player1.restetWins();
            player2.restetWins();
        }
        System.out.println("Thanks for playing!");

    }


    private static boolean playGame() {
        boolean oGiltigt;
        do {
            try {
                System.out.print("How many rounds: ");
                scan = new Scanner(System.in);
                rounds = scan.nextInt();                                //frågar efter hur många runder man vill köra
                if (rounds > 0) {                                       //titar efter ifall det har uppstått nåra fell
                    oGiltigt = false;
                } else {                                                  //går in ifall inmatningen är under 1
                    System.out.println("Wrong input");
                    oGiltigt = true;
                }
            } catch (Exception e) {                                         //går in ifall inmatingen inte är en int
                System.out.println("Wrong input");
                oGiltigt = true;
            }
        } while (oGiltigt);


        for (int i = 0; i < rounds; i++) {                              //gör en lop av metoden playerRound så många gåner som har sats tidigare
            playerRound();
        }
        System.out.println(player1.getName() + " has won " + player1.getWins() + " times, "           //skriver utt totalen
                + player2.getName() + " has won " + player2.getWins() + " times and ther was " +
                (rounds - (player1.getWins() + player2.getWins())) + " ties");

        if (player1.getWins() < player2.getWins()) {                                               //titar vem som har vunnit och skriver utt det
            System.out.println(player2.getName() + " HAS WON");
        } else if (player2.getWins() < player1.getWins()) {
            System.out.println(player1.getName() + " HAS WON");
        } else if (player1.getWins() == player2.getWins()) {
            System.out.println("This game was a tie");
        } else {
            System.out.println("Error 2");
        }
        while (true) {
            System.out.print("do you whant to conntinu (Y/N):");
            scan = new Scanner(System.in);
            char input = scan.next().charAt(0);
            if (input == 'Y') {
                return true;
            } else if (input == 'N') {
                return false;
            } else {
                System.out.println("Wrong input");
            }
        }
    }


    private static void playerRound() {                                          //kör en runde av spelet
        player1.setDyseRolle(dyse.playerTro(player1));
        player2.setDyseRolle(dyse.playerTro(player2));                          //gör ett tärnings kas för varje splerare och sparar det

        if (player1.getDyseRolle() < player2.getDyseRolle()) {                    //titar vem som van och sparar det
            player2.hasWon();
            System.out.println(player2.getName() + " won and has won " + player2.getWins() + " times");
        } else if (player2.getDyseRolle() < player1.getDyseRolle()) {
            player1.hasWon();
            System.out.println(player1.getName() + " has won and has won " + player1.getWins() + " times");

        } else if (player1.getDyseRolle() == player2.getDyseRolle()) {
            System.out.println("This round was a tye");
        } else {
            System.out.println("Error 1");                                      //ifall något går fell
        }
        scan = new Scanner(System.in);
        scan.nextLine();                                                        //väntar på user input inan det fortsäter
    }
}
