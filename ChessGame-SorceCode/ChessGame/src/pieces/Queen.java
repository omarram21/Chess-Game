package pieces;

import enums.Color;
import moves.QueenMove;

public class Queen extends Piece{
    public Queen(Color color){
        super(color);
        setSympol("Q");
        canMove = new QueenMove();
    }
}
//ok