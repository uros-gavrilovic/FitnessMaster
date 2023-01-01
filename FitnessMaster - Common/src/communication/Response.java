package communication;

import java.io.Serializable;

public class Response implements Serializable {
    ResponseType responseType;
    Object result;
    Exception exception;

    public Response() {
    }
    public Response(ResponseType responseType, Object result, Exception exception) {
        this.responseType = responseType;
        this.result = result;
        this.exception = exception;
    }

    @Override
    public String toString() {
        return "RESPONSE\n"
                + "\tTYPE: " + responseType + "\n"
                + "\tRESULT: " + result + "\n"
                + "\tEXCEPTION: " + exception;
    }

    public ResponseType getResponseType() {
        return responseType;
    }
    public void setResponseType(ResponseType responseType) {
        this.responseType = responseType;
    }
    public Object getResult() {
        return result;
    }
    public void setResult(Object result) {
        this.result = result;
    }
    public Exception getException() {
        return exception;
    }
    public void setException(Exception exception) {
        this.exception = exception;
    }   
}
