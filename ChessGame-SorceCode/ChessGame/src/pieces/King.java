package pieces;

import enums.Color;
import moves.KingMove;

public class King extends Piece {

    public King(Color color){
        super(color);

        setSympol("K");
        canMove = new KingMove();
    }


}
