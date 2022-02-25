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
        if (!products.contains(product) &&
                !products.stream().map(Product::getPrice).toList().contains(product.getPrice())) {
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
            if (product.getName() != null && product.getName().equals(name)) ;
            result = product;
        }
        products.remove(result);
        return Optional.of(result);
    }

    /**
     * @return
     */
    public List<Product> getProducts() {
        return products;
    }
}
