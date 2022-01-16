package exceptions;

import models.Match;

import java.util.UUID;

public class MatchDoesNotExistException extends Exception {
    public MatchDoesNotExistException(UUID id) {
        super("Match with id + " + id.toString() + " does not exist!");
    }
}
