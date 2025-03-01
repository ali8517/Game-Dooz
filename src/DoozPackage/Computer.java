package DoozPackage;

import java.util.Random;

public class Computer {
    private char symbol;
    private char playerSymbol;
    private Random random=new Random();

    public Computer(char symbol) {
        this.symbol = symbol;
        this.playerSymbol = (symbol == 'X') ? 'O' : 'X';
    }

    public void makeMove(Board board){
            if (findBestMove(board,symbol)) return;
            if (findBestMove(board,playerSymbol)) return;;
            randomMove(board);
    }
    private boolean findBestMove(Board board,char testSymbol){

        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                if (board.isValidMove(i,j)){
                    board.makeMove(i,j,testSymbol);
                    if (board.checkWin()){
                        if (testSymbol==symbol) return true;
                        board.makeMove(i,j,symbol);
                        return true;
                    }
                    board.makeMove(i,j,' ');
                }
            }
        }
        return false;
    }

    private void randomMove(Board board){
        int row,col;
        while (true) {
            row = random.nextInt(3);
            col = random.nextInt(3);
            if (board.isValidMove(row, col)) {
                board.makeMove(row,col,symbol);
                break;
            }
        }
    }

}
