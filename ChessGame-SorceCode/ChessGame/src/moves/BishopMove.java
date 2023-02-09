package moves;

import game.Position;

public class BishopMove extends Move{
    @Override
    public boolean pieceMoveIsValid(Position start, Position end){
        int x = Math.abs(start.getX() - end.getX());
        int y = Math.abs(start.getY() - end.getY());
        return x == y;
    }
}
