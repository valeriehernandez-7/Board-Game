package game.features;

/**
 * Game object as the surface for the players to moved or placed.
 */
public class Board {
    // Board variables

    /**
     * Amount of spaces or marked surfaces on the board.
     */
    private final int totalSpaces;

    // Board constructors

    /**
     * Board class default constructor (100 board spaces).
     */
    public Board() {
        this.totalSpaces = 100;
    }

    /**
     * Board class constructor.
     * @param totalSpaces Amount of spaces or marked surfaces on the board.
     */
    public Board(int totalSpaces) {
        this.totalSpaces = totalSpaces;
    }

    // getters & setters

    /**
     * TotalSpaces getter method.
     * @return totalSpaces an integer as the amount of spaces or marked surfaces on the board.
     */
    public int getTotalSpaces() {
        return totalSpaces;
    }
}