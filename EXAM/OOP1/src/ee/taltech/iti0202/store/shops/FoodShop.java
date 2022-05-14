package ee.taltech.iti0202.store.shops;

import ee.taltech.iti0202.store.product.Product;
import ee.taltech.iti0202.store.product.ProductType;

public class FoodShop extends Shop {
    public FoodShop(String name, Integer profit) {
        super(name, profit);
    }

    @Override
    public void addProduct(Product product) {
        if (product.getProductType().equals(ProductType.FOOD) && !product.productAddedToShop()) {
            products.add(product);
            product.productAddToShop();
        }
    }
}
