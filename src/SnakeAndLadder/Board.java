package SnakeAndLadder;

import java.util.HashMap;
import java.util.Map;

class Board {
    private static final int SIZE = 100;
    private final Map<Integer, Integer> snakes;
    private final Map<Integer, Integer> ladders;

    public Board() {
        this.snakes = new HashMap<>();
        this.ladders = new HashMap<>();
    }

    public void addSnake(int head, int tail) {
        snakes.put(head, tail);
    }

    public void addLadder(int start, int end) {
        ladders.put(start, end);
    }

    public int getNewPosition(int position) {
        while (snakes.containsKey(position) || ladders.containsKey(position)) {
            if (snakes.containsKey(position)) {
                position = snakes.get(position);
            } else if (ladders.containsKey(position)) {
                position = ladders.get(position);
            }
        }
        return position;
    }

    public int getSize() {
        return SIZE;
    }
}
