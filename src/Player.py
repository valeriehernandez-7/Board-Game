class Player:
    """Game object standing for the player, stores unique features as its color and position during the game."""

    tokenColor = ""  # player token (piece) color
    currentPosition = 0  # player current position

    def __init__(self, token, currentPosition=0):
        self.tokenColor = token
        self.currentPosition = currentPosition  # 0 as default value representing the beginning of the board

    def move(self, dice):
        """Gets an amount from the die and changes the player's position."""
        spacesAmount = dice.roll()
        print("+++  ++  +  " + str(spacesAmount) + "  +  ++  +++")
        self.currentPosition += spacesAmount
        return self.currentPosition
