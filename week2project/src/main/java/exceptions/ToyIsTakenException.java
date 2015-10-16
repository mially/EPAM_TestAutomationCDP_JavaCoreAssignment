package exceptions;

public class ToyIsTakenException extends Exception{
    public ToyIsTakenException(){
        super("This toy is already taken. Wait for your turn!");
    }
}
