package bowling;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class GameTest {
    Game game = new Game();

    @Test
    void CreatingNewGameObjectReturnsNewObjectWithZeroScore() {

        fillRounds(21, game, 0);
        int score = game.score();

        assertThat(score).isZero();
    }

    @Test
    void UsingRollIncreasesScoreByNumberOfPinsHit() {
        int pinsToHit = 5;

        game.roll(pinsToHit);
        fillRounds(20, game, 0);
        int score = game.score();

        assertThat(score).isEqualTo(pinsToHit);
    }

    @Test
    void RollingASpareReturnsCorrectBonusAmount() {

        game.roll(9);
        game.roll(1);
        game.roll(5);

        fillRounds(17, game, 0);
        int expectedResult = game.score();

        assertThat(expectedResult).isEqualTo(20);

    }

    @Test
    void CheckingThatGameStopsAfterMaxAmountOfRolls() {
        int maxRounds = 21;
        for (int i = 0; i < maxRounds + 1; i++)
            game.roll(i);

        assertThat(game.getRounds()).hasSize(maxRounds);
    }

    @Test
    void rollingAStrikeReturnsCorrectAmountOfBonusPoints() {

        game.roll(10);
        game.roll(3);
        game.roll(4);

        fillRounds(25, game, 0);
        int expectedResult = game.score();

        assertThat(expectedResult).isEqualTo(24);

    }

    @Test
    void rollingPerfectGameReturnsCorrectAmountOfPoints() {

        fillRounds(12, game, 10);

        int expectedResult = game.score();

        assertThat(expectedResult).isEqualTo(300);
    }

    @Test
    void Rolling2StrikesAnd2SparesRestOnesReturnsCorrectAmount() {

        rollStrike(game);
        rollStrike(game);
        rollSpare(game);
        rollSpare(game);
        fillRounds(18, game, 1);
        int score = game.score();

        assertThat(score).isEqualTo(83);
    }

    public void fillRounds(int rounds, Game game, int pinsKnockedDown) {
        for (int i = 0; i < rounds; i++)
            game.roll(pinsKnockedDown);
    }

    public void rollStrike(Game game) {
        game.roll(10);
    }

    public void rollSpare(Game game) {
        game.roll(5);
        game.roll(5);

    }

}
