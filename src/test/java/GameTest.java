import bowling.Game;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameTest {

    private Game game;

    @Before
    public void canCreate(){
        game = new Game();
    }

    @Test
    public void canRoll(){
        game.roll(0);
    }

    @Test
    public void gutterGame(){
        rollMany(0, 20);
        assertEquals(0, game.score());
    }

    @Test
    public void allOnes(){
        rollMany(1, 20);
        assertEquals(20, game.score());
    }

    @Test
    public void oneSpare(){
        rollSpare();
        game.roll(3);
        rollMany(0, 17);
        assertEquals(13+3, game.score());
    }

    @Test
    public void oneStrike(){
        isStrike();
        game.roll(5);
        game.roll(3);
        rollMany(0, 16);
        assertEquals(18+8, game.score());
    }

    @Test
    public void allStrike(){
        rollMany(10, 12);
        assertEquals(300, game.score());
    }

    private void isStrike() {
        game.roll(10);
    }

    private void rollSpare() {
        game.roll(5);
        game.roll(5);
    }

    private void rollMany(int pins, int rolls) {
        for(int i=0;i<rolls;i++){
            game.roll(pins);
        }
    }
}
