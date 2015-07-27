package tennis;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ScoreboardTest {
    final String PLAYER_1 = "D";
    final String PLAYER_2 = "F";
    
    public ScoreboardTest() {
    }
    
    @Test
    public void testIsDuce() throws Exception {
        System.out.println("isDuce");
        Scoreboard instance = new Scoreboard();

        assertEquals(false, instance.isDuce());
        instance.updateScore(PLAYER_1);
        assertEquals(false, instance.isDuce());
        instance.updateScore(PLAYER_2);
        assertEquals(false, instance.isDuce());
        instance.updateScore(PLAYER_1);
        instance.updateScore(PLAYER_1);
        assertEquals(false, instance.isDuce());
        instance.updateScore(PLAYER_2);
        instance.updateScore(PLAYER_2);
        assertEquals(true, instance.isDuce());
        instance.updateScore(PLAYER_2);
        assertEquals(false, instance.isDuce());
    }

    @Test
    public void testUpdateScore() throws Exception {

        System.out.println("updateScore");
        Scoreboard scoreboard = new Scoreboard();

        assertEquals( "love - love", scoreboard.currentScore());
        scoreboard.updateScore(PLAYER_1);
        assertEquals( "15 - love", scoreboard.currentScore());
    }

    @Test
    public void testGameHasEnded() throws Exception {
        Scoreboard scoreboard = new Scoreboard();
        scoreboard.updateScore(PLAYER_1);
        scoreboard.updateScore(PLAYER_1);
        scoreboard.updateScore(PLAYER_1);
        scoreboard.updateScore(PLAYER_1);
        scoreboard.updateScore(PLAYER_1);
        assertEquals(true, scoreboard.gameHasEnded());
    }
    
    @Test
    public void testCurrentScore() throws Exception {
        Scoreboard scoreboard = new Scoreboard();
        scoreboard.updateScore(PLAYER_1);
        assertEquals("15 - love", scoreboard.currentScore());
    }
}