package ee.taltech.iti0202.coffee.exceptions;

public class MachineException extends Exception {
    private String result;


    public MachineException(String result) {

        this.result = result;
    }

    public String getResult() {
        return result;
    }
}
