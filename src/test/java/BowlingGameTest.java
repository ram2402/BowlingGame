import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BowlingGameTest {
    BowlingGame game = new BowlingGame();

    @Test
    public void scoreShouldBeZeroIfGutterGame() {
        for (int i = 0; i < 20; i++) {
            game.roll(0);
        }
        assertEquals(0, game.score());
    }

    @Test
    public void scoreShouldBe20If1IsKnockedDownEveryTime() {
        for (int i = 0; i < 20; i++) {
            game.roll(1);
        }
        assertEquals(20, game.score());
    }

    @Test
    public void scoreShouldBe13WhenSpareOnFirstFrame() {
        game.roll(7);
        game.roll(3);
        game.roll(3);
        for (int i = 3; i < 20; i++) {
            game.roll(0);
        }
        assertEquals(16, game.score());
    }
}
