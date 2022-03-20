package ee.taltech.iti0202.coffee.exceptions;

public class EmptyWaterTankException extends Exception {
    private String result;

    public EmptyWaterTankException(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }
}
