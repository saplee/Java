package ee.taltech.iti0202.coffee.exceptions;

public class GarbageContainerFull extends Exception {
    private String result;

    public GarbageContainerFull(String result) {

        this.result = result;
    }

    public String getResult() {
        return result;
    }
}
