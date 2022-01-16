package exceptions;

import models.Team;

public class TeamPlaysMatchException extends Exception {
    public TeamPlaysMatchException(String teamName) {
        super("Team " + teamName + " currently plays a match!");
    }
}
