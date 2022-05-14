package ee.taltech.iti0202.store.cart;

import ee.taltech.iti0202.store.exceptions.CannotChangeShop;
import ee.taltech.iti0202.store.exceptions.CannotReturnProducts;
import ee.taltech.iti0202.store.product.Product;
import ee.taltech.iti0202.store.shops.FoodShop;
import ee.taltech.iti0202.store.shops.Shop;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Product> productList = new ArrayList<>();

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
}
