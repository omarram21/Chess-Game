package moves;

import game.Position;

public class RookMove extends Move{
    @Override
    public boolean pieceMoveIsValid(Position start, Position end){
        return end.getX() == start.getX() || end.getY() == start.getY();
    }
}
