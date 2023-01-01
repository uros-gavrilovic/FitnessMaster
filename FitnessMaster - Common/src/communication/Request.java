package communication;

import java.io.Serializable;

public class Request implements Serializable {
    Operation operation;
    Object argument;

    public Request() {
    }
    public Request(Operation operation, Object argument) {
        this.operation = operation;
        this.argument = argument;
    }

    @Override
    public String toString() {
        return "\nREQUEST:\n"
                + "\tOPERATION: " + operation + "\n"
                + "\tARGUMENT: " + argument + "\n";
    }

    public Operation getOperation() {
        return operation;
    }
    public void setOperation(Operation operation) {
        this.operation = operation;
    }
    public Object getArgument() {
        return argument;
    }
    public void setArgument(Object argument) {
        this.argument = argument;
    }
}
