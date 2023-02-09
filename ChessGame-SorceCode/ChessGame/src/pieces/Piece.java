package pieces;

import enums.Color;
import moves.*;
public class Piece {

    private String sympol;
    private Color color;
    private boolean killed;
    private boolean isMoved;
    public MoveValidation canMove;

    public Piece(Color color){
        this.setColor(color);
        isMoved = false;
    }
    public String getSympol() {
        return sympol;
    }
    public void setSympol(String sympol) {
        this.sympol = sympol;
    }
    public Color getColor() {
        return color;
    }
    public void setColor(Color color) {
        this.color = color;
    }
    public boolean isKilled() {
        return killed;
    }
    public void setKilled(boolean killed) {
        this.killed = killed;
    }
    public void setMoved(boolean moved) {
        isMoved = moved;
    }

}
