package ee.taltech.iti0202.store.product;


public class Product {
    private final String name;
    private final Integer price;
    private final ProductType productType;
    private static int number = 0;
    private int id;
    private boolean productAdded = false;


    public static int getAndIncrementNextId() {
        return number++;
    }

    public Product(String name, Integer price, ProductType productType) {

        this.name = name;
        this.price = price;
        this.productType = productType;
        this.id = getAndIncrementNextId();
        if (price <= 0) {
            throw new RuntimeException();
        }
    }

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }

    public ProductType getProductType() {
        return productType;
    }

    public Integer getId() {
        return id;
    }

    public void productAddToShop() {
        productAdded = true;
    }

    public void removeFromShop() {
        productAdded = false;
    }

    public boolean productAddedToShop() {
        return productAdded;
    }
}

