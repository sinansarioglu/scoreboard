package models;

import exceptions.OpponentsMustBeDifferentException;
import exceptions.TeamIsAlreadyCreatedException;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class MatchTest {

    private static final String nameHome = "Spain";
    private static final String nameAway = "Mexico";
    private static Team home;
    private static Team away;

    @BeforeAll
    public static void setup() throws TeamIsAlreadyCreatedException {
        home = new Team(nameHome);
        away = new Team(nameAway);
    }

    @Test
    @Order(1)
    public void createMatchSuccessfully() throws OpponentsMustBeDifferentException {
        Match match = new Match(home, away);
        assertNotNull(match.getId());
        assertEquals(nameHome, match.getHome().getName());
        assertEquals(nameAway, match.getAway().getName());
    }

    @Test
    @Order(2)
    public void createMatchWithSameTeams_throwsOpponentsMustBeDifferentException() throws OpponentsMustBeDifferentException {
        assertThrows(OpponentsMustBeDifferentException.class,() -> new Match(home, home));
    }
}