package bowling;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class GameTest{


    @Test
    void CreatingNewGameObjectReturnsNewObjectWithZeroScore(){
        Game game = new Game();

        int score = game.score();

        assertThat(score).isZero();
    }

    @Test
    void UsingRollIncreasesScoreByNumberOfPinsHit(){
        Game game = new Game();
        int pinsToHit = 5;

        game.roll(pinsToHit);
        int score = game.score();

        assertThat(score).isEqualTo(pinsToHit);
    }
}
