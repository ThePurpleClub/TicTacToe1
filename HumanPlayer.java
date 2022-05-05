import java.util.Scanner;

public class HumanPlayer implements Player{
    private Board board;
    private Scanner sc;
    private char move;

    public HumanPlayer(Board board, Scanner sc, char move) {
        this.board = board;
        this.sc = sc;
        this.move = move;
    }

    public void playerPlays(){
        int humanMoveX, humanMoveY;
        while (true) {
            System.out.println("Enter your x y coordinates.");
            try {
                humanMoveX = sc.nextInt();
                humanMoveY = sc.nextInt();

                if (!board.isValidMove(humanMoveX, humanMoveY)) break;

            }catch(Exception e) {
                System.out.println("try again.");
                humanMoveX = sc.nextInt();
                humanMoveY = sc.nextInt();
            }
        }
        System.out.println("**************Your Move*************");
        placeMove(humanMoveX, humanMoveY,move);
    }

    private void placeMove (int x, int y, char move){
        if (board.isValidMove(x,y))
            return;
        else
            board.placeMove(x, y, move);
    }
}
