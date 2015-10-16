package exceptions;

public class NoPlayroomException extends Exception {

    public NoPlayroomException() {
        super("No such playroom!");
    }
}
