package se.eric.dyse_game;

import java.util.Scanner;

public class InputHandler {
    private static Scanner scan = new Scanner(System.in);


    public String getLine(){
        return  scan.nextLine();
    }

    public boolean getContinue(){
        while (true) {
            System.out.print("do you what to continue (Y/N):");
            scan = new Scanner(System.in);
            char input = scan.next().charAt(0);
            if (input == 'Y') {
                return true;
            } else if (input == 'N') {
                return false;
            } else {
                System.out.println("Wrong input");
            }                                                           //Frågar om cåden ska fortsätta tills den får svar Y (YES) eller N (NO)
        }
    }

    public int getPlayRonds(){

        boolean oGiltigt;
        int rounds = 0;
        do {
            try {
                System.out.print("How many rounds: ");
                scan = new Scanner(System.in);
                rounds = scan.nextInt();                                    //frågar efter hur många rundor man vill köra
                if (rounds > 0) {                                           //tittar efter ifall det har uppstått nåra fell
                    oGiltigt = false;
                } else {                                                    //går in ifall inmatningen är under 1
                    System.out.println("Wrong input");
                    oGiltigt = true;
                }
            } catch (Exception e) {                                         //går in ifall inmatningen inte är en int
                System.out.println("Wrong input");
                oGiltigt = true;
            }
        }while (oGiltigt);
        return rounds;
    }
}
