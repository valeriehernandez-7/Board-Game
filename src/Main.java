import game.Game;

import java.util.Scanner;

/**
 * Main class. Request the general data to create the game instance and starts the play.
 * @author <a href="https://github.com/valeriehernandez-7">Valerie M. Hernández Fernández</a>
 */
public class Main {
    /**
     * Main method.
     * @param args program arguments.
     */
    public static void main(String[] args) {
        try {
            // request the data to the user
            Scanner userInput = new Scanner(System.in);
            System.out.println("\n* --- * --- * --- *  BOARD GAME  * --- * --- * --- *");
            System.out.println("\n\n >>>   GENERAL SETTINGS   <<< ");
            System.out.print("  > NUMBER OF PLAYERS: ");
            int playersAmount = userInput.nextInt();
            System.out.print("  > NUMBER OF BOARD SPACES: ");
            int boardSize = userInput.nextInt();
            System.out.print("  > NUMBER OF DICE SIDES: ");
            int diceSides = userInput.nextInt();
            // game execution
            Game game = new Game(diceSides, boardSize); // game instance
            game.createPlayersList(playersAmount); // creates the game players list
            game.countdown(); // start the countdown before start
            game.play(); // game start
        } catch (Exception e) {
            System.out.println("ERROR: " + e);
        }
    }
}