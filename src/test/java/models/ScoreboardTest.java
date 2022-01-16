package models;

import exceptions.*;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ScoreboardTest {

    private static Match match1, match2, match3;
    private static Scoreboard scoreboard;
    private static Team team1;

    @BeforeAll
    public static void setup() throws TeamIsAlreadyCreatedException, OpponentsMustBeDifferentException {
        team1 = new Team("Canada");
        Team team2 = new Team("Brazil");
        Team team3 = new Team("Germany");
        Team team4 = new Team("France");
        Team team5 = new Team("Italy");
        Team team6 = new Team("Argentina");
        match1 = new Match(team1, team2);
        match2 = new Match(team3, team4);
        match3 = new Match(team5, team6);
        scoreboard = new Scoreboard();
    }

    @Test
    @Order(1)
    public void createHappyPath() throws MatchAlreadyStartedException, TeamPlaysMatchException, MatchDoesNotExistException {
        scoreboard.startMatch(match1);
        scoreboard.updateMatchScore(match1.getId(), new Score(2,4));
        scoreboard.startMatch(match2);
        scoreboard.updateMatchScore(match2.getId(), new Score(3,3));
        scoreboard.startMatch(match3);
        scoreboard.updateMatchScore(match3.getId(), new Score(3,4));
        List<Match> summary = scoreboard.getSummary();
        assertEquals(0, summary.indexOf(match3));
        assertEquals(1, summary.indexOf(match2));
        assertEquals(2, summary.indexOf(match1));
    }

    @Test
    @Order(2)
    public void startSameMatchAgain_throwsMatchAlreadyStartedException() {
        assertThrows(MatchAlreadyStartedException.class, () -> scoreboard.startMatch(match1));
    }

    @Test
    @Order(3)
    public void startSameMatchAgain_throwsTeamPlaysMatchException() throws TeamIsAlreadyCreatedException, OpponentsMustBeDifferentException {
        Match match = new Match(team1, new Team("South Africa"));
        assertThrows(TeamPlaysMatchException.class, () -> scoreboard.startMatch(match));
    }

    @Test
    @Order(4)
    public void finishMatch() throws MatchDoesNotExistException {
        scoreboard.finishMatch(match2.getId());
    }

    @Test
    @Order(5)
    public void finishMatch_throwsMatchDoesNotExistException() {
        assertThrows(MatchDoesNotExistException.class, () -> scoreboard.finishMatch(match2.getId()));
    }

}