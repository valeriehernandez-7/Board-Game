from Game import *
from Player import *

import time as tm


def createPlayer(tokenColor):
    """Creates an object of Player class."""
    newPlayer = Player(tokenColor)
    return newPlayer


def countdown():
    """Countdown of 3 seconds before the game starts."""
    print("\nSTARTING IN")
    for second in range(3, 0, -1):
        print(str(second))
        tm.sleep(1)
    print("GO\n")


def play():
    """Main function, asks the user for game settings and executes N number of rounds until a player reaches the last place on the board."""
    gameOver = False
    rounds = 0
    playersList = []

    print("\n* --- * --- * --- *  BOARD GAME  * --- * --- * --- *")
    print("\n\n >>>   GENERAL SETTINGS   <<< ")
    playersAmount = int(input("  > NUMBER OF PLAYERS: "))
    boardSize = int(input("  > NUMBER OF BOARD SPACES: "))
    diceSides = int(input("  > NUMBER OF DICE SIDES: "))

    print("\n >>>   PLAYER SETTINGS   <<< ")
    print("  > COLORS OF THE PLAYERS TOKENS ")
    i = 1
    while i <= playersAmount:
        player = createPlayer(input("    * PLAYER " + str(i) + ": "))
        playersList.append(player)
        i += 1

    print("\n >>>   GAME   <<< ")
    print("\n__________________ ONLINE PLAYERS [" + str(len(playersList)) + "] __________________\n")
    countdown()

    game = Game(playersList, boardSize, diceSides)
    while not gameOver:
        rounds += 1
        print("============= ROUND " + str(rounds) + " =============")
        for p in range(len(game.playersList)):
            PlayerId = game.turn(p)
            print("\n----- " + str(playersList[PlayerId].tokenColor) + " PLAYER TURN -----")
            print("> CURRENT POSITION: " + str(playersList[PlayerId].currentPosition))
            playersList[PlayerId].move(game.dice)
            # CHECKS WIN CONDITION
            if playersList[PlayerId].currentPosition < game.board.totalSpaces:
                print("> MOVE TO POSITION: " + str(playersList[PlayerId].currentPosition))
            else:
                print("\n\n\n|--- * --- ** --- *** --- ** --- * ---|")
                print("|--- * --- **    WINNER   ** --- * ---|")
                print("             " + str(playersList[PlayerId].tokenColor) + " PLAYER")
                print("|--- * --- ** --- *** --- ** --- * ---|")
                gameOver = True
                print("\n\n* --- * --- * --- *  ----------  * --- * --- * --- *")
                break
        print("\n")


if __name__ == '__main__':
    play()
