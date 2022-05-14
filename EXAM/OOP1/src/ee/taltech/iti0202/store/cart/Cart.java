package ee.taltech.iti0202.store.cart;

import ee.taltech.iti0202.store.product.Product;
import ee.taltech.iti0202.store.shops.Shop;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Product> productList = new ArrayList<>();
    private Shop shop;

    public Cart() {
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void addProduct(Product product) {
        if (!productList.contains(product)) {
            productList.add(product);
        }
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public Shop getShop() {
        return shop;
    }
}
