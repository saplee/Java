package ee.taltech.iti0202.coffee.machine;

public class MachineException extends Exception {
    private String reason;

    MachineException(String reason){
        this.reason = reason;
    }
}
