package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScoreTest {

    @Test
    public void createScore() {
        Score score = new Score();
        assertNotNull(score.getId());
        assertEquals(0, score.getHomeScore());
        assertEquals(0, score.getAwayScore());
    }
}