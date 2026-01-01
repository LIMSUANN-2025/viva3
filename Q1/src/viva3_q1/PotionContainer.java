package viva3_q1;

import viva3_q1.Potion;
import java.util.ArrayList;

public class PotionContainer {
    private ArrayList<Potion> potions;

    public PotionContainer() {
        potions = new ArrayList<>();
    }

    public void addPotion(String ingredient, double volume) {
        Potion p = new Potion(ingredient, volume);
        potions.add(p);
        System.out.println(volume + " ml of " + ingredient + " added to the container.");
    }

    public void usePotion(String ingredient, double amount) {
        for (Potion p : potions) {
            if (p.getIngredient().equalsIgnoreCase(ingredient)) {
                if (p.consume(amount)) {
                    System.out.println(amount + " ml of " + ingredient + " used.");
                } else {
                    System.out.println("Not enough " + ingredient + " available.");
                }
                return;
            }
        }
        System.out.println("Potion not found.");
    }

    public double getRemainingVolume(String ingredient) {
        for (Potion p : potions) {
            if (p.getIngredient().equalsIgnoreCase(ingredient)) {
                return p.getVolume();
            }
        }
        return 0.0;
    }

    public boolean isEnoughForPotion(double unicornNeeded, double dragonNeeded) {
        double unicorn = getRemainingVolume("Unicorn Tears");
        double dragon = getRemainingVolume("Dragon Blood");

        return unicorn >= unicornNeeded && dragon >= dragonNeeded;
    }

    public void printPotions() {
        System.out.println("--- Potion Inventory ---");
        for (Potion p : potions) {
            System.out.printf("%s: %.2f ml%n",
                    p.getIngredient(), p.getVolume());
        }
    }
}
