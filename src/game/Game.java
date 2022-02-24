package game;

import game.features.Dice;
import game.features.Board;
import game.features.Player;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * Game class. Manages the game features and track the turns in each game round.
 */
public class Game {
    // Game variables

    /**
     * Game condition.
     */
    private boolean gameOver = false;
    /**
     * Dice class declaration.
     */
    private final Dice dice;
    /**
     * Board class declaration.
     */
    private final Board board;
    /**
     * Players array list containing the players on play.
     */
    private ArrayList<Player> playerList = new ArrayList<>();
    /**
     * Index of the last player who played.
     */
    private int currentPlayerIndex;
    /**
     * A simple text scanner which can parse primitive types and strings using regular expressions.
     */
    private final Scanner userInput = new Scanner(System.in);

    // Game constructors

    /**
     * Game class default constructor (6 dice sides , 100 board spaces).
     */
    public Game() {
        this.dice = new Dice();
        this.board = new Board();
    }

    /**
     * Game class constructor.
     * @param diceSides   Number of Dice sides (faces).
     * @param boardSpaces Amount of spaces or marked surfaces on the board.
     */
    public Game(int diceSides, int boardSpaces) {
        this.dice = new Dice(diceSides);
        this.board = new Board(boardSpaces);
    }

    // getters & setters

    /**
     * GameOver getter method.
     * @return gameOver a boolean to determine the game state.
     */
    public boolean isGameOver() {
        return gameOver;
    }

    /**
     * GameOver setter method.
     * @param gameOver a boolean to determine the game state.
     */
    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    /**
     * PlayerList getter method.
     * @return playerList an array list of players.
     */
    public ArrayList<Player> getPlayerList() {
        return playerList;
    }

    /**
     * CurrentPlayerIndex getter method.
     * @return currentPlayerIndex an integer as the index of the last player who played.
     */
    public int getCurrentPlayerIndex() {
        return currentPlayerIndex;
    }

    /**
     * CurrentPlayerIndex setter method.
     * @param currentPlayerIndex an integer as the index of the last player who played.
     */
    public void setCurrentPlayerIndex(int currentPlayerIndex) {
        this.currentPlayerIndex = currentPlayerIndex;
    }

    // Game methods

    /**
     * Creates a player instance and adds it to the players list.
     * @param tokenColor a string as player token (piece) color as Player ID.
     */
    public void createPlayer(String tokenColor) {
        Player newPlayer = new Player(tokenColor);
        getPlayerList().add(newPlayer);
    }

    /**
     * Request to the user the details for each player as the token color and calls the createPlayer method.
     * @param playersAmount an integer as the amount players playing.
     */
    public void createPlayersList(int playersAmount) {
        System.out.println("\n >>>   PLAYER SETTINGS   <<< ");
        System.out.println("  > COLORS OF THE PLAYERS TOKENS ");
        int playerNumber = 1;
        while (playerNumber <= playersAmount) {
            System.out.print("    * PLAYER " + playerNumber + ": ");
            String color = this.userInput.next();
            createPlayer(color);
            ++playerNumber;
        }
    }

    /**
     * Manages the players turn during the game.
     * @param currentPlayer an integer as the index of the last player who played.
     */
    public void turn(Player currentPlayer) {
        if (getPlayerList().contains(currentPlayer)) {
            if (getPlayerList().indexOf(currentPlayer) != (getPlayerList().size() - 1)) {
                setCurrentPlayerIndex(getCurrentPlayerIndex() + 1);
            } else {
                setCurrentPlayerIndex(0);
            }
        } else {
            System.out.println("ERROR: Player not found.");
        }
    }

    /**
     * Creates a counter before the game stars.
     * @throws InterruptedException exception to the possible errors.
     */
    public void countdown() throws InterruptedException {
        System.out.println("\nSTARTING IN");
        for (int i = 3; i > 0; i--) {
            System.out.println(i);
            TimeUnit.SECONDS.sleep(1);
        }
        System.out.println("GO\n");
    }

    /**
     * Handles the main game loop, showing all the details about the rounds during the play.
     */
    public void play() {
        int rounds = 0;
        while (!isGameOver()) {
            ++rounds;
            System.out.println("============= ROUND " + rounds + " =============");
            for (Player player : getPlayerList()) {
                turn(player);
                System.out.println("\n----- " + getPlayerList().get(getCurrentPlayerIndex()).getTokenColor() + " PLAYER TURN -----");
                System.out.println("> CURRENT POSITION: " + getPlayerList().get(getCurrentPlayerIndex()).getPosition());
                getPlayerList().get(getCurrentPlayerIndex()).move(this.dice);
                // checks win condition
                if (getPlayerList().get(getCurrentPlayerIndex()).getPosition() < this.board.getTotalSpaces()) {
                    System.out.println("> MOVE TO POSITION: " + getPlayerList().get(getCurrentPlayerIndex()).getPosition());
                } else {
                    System.out.println("\n\n\n|--- * --- ** --- *** --- ** --- * ---|");
                    System.out.println("|--- * --- **    WINNER   ** --- * ---|");
                    System.out.println("             " + getPlayerList().get(getCurrentPlayerIndex()).getTokenColor() + " PLAYER");
                    System.out.println("|--- * --- ** --- *** --- ** --- * ---|");
                    System.out.println("\n\n* --- * --- * --- *  ----------  * --- * --- * --- *");
                    setGameOver(true);
                    break;
                }
            }
            System.out.println("\n");
        }
    }
}