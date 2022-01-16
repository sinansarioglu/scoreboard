package exceptions;

public class OpponentsMustBeDifferentException extends Exception {
    public OpponentsMustBeDifferentException() {
        super("Opponents must be different!");
    }
}
