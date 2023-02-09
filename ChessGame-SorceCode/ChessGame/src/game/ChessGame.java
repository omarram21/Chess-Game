package game;

import enums.Color;
import enums.GameStatus;
import pieces.*;
import java.util.*;

public class ChessGame {
    private Player player1;
    private Player player2;
    private Player currentTurn;
    private Board board;
    private Piece whiteKing;
    private Piece blackKing;
    private GameStatus status;
    private List<String> movesPlayed ;
    private List<Piece> killedPieces;
    private Map <Character, Integer> map;
    private final Scanner scanner= new Scanner(System.in);

    public void  start(){

        prepareTheGame();
        setValuesToMap();
        board.printBoard();

        while (status == GameStatus.ACTIVE) {
            if(currentTurn == player1){
                playerMove(player1, player2);
            }
            else {
                playerMove(player2,player1);
            }
            checkGameStatus();
        }

        System.out.println(getStatus().toString());
        printMovesPlayed();
    }

    // to prepare the hole game
    private void prepareTheGame() {

        board = new Board();
        //Todo delete
        movesPlayed = new ArrayList<>();
        killedPieces = new ArrayList<>();

        status = GameStatus.ACTIVE;

        player1 = new Player(Color.WHITE);
        player2 = new Player(Color.BLACK);

        if (player1.getColor()==Color.WHITE) {
            this.currentTurn = player1;
        }
        else {
            this.currentTurn = player2;
        }
        whiteKing = board.getSpot(5,1).getPiece();
        blackKing = board.getSpot(5,8).getPiece();
    }
    // set values to column a-> 1 ...
    private void setValuesToMap(){
        map = new HashMap<>();
        map.put('a', 1);
        map.put('b', 2);
        map.put('c', 3);
        map.put('d', 4);
        map.put('e', 5);
        map.put('f', 6);
        map.put('g', 7);
        map.put('h', 8);
    }

    private void playerMove(Player playerA, Player playerB){
        System.out.println("Enter next move ("+playerA.getColor().toString()+" player): ");
        String input = scanner.nextLine();
        input = input.toLowerCase();
        if (isGoodInputFormat(input) && move(input,playerA)) {
            currentTurn = playerB;
            //Todo delete
            movesPlayed.add(input);
            board.printBoard();
        }
    }

    private boolean move(String input, Player player){

        int x1,y1,x2,y2;

        x1 = map.get(input.charAt(5));
        y1 = Character.getNumericValue(input.charAt(6));
        x2 = map.get(input.charAt(8));
        y2 = Character.getNumericValue(input.charAt(9));

        Position start = board.getSpot(x1, y1);
        Position end = board.getSpot(x2, y2);

        if(end.getPiece() !=null){
            end.getPiece().setKilled(true);
            killedPieces.add(end.getPiece());
        }
        if(start.getPiece() != null)
            return start.getPiece().canMove.move(player, start, end);
        return false;
    }

    private boolean isGoodInputFormat(String input){
        if(input.charAt(0)=='m' && input.charAt(1)=='o' && input.charAt(2)=='v' && input.charAt(3)=='e')
            if (input.charAt(5)>='a' && input.charAt(8)>='a' && input.charAt(5)<='h' && input.charAt(8)<='h')
                if (input.charAt(6)>='1' && input.charAt(9)>='1' && input.charAt(6)<='8' && input.charAt(9)<='8')
                    return true;
        System.out.println("Wrong Format; please use this format [move d2 d4].");
        return false;
    }

    private void checkGameStatus(){
        if (whiteKing.isKilled())
            setStatus(GameStatus.BLACK_WIN);
        else if (blackKing.isKilled())
            setStatus(GameStatus.WHITE_WIN);
        else if(movesPlayed.size() == 20)
            setStatus(GameStatus.DRAW);
        else if (killedPieces.size() == 30)
            setStatus(GameStatus.DRAW);
    }

    private void printMovesPlayed(){
        System.out.print("Moves played: \n");
        for (String i:movesPlayed)
            System.out.println(i);
        System.out.println();
    }

    private GameStatus getStatus() {
        return this.status;
    }

    private void setStatus(GameStatus status) {
        this.status = status;
    }

}
