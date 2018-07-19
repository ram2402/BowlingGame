import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class BowlingGameTest {
    BowlingGame game = new BowlingGame();

    @Test
    public void scoreShouldBeZeroIfGutterGame() {
        rollMany(20, 0);
        assertEquals(0, game.score());
    }


    @Test
    public void scoreShouldBe20If1IsKnockedDownEveryTime() {
        rollMany(20, 1);
        assertEquals(20, game.score());
    }

    @Test
    public void scoreShouldBe16WhenSpareOnFirstFrame() {
        rollSpare(7, 3);
        game.roll(3);
        rollMany(17, 0);
        assertEquals(16, game.score());
    }

    @Test
    public void scoreShouldBe20WhenSpareOnFirstFrameAnd5OnnextThrow() {
        rollSpare(8, 2);
        game.roll(5);
        rollMany(17, 0);
        assertEquals(20, game.score());
    }

    @Test // just for understanding
    public void scoreShouldBe20WhenSpareOnSecondFrameAnd5OnnextThrow() {
        rollMany(2,3);
        rollSpare(8, 2);
        game.roll(5);
        rollMany(15, 0);
        assertEquals(26, game.score());
    }

    @Test
    public void scoreShouldBeValidWhenStrikeIsThrown() {
        game.roll(10);
        game.roll(3);
        game.roll(3);
        rollMany(16,0);
        assertEquals(22, game.score());
    }

    @Test // just for understanding
    public void scoreShouldBe300ForAPerfectGame() {
        rollMany(12,10);
        assertEquals(300, game.score());
    }

    private void rollSpare(int throw1, int throw2) {
        game.roll(throw1);
        game.roll(throw2);
    }

    private void rollMany(int noOfRolls, int pinsDown) {
        for (int i = 0; i < noOfRolls; i++) {
            game.roll(pinsDown);
        }
    }
}
