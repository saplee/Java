package ee.taltech.iti0202.tk2.shop;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Shop {
    private List<Product> products = new ArrayList<>();

    /**
     * @param product
     * @return
     */
    public boolean addProduct(Product product) {
        if (!products.contains(product)
                && !products.stream().map(Product::getPrice).toList().contains(product.getPrice()) && product.getPrice() > 0) {
            products.add(product);
            return true;
        }
        return false;
    }

    /**
     * @param name
     * @param maxPrice
     * @return
     */
    public Optional<Product> sellProduct(String name, int maxPrice) {
        products.sort(Comparator.comparing(Product::getPrice));
        Product result = null;
        for (Product product : products) {
            if (product.getName() != null && product.getName().equals(name)) {
                ;
                result = product;
            }
        }
        products.remove(result);
        return Optional.ofNullable(result);
    }

    /**
     * @return
     */
    public List<Product> getProducts() {
        return products;
    }

    public static void main(String[] args) {


        Shop shop = new Shop();
        Product p1 = new Product("Bread", 3);
        Product p2 = new Product("Milk", 4);
        Product p3 = new Product("Milk", 4);
        Product p4 = new Product("Milk", 7);
        Product p5 = new Product("Cheat", -1);
        Product p6 = new Product("", 2);
        Product p7 = new Product(11);
        System.out.println(shop.addProduct(p1));  // true
        System.out.println(shop.addProduct(p2));  // true
        System.out.println(shop.addProduct(p3));  // false
        System.out.println(shop.addProduct(p4));  // true
        System.out.println(shop.addProduct(p5));  // false
        System.out.println(shop.addProduct(p6));  // true
        System.out.println(shop.addProduct(p7));  // true
        System.out.println(shop.sellProduct("Pizza", 10));  // Optional.empty
        System.out.println(shop.sellProduct("Milk", 10).get());  // Milk (7)
        System.out.println(shop.sellProduct("Milk", 10).get());  // Milk (4)
        System.out.println(shop.sellProduct("Milk", 10));  // Optional.empty
        System.out.println(shop.sellProduct("", 20).get());  //  (2)
    }
}
