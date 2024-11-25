package SnakeAndLadder;

import java.util.ArrayList;
import java.util.List;

class SnakeAndLadderGame {
    private final Board board;
    private final Dice dice;
    private final List<Player> players;

    public SnakeAndLadderGame() {
        this.board = new Board();
        this.dice = new Dice();
        this.players = new ArrayList<>();
    }

    public void addSnake(int head, int tail) {
        board.addSnake(head, tail);
    }

    public void addLadder(int start, int end) {
        board.addLadder(start, end);
    }

    public void addPlayer(String name) {
        players.add(new Player(name));
    }

    public void play() {
        boolean winnerFound = false;

        while (!winnerFound) {
            for (Player player : players) {
                int currentPosition = player.getPosition();
                int diceValue = dice.roll();

                int newPosition = currentPosition + diceValue;
                if (newPosition > board.getSize()) {
                    newPosition = currentPosition;
                } else {
                    newPosition = board.getNewPosition(newPosition);
                }

                System.out.printf("%s rolled a %d and moved from %d to %d%n",
                        player.getName(), diceValue, currentPosition, newPosition);

                player.setPosition(newPosition);

                if (newPosition == board.getSize()) {
                    System.out.printf("%s wins the game%n", player.getName());
                    winnerFound = true;
                    break;
                }
            }
        }
    }
}
