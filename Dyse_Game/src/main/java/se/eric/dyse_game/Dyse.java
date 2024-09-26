package se.eric.dyse_game;

import java.util.Random;

public class Dyse {
    private Random rand = new Random();
    private int diceThrow;
    private int diceSids;                                       //kommer alltid vara sex siding men lämnar rum för utveckling

    public Dyse(int diceSids) {
        this.diceSids = diceSids;
    }

    public int playerThrow(Player player) {
        diceThrow = rand.nextInt(diceSids) + 1;
        System.out.println("Player  " + player.getName() + " hase thrown a " + diceThrow);
        return diceThrow;
    }                                                           //returner ett värde mellan 1 och 6 och skriver utt att spelaren har fåt det resultat

}
