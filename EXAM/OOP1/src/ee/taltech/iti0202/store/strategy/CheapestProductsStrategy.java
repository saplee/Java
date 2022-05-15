package ee.taltech.iti0202.store.strategy;

import ee.taltech.iti0202.store.client.Client;
import ee.taltech.iti0202.store.product.Product;
import ee.taltech.iti0202.store.product.ProductType;
import ee.taltech.iti0202.store.shops.Shop;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class CheapestProductsStrategy extends Strategy {


    public CheapestProductsStrategy(Client client, Shop shop) {
        super(client, shop);

    }

    @Override
    public void getProducts() {
        double budget = client.getMoney();
        HashSet<ProductType> usedTypes = new HashSet<>();
        HashSet<String> usedProductNames = new HashSet<>();
        List<Product> sortedByPrice = shop.getProducts().stream().
                sorted(Comparator.comparing(Product::getPrice)).toList();
        for (Product product : sortedByPrice) {
            if ((!usedTypes.contains(product.getProductType()) || !usedProductNames.contains(product.getName()))
                    && budget - product.getPrice() >= 0) {
                budget -= product.getPrice();
                usedProductNames.add(product.getName().toLowerCase());
                usedTypes.add(product.getProductType());
                shop.addProductToClientCart(client, product);
            }
        }
    }
}
