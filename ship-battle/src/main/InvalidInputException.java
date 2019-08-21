package main;

public final class InvalidInputException extends RuntimeException {

    private final String input;


    public InvalidInputException(final String input) {

        super("Invalid input: "+input);
        this.input = input;
    }
}