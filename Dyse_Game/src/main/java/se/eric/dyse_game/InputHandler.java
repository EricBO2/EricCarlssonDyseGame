package se.eric.dyse_game;

import java.util.Scanner;

public class InputHandler {
    private static Scanner scan ;

    public InputHandler() {
        scan = new Scanner(System.in);
    }

    public String getLine(){
        return  scan.nextLine();
    }

    public boolean getContinue(){
        while (true) {
            System.out.print("do you what to continue (Y/N):");
            Scanner sc = new Scanner(System.in);                        //ett fel om jag andväder samma scaner här som överallt annars
            char input = sc.next().charAt(0);
            if (input == 'Y' || input == 'y') {
                return true;
            } else if (input == 'N' || input == 'n') {
                return false;
            } else {
                System.out.println("Wrong input");
            }                                                           //Frågar om cåden ska fortsätta tills den får svar Y (YES) eller N (NO)
        }
    }

    public int getInt(String message, int min){

        boolean oGiltigt;
        int number = 0;
        do {
            try {
                System.out.print(message);
                number = Integer.parseInt( scan.nextLine());                //frågar efter ett number

                if (number > min) {                                         //tittar efter ifall det har uppstått nåra fell
                    oGiltigt = false;
                } else {                                                    //går in ifall inmatningen är under minimum värdet
                    System.out.println("Wrong input1 (below min)");
                    oGiltigt = true;
                }
            } catch (Exception e) {                                         //går in ifall inmatningen inte är en int
                //System.out.println(e.getMessage());
                System.out.println("Wrong input (Not a INT)");
                oGiltigt = true;
            }
        }while (oGiltigt);
        return number;
    }

    public void closeScanner(){
        scan.close();
    }

}
