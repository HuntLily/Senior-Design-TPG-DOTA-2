package ca.dal.tpg.exceptions;

import ca.dal.tpg.Run;
import ca.dal.tpg.RunStatus;

public class FailedToStartDota2 extends Exception {

    private Run run;
    private String message;
    private Exception cause;

    public FailedToStartDota2(Run r, String message, Exception cause){
        r.setStatus(RunStatus.ERROR);
        r.setError(this);
        this.run = r;
        this.message = message;
        this.cause = cause;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public Run getRun(){
        return run;
    }

    public Exception getCause(){
        return cause;
    }
}
