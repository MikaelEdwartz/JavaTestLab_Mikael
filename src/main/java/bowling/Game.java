package bowling;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private static int MAX_ROUNDS = 21;
    public final static int MAX_PINS = 10;
    private int score;
    private int round;
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
        round = 0;
        for (int i = round; i < 10; i++) {
            if(rounds.get(round) == MAX_PINS){
                score = MAX_PINS + roundPoints(round + 1) + roundPoints(round + 2);
                round++;
            }
            else if (isASpare())
                getPointsForSpareRound();
            else
                getPointsForRegularRound();

        }
        return score;
    }

    private void getPointsForRegularRound() {
        score += roundPoints(round) + roundPoints(round + 1);
        this.round += 2;
    }

    private void getPointsForSpareRound() {
        score += MAX_PINS + roundPoints(round + 2);
        round += 2;
    }

    private boolean isASpare() {
        return roundPoints(round) + roundPoints(round + 1) == MAX_PINS;
    }

    private int roundPoints(int round) {
        return rounds.get(round);
    }

    public List<Integer> getRounds() {
        return rounds;
    }

}
