package bowling;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private static int MAX_ROUNDS = 21;
    public final static int MAX_PINS = 10;
    private int score = 0;
    private final List<Integer> rounds;
    private int round;

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
        for (int i = 0; i < 10; i++)
            calculateRoundPoints();
        return this.score;
    }

    private void calculateRoundPoints() {
        if (isAStrike())
            getPointsForStrikeRound();
        else if (isASpare())
            getPointsForSpareRound();
        else
            getPointsForAverageRound();

    }

    private void getPointsForStrikeRound() {
        score += pointsForStrike();
        round++;
    }

    private int pointsForStrike() {
        return MAX_PINS + roundPoints(round + 1) + roundPoints(round + 2);
    }

    private boolean isAStrike() {
        return rounds.get(round) == MAX_PINS;
    }

    private void getPointsForSpareRound() {
        score += pointsForSpare();
        round += 2;
    }

    private boolean isASpare() {
        return roundPoints(round) + roundPoints(round + 1) == MAX_PINS;
    }

    private int pointsForSpare() {
        return MAX_PINS + roundPoints(round + 2);
    }

    private void getPointsForAverageRound() {
        score += roundPoints(round) + roundPoints(round+1);
        this.round += 2;
    }

    private int roundPoints(int round) {
        return rounds.get(round);
    }

    public List<Integer> getRounds() {
        return rounds;
    }
}
