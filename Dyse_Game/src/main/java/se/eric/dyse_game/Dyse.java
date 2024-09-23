package se.eric.dyse_game;

import java.util.Random;

public class Dyse {
    private Random rand = new Random();
    private int dyseTrow;
    private int dyseSids;                                       //kommer alltid vara sex sidigt men lämnar rum för uttväkling

    public Dyse(int dyseSids) {
        this.dyseSids = dyseSids;
    }

    public int playerTro(Player player) {
        dyseTrow = rand.nextInt(dyseSids) + 1;
        System.out.println("Player  " + player.getName() + " hase trown a " + dyseTrow);
        return dyseTrow;
    }                                                           //returnar ett värde mellan 1 och 6 och skriver utt att spelaren har fåt det resultate
}
