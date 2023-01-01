package exceptions;

public class ReceiverException extends Exception{
    public ReceiverException(String errorMessage) {
        super(errorMessage);
    }
    public ReceiverException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }
}
