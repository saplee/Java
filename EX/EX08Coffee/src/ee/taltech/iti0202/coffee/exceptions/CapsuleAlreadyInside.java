package ee.taltech.iti0202.coffee.exceptions;

public class CapsuleAlreadyInside extends Exception {
    private String result;

    public CapsuleAlreadyInside(String result) {

        this.result = result;
    }

    public String getResult() {
        return result;
    }
}
