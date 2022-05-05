import java.util.Scanner;

public class Main {

    private Player player;
    public void setPlyaer(Player player){
        this.player = player;
    }

    public static void main(String[] args){
        System.out.println("Enter the size of your board:");
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();

        System.out.println("Which way you wanna play, you dig? [1] human & human [2] human & computer [3] computer & computer");
        int choice = sc.nextInt();
        TicTacToeGame game = new TicTacToeGame(size, choice);

        System.out.println("Board in the beginning:");
        game.printBoardNxN();

        while (true) {
            game.firstPlays();
            if (game.checkWinner())
                break;
            game.printBoardNxN();
            game.secondPlays();
            if (game.checkWinner())
                break;
            game.printBoardNxN();
        }
        sc.close();
    }
}
