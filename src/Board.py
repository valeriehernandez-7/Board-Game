class Board:
    """Game object as the surface for the players to moved or placed."""

    totalSpaces = 0  # amount of spaces or marked surfaces on the board

    def __init__(self, spaces=40):
        self.totalSpaces = spaces  # 40 spaces as default value
