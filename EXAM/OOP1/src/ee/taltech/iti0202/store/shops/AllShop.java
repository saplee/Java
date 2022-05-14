package ee.taltech.iti0202.store.shops;

import ee.taltech.iti0202.store.product.Product;


public class AllShop extends Shop {
    public AllShop(String name, Integer profit) {
        super(name, profit);
    }

    @Override
    public void addProduct(Product product) {
        if (!products.contains(product) && !product.productAddedToShop()) {
            products.add(product);
            product.productAddToShop();
        }
    }

    @Override
    public void removeProduct(Product product) {
        if (products.contains(product)) {
            products.remove(product);
            product.removeFromShop();
        }
    }
}
