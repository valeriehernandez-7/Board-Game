from Board import *
from Dice import *


class Game:
    """Manages the game features and track the turns in each game round."""

    board = Board()  # Board class instance
    dice = Dice()  # Dice class instance
    playersList = []  # list of players
    currentPlayerIndex = 0  # player index in the list of players

    def __init__(self, players, boardSpaces, diceSides):
        self.playersList = players
        self.board = Board(boardSpaces)
        self.dice = Dice(diceSides)

    def turn(self, currentPlayer):
        """Controls every player's turns in the game."""
        self.currentPlayerIndex = currentPlayer
        if self.currentPlayerIndex != self.playersList.index(self.playersList[-1]):
            self.currentPlayerIndex += 1
        else:
            self.currentPlayerIndex = 0
        return self.currentPlayerIndex
