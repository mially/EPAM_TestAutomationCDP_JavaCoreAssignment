package exceptions;

public class IsTakenByYouException extends Exception {
    public IsTakenByYouException (){
        super("This toy is already taken by you!");
    }
}
