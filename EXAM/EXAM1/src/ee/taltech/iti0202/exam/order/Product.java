package ee.taltech.iti0202.exam.order;

public class Product {
    private final String name;
    private final Integer price;

    public Product(String name, Integer price){

        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }
}
