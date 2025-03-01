package DoozPackage;

public class Board {
    private static char[][] board={{' ',' ',' '},{' ',' ',' '},{' ',' ',' '}};

    public void printBoard(){
        System.out.println("+---+---+---+");
        for (int i=0; i<3; i++){
            System.out.print("| ");
            for (int j=0; j<3; j++){
                System.out.print(board[i][j]+" | ");
            }
            System.out.println("\n+---+---+---+");
        }
    }

    public boolean isValidMove(int row, int col){
        return row>=0 && row<3 && col>=0 && col<3 && board[row][col]==' ';
    }

    public void makeMove(int row,int col,char symbol){
        board[row][col]=symbol;
    }

    public boolean checkWin() {
        for (int i = 0; i < 3; i++) {
            if ((board[i][0]==board[i][1] && board[i][1]==board[i][2] && board[i][0]!=' ') || (board[0][i]==board[1][i] && board[1][i]==board[2][i] && board[0][i]!=' '))
                return true;
        }
        if ((board[0][0]==board[1][1] && board[1][1]==board[2][2] && board[0][0]!=' ') || (board[0][2]==board[1][1] && board[1][1]==board[2][0] && board[0][2]!=' '))
            return true;
        return false;
    }

    public boolean isBoardFull(){
        for (int i=0; i<3; i++)
            for (int j=0; j<3; j++)
                if (board[i][j]==' ')
                    return false;
        return true;
    }
}
