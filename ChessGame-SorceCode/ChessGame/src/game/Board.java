package game;

import enums.Color;
import pieces.*;
public class Board {
    private final Color white = Color.WHITE;
    private final Color black = Color.BLACK;
    private final Position[][] position = new Position[8][8];

    public Board() {
        resetBoard();
    }

    public Position getSpot(int x, int y){
        return position[x-1][y-1];

    }

    public void printBoard(){
        System.out.println(" ");
        Piece piece;
        for (int i=7; i>=0;i--) {
            for (int j = 0; j < 8; j++){
                piece= position[j][i].getPiece();
                if(piece == null) {
                    if((i + j) %2  == 0 ) {
                        System.out.print("## ");
                    }
                    else {
                        System.out.print(".. ");
                    }
                }
                else {
                    System.out.print((piece.getColor() ==  Color.WHITE ? "w" : "b" )+piece.getSympol()+ " ");
                }
//                    System.out.print(piece.getColor().toString()+piece.getSympol() + "  ");

                if(j == 7)
                    System.out.print(i+1);
            }
            System.out.println();
        }
        for(int i=0;i<8;i++){
            System.out.print((char)('a' + i) + "  ");
        }
        System.out.println();
        System.out.println(" ");

    }
    public void resetBoard() {

        // initialize white pieces
        position[0][0] = new Position(new Rook(white),1, 1 );
        position[1][0] = new Position(new Knight(white),2, 1);
        position[2][0] = new Position(new Bishop(white),3, 1);
        position[3][0] = new Position(new Queen(white),4, 1);
        position[4][0] = new Position(new King(white),5, 1);
        position[5][0] = new Position(new Bishop(white),6, 1);
        position[6][0] = new Position(new Knight(white),7,1);
        position[7][0] = new Position(new Rook(white),8, 1);

        // initialize white pawns
        for(int i=0;i<8;i++)
            position[i][1] = new Position(new Pawn(white),i+1, 2);

        // initialize black pieces
        position[0][7] = new Position(new Rook(black),1, 8 );
        position[1][7] = new Position(new Knight(black),2, 8);
        position[2][7] = new Position(new Bishop(black),3, 8);
        position[3][7] = new Position(new Queen(black),4, 8);
        position[4][7] = new Position(new King(black),5, 8);
        position[5][7] = new Position(new Bishop(black),6, 8);
        position[6][7] = new Position(new Knight(black),7,8);
        position[7][7] = new Position(new Rook(black),8, 8);

        // initialize black pawns
        for(int i=0;i<8;i++)
            position[i][6] = new Position(new Pawn(black),i+1, 7);

        // initialize remaining boxes without any piece
        for (int i = 2; i < 6; i++) {
            for (int j = 0; j < 8; j++) {
                position[j][i] = new Position(null,j+1, i+1);
            }
        }
    }
}
