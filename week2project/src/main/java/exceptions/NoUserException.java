package exceptions;

public class NoUserException extends Exception{
    public NoUserException(){
        super("No such user!");
    }
}
