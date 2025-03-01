package DoozPackage;

import java.util.Scanner;

public class Game {
    private Board board=new Board();
    private Player player;
    private Computer computer;
    private boolean isPlayerTurn;

    public void start(){
        Scanner scanner=new Scanner(System.in);
        System.out.print("\n Choose your symbol\n 1:X\n 2:O " + "\n Enter : ");
        char playerSymbol=(scanner.nextInt()==1)?'X':'O';
        char computerSymbol=(playerSymbol=='X')?'O':'X';

        player=new Player(playerSymbol);
        computer=new Computer(computerSymbol);
        isPlayerTurn=(playerSymbol=='X');


    }

    private void play(Scanner scanner){
        while (true){
            board.printBoard();
            if (isPlayerTurn)
                player.makeMove(board,scanner);
            else
                computer.makeMove(board);

            if (board.checkWin()){
                board.printBoard();
                System.out.println((isPlayerTurn?" YOU":" COMPUTER" + " win =)"));
                return;
            }
            else if (board.isBoardFull()){
                    board.printBoard();
                    System.out.println(" Draw :/");
                    return;
            }
                isPlayerTurn=!isPlayerTurn;
        }
    }
}
