package game.features;

/**
 * Game object standing for the player, stores unique features as its color and position during the game.
 */
public class Player {
    // Player variables

    /**
     * Player token (piece) color as Player ID.
     */
    private final String tokenColor;

    /**
     * Player current position.
     */
    private int position;

    // Player constructor

    /**
     * Player class default constructor (0 position as default value representing the beginning of the board).
     * @param tokenColor Player token (piece) color as Player ID.
     */
    public Player(String tokenColor) {
        this.tokenColor = tokenColor;
        this.position = 0;
    }

    // getters & setters

    /**
     * Player TokenColor getter method.
     * @return tokenColor a string as player token (piece) color as Player ID.
     */
    public String getTokenColor() {
        return tokenColor;
    }

    /**
     * Player Position getter method.
     * @return position an integer as player current position.
     */
    public int getPosition() {
        return position;
    }

    /**
     * Player Position setter method.
     * @param position an integer as player current position.
     */
    public void setPosition(int position) {
        this.position = position;
    }

    // Player methods

    /**
     * Gets an amount from the die and changes the player's position.
     * @param dice game instance of the Dice class.
     */
    public void move(Dice dice) {
        int spacesAmount = dice.roll();
        System.out.println("+++  ++  +  " + spacesAmount + "  +  ++  +++");
        setPosition(getPosition() + spacesAmount);
    }
}