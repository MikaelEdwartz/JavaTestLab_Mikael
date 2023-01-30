package bowling;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private static int MAX_ROUNDS = 21;
    private int score;
    private final List<Integer> rounds;

    public Game() {
        rounds = new ArrayList<>();
    }

    public void roll(int pinsKnockedDown) {
        if (rounds.size() < MAX_ROUNDS)
            rounds.add(pinsKnockedDown);
    }

    public int score() {
        score = 0;
            score = rounds.stream().mapToInt(Integer::intValue).sum();

        return score;
    }
}
