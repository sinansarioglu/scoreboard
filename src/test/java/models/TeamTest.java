package models;

import exceptions.TeamIsAlreadyCreatedException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TeamTest {

    private final String teamName = "Uruguay";

    @Test
    public void createTeamSuccessfully() throws TeamIsAlreadyCreatedException {
        Team team = new Team(teamName);
        assertNotNull(team.getId());
        assertEquals(teamName, team.getName());
    }

    @Test
    public void createDifferentTeamsWithSameTeamName_throwsTeamIsAlreadyCreatedException() {
        assertThrows(TeamIsAlreadyCreatedException.class, () -> new Team(teamName));
    }
}