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
    void CheckingThatGameStopsAfterMaxAmountOfRolls() {
        int maxRounds = 21;
        for (int i = 0; i < maxRounds + 1; i++)
            game.roll(i);

        assertThat(game.getRounds()).hasSize(maxRounds);
    }


























    public void fillRounds(int rounds, Game game, int pinsKnockedDown) {
        for (int i = 0; i < rounds; i++)
            game.roll(pinsKnockedDown);
    }
}
