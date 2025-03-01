package DoozPackage;

import java.util.Scanner;

public class Player {
    private char symbol;

    public Player(char symbol){
        this.symbol=symbol;
    }
    public char getSymbol(){
        return symbol;
    }
    public void makeMove(Board board, Scanner scanner){
        int row,col;
        while (true) {
            System.out.println(" Player " + symbol);
            System.out.print(" ROW : ");
            row = scanner.nextInt() - 1;
            System.out.print(" COL : ");
            col = scanner.nextInt() - 1;

            if (board.isValidMove(row, col)) {
                board.makeMove(row,col,symbol);
                break;
            } else {
                System.out.println(" Invalid move! Try again =)");
            }
        }
    }
}
