public class Board {
    private char[][] board;
    public int getBoardSize() {
        return boardSize;
    }

    private int boardSize;

    public Board(int boardSize){
        this.boardSize = boardSize;
        this.board = new char[boardSize][boardSize];

        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                this.board[i][j] = ' ';
            }
        }
    }

    public boolean isValidMove(int x, int y){
        return board[x][y] != ' ';
    }

    public void placeMove(int x, int y, char move){
        board[x][y] = move;
    }


    public void printBoard(){
        String displayBoard = "";
        for (int i = 0; i < boardSize; i++) { //for each row
            for(int j = 0; j < boardSize; j++) { //printing board;s move first
                if(j == boardSize-1)
                    displayBoard += board[i][j];
                else
                    displayBoard += board[i][j] + "|";
            }
            if (i != boardSize-1) { // if it's not at the end of each row
                displayBoard += "\n"; //next row
                for (int j=0;j< boardSize;j++) {
                    if (j == boardSize-1)
                        displayBoard+= "-"; //printing border for the board
                    else
                        displayBoard +="-+";
                }
                displayBoard += "\n"; //onto the next row
            }
        }
        System.out.println(displayBoard);
    }

    public boolean isDiagonal (char move){
        for (int row = 0; row < board.length; row++) {
            if (board[row][row] != move)
                return false;
        }
        return true;
    }

    public boolean isAntiDiagonal (char move){
        for (int row = 0; row < board.length; row++) {
            if (board[row][boardSize - row - 1] != move)
                return false;
        }
        return true;
    }

    public boolean isColumn (char move, int j){
        for (int row = 0; row < board.length; row++) {
            if (board[row][j] != move) {
                return false;
            }
        }
        return true;
    }

    public boolean isRow (char move, int i){
        for(int col = 0; col<board.length; col++){
            if (board[i][col] != move) {
                return false;
            }
        }
        return true;
    }

    public boolean isFinished(){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != 'X' && board[i][j] != 'O') // that means it's empty
                    return false;
            }
        }
        return true;
    }
}
