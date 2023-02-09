package moves;

import game.*;
public interface MoveValidation {
    boolean pieceMoveIsValid(Position start, Position end);
    boolean move(Player player, Position start, Position end);
}
