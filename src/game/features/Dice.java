package game.features;

import java.util.Random;

/**
 * Chooses a random number between 1 and the dice sides amount.
 */
public class Dice {
    // Dice variables

    /**
     * Number of Dice sides (faces).
     */
    private final int sidesAmount;

    // Dice constructors

    /**
     * Dice class default constructor (6 dice sides).
     */
    public Dice() {
        this.sidesAmount = 6;
    }

    /**
     * Dice class constructor.
     * @param sidesNumber Number of Dice sides (faces).
     */
    public Dice(int sidesNumber) {
        this.sidesAmount = sidesNumber;
    }

    // getters & setters

    /**
     * SidesAmount getter method.
     * @return sidesAmount an integer as the number of Dice sides (faces).
     */
    public int getSidesAmount() {
        return sidesAmount;
    }

    // Dice methods

    /**
     * Chooses a random number between 1 and the dice sides amount.
     * @return An integer as dice current side.
     */
    public int roll() {
        System.out.println("+ + +  ROLLING THE DICE + + +");
        Random random = new Random();
        return random.nextInt(1, getSidesAmount());
    }
}