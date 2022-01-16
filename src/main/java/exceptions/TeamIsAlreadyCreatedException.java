package exceptions;

import models.Team;

public class TeamIsAlreadyCreatedException extends Exception {
    public TeamIsAlreadyCreatedException(String teamName) {
        super("Team with name " + teamName + " is already created");
    }
}
