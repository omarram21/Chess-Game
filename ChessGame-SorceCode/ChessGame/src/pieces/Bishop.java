package pieces;

import enums.Color;
import moves.BishopMove;

public class Bishop extends Piece{
    public Bishop(Color color){
        super(color);
        setSympol("B");
        canMove =new BishopMove();
    }

}
