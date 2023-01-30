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

    public void fillRounds(int rounds, Game game, int pinsKnockedDown) {
        for (int i = 0; i < rounds; i++)
            game.roll(pinsKnockedDown);
    }
}
