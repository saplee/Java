package ee.taltech.iti0202.tk2.shop;

public class Product {
    private String name;
    private Integer price;

    /**
     * @param name
     * @param price
     */
    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    /**
     * @param price
     */
    public Product(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    /**
     * @return
     */
    public int getPrice() {
        return price;
    }

    /**
     * @return
     */
    public String toString() {
        if (name != null) {
            return name + "(" + price + ")";
        }
        return "(" + price + ")";
    }
}
