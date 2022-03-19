package ee.taltech.iti0202.coffee.machine;

public class MachineException extends Exception {
    private String result;


    MachineException(String result) {

        this.result = result;
    }

    public String getResult() {
        return result;
    }
}
