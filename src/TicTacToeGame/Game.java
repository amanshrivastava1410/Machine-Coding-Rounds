package TicTacToeGame;

import java.util.Scanner;

public class Game {
    private final Player playerX;
    private final Player playerO;
    private final Board board;
    private Player currentPlayer;

    public Game(String playerXName, String playerOName) {
        playerX = new Player(playerXName, 'X');
        playerO = new Player(playerOName, 'O');
        board = new Board();
        currentPlayer = playerX;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        board.printBoard();

        while (true) {
            System.out.println(currentPlayer.getName() + "'s turn (" + currentPlayer.getSymbol() + "). Enter row and column (1-3):");
            String input = scanner.nextLine();

            if (input.equals("exit")) {
                break;
            }

            String[] tokens = input.split(" ");
            if (tokens.length != 2) {
                System.out.println("Invalid input. Please enter row and column.");
                continue;
            }

            int row;
            int col;
            try {
                row = Integer.parseInt(tokens[0]) - 1;
                col = Integer.parseInt(tokens[1]) - 1;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter numeric values.");
                continue;
            }

            if (!board.isValidMove(row, col)) {
                System.out.println("Invalid Move.");
                continue;
            }

            board.makeMove(row, col, currentPlayer.getSymbol());
            board.printBoard();

            if (board.checkWin(currentPlayer.getSymbol())) {
                System.out.println(currentPlayer.getName() + " won the game.");
                break;
            }

            if (board.isFull()) {
                System.out.println("Game Over.");
                break;
            }

            currentPlayer = (currentPlayer == playerX) ? playerO : playerX;
        }

        scanner.close();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Enter Player X's name:");
            String playerXName = scanner.nextLine();
    
            System.out.println("Enter Player O's name:");
            String playerOName = scanner.nextLine();
    
            Game game = new Game(playerXName, playerOName);
            game.start();
        } finally {
            scanner.close();
        }
    }
}
