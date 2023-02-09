package moves;

import game.Position;

public class KnightMove extends Move{
    @Override
    public boolean pieceMoveIsValid(Position start, Position end){
        int x = Math.abs(start.getX() - end.getX());
        int y = Math.abs(start.getY() - end.getY());
        return (x==2 && y==1) || (x==1 && y==2);
    }
}
