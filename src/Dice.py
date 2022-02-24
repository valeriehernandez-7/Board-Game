import random as rnd


class Dice:
    """Game object with N number of sides to provide random numbers in range according to the number on its sides."""

    sidesAmount = 0  # number of dice sides (faces)
    currentSide = 0  # current dice side (face)

    def __init__(self, sides=6):
        self.sidesAmount = sides  # 6 sides as default value

    def roll(self):
        """Chooses a random number between 1 and the dice sides amount."""
        print("+ + +  ROLLING THE DICE + + +")
        self.currentSide = rnd.randint(1, self.sidesAmount)
        return self.currentSide
