package exceptions;

public class UnknownOperationException extends Exception{
    public UnknownOperationException(String errorMessage) {
        super(errorMessage);
    }
    public UnknownOperationException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }    
}
