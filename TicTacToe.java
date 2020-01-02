import java.util.Scanner;

class TicTacToe
{
    public static void main(final String[] array) {
        int choice;
        Scanner sc = new Scanner(System.in);
        System.out.println("Please select your option: \n1: Human vs Human \n2: Human vs AI \n3: AI vs AI");
        choice = sc.nextInt();
        game g = new game(choice);
        g.begin();
    }
}