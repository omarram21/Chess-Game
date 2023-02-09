package pieces;

import enums.Color;
import moves.RookMove;

public class Rook extends Piece{
    public Rook(Color color){
        super(color);

        setSympol("R");
        canMove = new RookMove();
    }
}
