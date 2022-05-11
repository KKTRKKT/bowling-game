import bowling.BowlingGame;
import org.junit.*;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class BowlingGameTest {
    BowlingGame game;

    @Before
    public void setup(){
        game = new BowlingGame();
    }

    @Test
    public void gutter_game(){
        rollMany(20, 0);
        assertThat(game.score(), is(0));
    }

    @Test
    public void all_ones(){
        rollMany(20, 1);
        assertThat(game.score(), is(20));
    }

    @Test
    public void one_spare(){
        rollSpare();
        game.roll(3);
        rollMany(17, 0);
        assertThat(game.score(), is(16));
    }

    @Test
    public void one_strike(){
        rollStrike();
        game.roll(5);
        game.roll(3);
        rollMany(16, 0);
        assertThat(game.score(), is(26));
    }

    @Test
    public void perfect_game(){
        rollMany(12, 10);
        assertThat(game.score(), is(300));
    }

    private void rollMany(int rolls, int pins) {
        for(int i = 0; i < rolls; i++){
            game.roll(pins);
        }
    }

    private void rollSpare(){
        game.roll(5);
        game.roll(5);
    }

    private void rollStrike(){
        game.roll(10);
    }
}
