public class ComputerPlayer implements Player {
    private Board board;
    private char move;

    public ComputerPlayer(Board board, char move){
        this.board = board;
        this.move = move;

    }
    public void playerPlays(){
        int computerMoveX, computerMoveY;
        while (true) {
            computerMoveX = (int)(Math.random() * (board.getBoardSize()));
            computerMoveY = (int)(Math.random() * (board.getBoardSize())) ;
            if (!board.isValidMove(computerMoveX, computerMoveY))
                break;
        }
        System.out.println("*****************Computer's move*****************");
        placeMove(computerMoveX, computerMoveY,move);
    }

    private void placeMove (int x, int y, char move){ //**************************
        if (board.isValidMove(x,y))
            return;
        else
            board.placeMove(x, y, move);
    }
