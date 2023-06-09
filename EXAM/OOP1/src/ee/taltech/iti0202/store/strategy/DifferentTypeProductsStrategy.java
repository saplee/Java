package ee.taltech.iti0202.store.strategy;

import ee.taltech.iti0202.store.client.Client;
import ee.taltech.iti0202.store.product.Product;
import ee.taltech.iti0202.store.product.ProductType;
import ee.taltech.iti0202.store.shops.Shop;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class DifferentTypeProductsStrategy extends Strategy {

    public DifferentTypeProductsStrategy(Client client, Shop shop) {
        super(client, shop);
    }
    /**
     * Client will get different type of product from given shop to his/her shopping cart at that shop.
     * No same Type can't be in the shopping cart.
     */
    @Override
    public void getProducts() {
        double budget = client.getMoney();
        HashSet<ProductType> usedTypes = new HashSet<>();
        List<Product> sortedByPrice = shop.getProducts().stream().
                sorted(Comparator.comparing(Product::getPrice)).toList();
        for (Product product : sortedByPrice) {
            if (!shop.getClientCartHashMap().get(client).getProductList().contains(product)
                    && (!usedTypes.contains(product.getProductType())
                    && budget - product.getPrice() >= 0)) {
                budget -= product.getPrice();
                usedTypes.add(product.getProductType());
                shop.addProductToClientCart(client, product);
            }
        }
    }
}
