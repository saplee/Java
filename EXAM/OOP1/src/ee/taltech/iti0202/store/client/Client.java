package ee.taltech.iti0202.store.client;


import ee.taltech.iti0202.store.exceptions.CannotAddProductToShop;
import ee.taltech.iti0202.store.exceptions.CannotReturnProducts;
import ee.taltech.iti0202.store.product.Product;
import ee.taltech.iti0202.store.product.ProductType;
import ee.taltech.iti0202.store.shops.Shop;

import java.util.HashMap;
import java.util.List;

public class Client {
    private final String name;
    private final Integer age;
    private double money;
    private double bonusPoints = 0;
    private HashMap<Product, Shop> products = new HashMap<>();
    private final int AGE_LIMIT = 17;

    public Client(String name, Integer age, double money) {
        this.name = name;
        this.age = age;
        this.money = money;
        if (age <= AGE_LIMIT || money <= 0) {
            throw new RuntimeException();
        }
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public void addBonusPoints(double bonus) {
        bonusPoints += bonus;
    }

    public double getBonusPoints() {
        return bonusPoints;
    }


    public List<Product> getProducts() {
        return products.keySet().stream().toList();
    }

    public void addProduct(Product product, Shop shop){
        if (!products.containsKey(product)){
            products.put(product, shop);
        }
    }

    public void returnProduct(Product product) throws CannotReturnProducts, CannotAddProductToShop {
        if (!product.getProductType().equals(ProductType.FOOD) && products.containsKey(product)) {
            money += product.getPrice();
            products.get(product).addProductBackToShop(product);
            products.get(product).setProfit(products.get(product).getProfit() - product.getPrice());
            products.remove(product);
        } else {
            throw new CannotReturnProducts();
        }
    }
}
