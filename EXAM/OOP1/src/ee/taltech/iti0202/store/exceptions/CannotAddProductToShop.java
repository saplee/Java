package ee.taltech.iti0202.store.exceptions;

public class CannotAddProductToShop extends Throwable {

    public CannotAddProductToShop() {
    }

    public String getMessage() {
        return "Can't add that product to store!";
    }
}
