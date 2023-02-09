package moves;

import game.Player;
import game.Position;

public  class Move implements MoveValidation {
    @Override
    public boolean pieceMoveIsValid(Position start, Position end){
        return true;
    }

    @Override
    public boolean move(Player player, Position start, Position end){

        if(end.getPiece() != null)
             if (end.getPiece().getColor() == start.getPiece().getColor()) {
            System.out.println("Unavailable move; there is a piece from the same color");
            return false;
        }
        // Check if the move mach the default selected Piece move
        if(!pieceMoveIsValid(start,end)){
            System.out.println("Unavailable move, Wrong Behavior for the selected Piece");
            return false;
        }

        if(player.getColor() != start.getPiece().getColor()){
            System.out.println("You can't move the other player piece\nTry Again");
            return false;
        }

        start.getPiece().setMoved(true);
        end.setPiece(start.getPiece());
        start.setPiece(null);

        return true;
    }

}
