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
    private Shop shop;

    public Cart() {
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void addProduct(Product product) {
        if (!productList.contains(product) && shop.getProducts().contains(product)) {
            productList.add(product);
        }
    }

    public void setShop(Shop shop) throws CannotChangeShop {
        if (productList.size() == 0) {
            this.shop = shop;
        } else {
            throw new CannotChangeShop();
        }
    }

    public Shop getShop() {
        return shop;
    }

    public void clearCart() throws CannotReturnProducts {
        productList.clear();
    }
}
