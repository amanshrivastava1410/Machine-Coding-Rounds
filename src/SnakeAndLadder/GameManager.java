package SnakeAndLadder;

import java.util.Scanner;

class GameManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SnakeAndLadderGame game = new SnakeAndLadderGame();

        System.out.println("No of snakes are:");
        int numberOfSnakes = Integer.parseInt(scanner.nextLine().trim());
        for (int i = 0; i < numberOfSnakes; i++) {
            System.out.println("Head of snake is at and tail is at (space-separated):");
            String[] snakeInput = scanner.nextLine().split(" ");
            int head = Integer.parseInt(snakeInput[0]);
            int tail = Integer.parseInt(snakeInput[1]);
            game.addSnake(head, tail);
        }

        System.out.println("No of ladders are:");
        int numberOfLadders = Integer.parseInt(scanner.nextLine().trim());
        for (int i = 0; i < numberOfLadders; i++) {
            System.out.println("Ladder starts at and ends at (space-separated):");
            String[] ladderInput = scanner.nextLine().split(" ");
            int start = Integer.parseInt(ladderInput[0]);
            int end = Integer.parseInt(ladderInput[1]);
            game.addLadder(start, end);
        }

        System.out.println("No of players are:");
        int numberOfPlayers = Integer.parseInt(scanner.nextLine().trim());
        System.out.println("Names are:");
        for (int i = 0; i < numberOfPlayers; i++) {
            String playerName = scanner.nextLine();
            game.addPlayer(playerName);
        }

        game.play();
        scanner.close();
    }
}
