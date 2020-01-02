import java.util.Random;
import java.util.Scanner;

class game implements global
{
    board gameBoard;
    player playerX;
    player playerO;
    int turn;
    boolean done;

    //default constructor
    public game(int ch) {
        this.done = false;
        final Scanner scanner = new Scanner(System.in);
        this.gameBoard = new board();
        String s = "player1";
        String str = "player2";

        while (!this.done) {

            switch (ch) {
                case 1: {
                    System.out.print("Please enter human player X name: ");
                    s = scanner.next();
                    System.out.print("Please enter human player O name: ");
                    str = scanner.next();
                    this.playerX = new HumanPlayer(this.gameBoard, 1, s);
                    this.playerO = new HumanPlayer(this.gameBoard, 2, str);
                    this.done = true;
                    continue;
                }
                case 2: {
                    str = "AI";
                    System.out.print("Please enter human player X name: ");
                    s = scanner.next();
                    this.playerX = new HumanPlayer(this.gameBoard, 1, s);
                    this.playerO = new AIPlayer(this.gameBoard, 2, str);
                    this.done = true;
                    continue;
                }
                case 3: {
                    this.playerX = new AIPlayer(this.gameBoard, 1, s);
                    this.playerO = new AIPlayer(this.gameBoard, 2, str);
                    this.done = true;
                    continue;
                }
                default: {
                    System.out.println("Invalid Input, Please select again");
                    continue;
                }
            }
        }

        System.out.println("Game initiated: " + s + " VS " + str + "\n");
    }

    public void begin() {
        final Random random = new Random();
        int i = 0;
        this.turn = random.nextInt(2) + 1;
        if (this.turn == 1) {
            System.out.println(this.playerX.playerName + " (X) will start\n");
        }
        else {
            System.out.println(this.playerO.playerName + " (O) will start\n");
        }
        while (i == 0) {
            if (this.turn == 1) {
                System.out.println("-Player X's Turn: ");
                this.playerX.play(this.gameBoard);
            }
            else {
                System.out.println("-Player O's Turn: ");
                this.playerO.play(this.gameBoard);
            }
            if (this.gameBoard.getst() != 0) {
                i = 1;
            }
            if (i == 0) {
                if (this.turn == 1) {
                    this.turn = 2;
                }
                else {
                    this.turn = 1;
                }
            }
        }
        this.gameBoard.displayBoard();
        if (this.gameBoard.getst() == 3) {
            System.out.println("Draw!");
        }
        else if (this.turn == 1) {
            System.out.println("The winner is " + this.playerX);
        }
        else {
            System.out.println("The winner is " + this.playerO);
        }
    }
}