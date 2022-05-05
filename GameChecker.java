public class GameChecker {
    private Board board;

    public GameChecker(Board board){
        this.board = board;
    }

    public boolean haveYouWon (char move){
        for (int i = 0; i < board.getBoardSize(); i++) {
            if(board.isColumn(move, i))
                return true;
            if(board.isRow(move,i))
                return true;
        }
        if (board.isDiagonal(move) || board.isAntiDiagonal(move))
            return true;
        return false;
    }

    public boolean checkWinner(){
        if (haveYouWon( 'X')) {
            board.printBoard();
            System.out.println("You win!");
            return true;
        }
        if (haveYouWon('O')) {
            board.printBoard();
            System.out.println("Computer wins!");
            return true;
        }

        if(!board.isFinished()) return false; //******

        board.printBoard();
        System.out.println("You tie.");
        return true;
    }
}
