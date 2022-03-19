package ee.taltech.iti0202.coffee.machine;

public class MachineException extends Exception {
    private String reason;
    private Throwable cause;

    MachineException(String reason) {
        this.reason = reason;
    }

    public String getReason() {
        return reason;
    }
}
