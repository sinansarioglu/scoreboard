package exceptions;

public class MatchAlreadyStartedException extends Exception {
    public MatchAlreadyStartedException() {
        super("Match is already started");
    }
}
