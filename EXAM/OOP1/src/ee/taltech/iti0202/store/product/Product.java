package ee.taltech.iti0202.store.product;


public class Product {
    private final String name;
    private final double price;
    private final ProductType productType;
    private static int number = 0;
    private int id;
    private boolean productInShop = false;


    public static int getAndIncrementNextId() {
        return number++;
    }

    public static void resetId() {
        number = 0;
    }

    public Product(String name, double price, ProductType productType) {

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

    public double getPrice() {
        return price;
    }

    public ProductType getProductType() {
        return productType;
    }

    public Integer getId() {
        return id;
    }

    public void productAddToShop() {
        productInShop = true;
    }

    public void removeFromShop() {
        productInShop = false;
    }

    public boolean productAddedToShop() {
        return productInShop;
    }
}

