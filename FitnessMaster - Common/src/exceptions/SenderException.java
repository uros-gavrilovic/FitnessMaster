package exceptions;

public class SenderException extends Exception{
    public SenderException(Throwable err){
        super(err);
    }
    public SenderException(String errorMessage) {
        super(errorMessage);
    }
    public SenderException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }
}
