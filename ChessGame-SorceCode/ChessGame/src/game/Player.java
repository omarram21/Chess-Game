package game;

import enums.Color;

public class Player {

    final private Color color;

    public Player(Color color) {
        this.color = color;
    }

    public Color getColor()
    {
        return this.color;
    }

}
