package exceptions;

public class IsBrokenException extends Exception{
    public IsBrokenException () {
        super("It's broken, sorry :(");
    }
}
