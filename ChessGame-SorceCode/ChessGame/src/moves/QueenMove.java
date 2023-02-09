package moves;

import game.Position;

public class QueenMove extends Move{
    public boolean pieceMoveIsValid(Position start, Position end){
        int x = Math.abs(start.getX() - end.getX());
        int y = Math.abs(start.getY() - end.getY());

        if(x == y)
            return true;
        if(end.getX() == start.getX() || end.getY() == start.getY())
            return true;

        return false;
    }
}
