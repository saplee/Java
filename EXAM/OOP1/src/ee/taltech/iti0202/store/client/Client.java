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
    private int bonusPoints = 0;
    private HashMap<Product, Shop> products = new HashMap<>();
    private final int ageLimit = 17;
    private final double number = 0.25;

    public Client(String name, int age, double money) {
        this.name = name;
        this.age = age;
        this.money = money;
        if (age <= ageLimit || money <= 0) {
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

    public void addBonusPoints(int bonus) {
        bonusPoints += bonus;
    }

    public int getBonusPoints() {
        return bonusPoints;
    }

    public void setBonusPoints(int bonusPoints) {
        this.bonusPoints = bonusPoints;
    }

    public List<Product> getProducts() {
        return products.keySet().stream().toList();
    }

    /**
     * Adding product to client and hashmap key is product and value is shop where product came.
     * @param product
     * @param shop
     */
    public void addProduct(Product product, Shop shop) {
        if (!products.containsKey(product)) {
            products.put(product, shop);
        }
    }

    public void returnProduct(Product product) throws CannotReturnProducts, CannotAddProductToShop {
        if (!product.getProductType().equals(ProductType.FOOD) && products.containsKey(product)) {
            // Getting value from map and value is the store where the product comes from
            Shop productShop = products.get(product);
            money += product.getPrice();
            product.productFree();
            productShop.addProduct(product);
            productShop.setProfit(productShop.getProfit() - product.getPrice());
            products.remove(product);
            bonusPoints -= (int) Math.round(product.getPrice() * number);
        } else {
            throw new CannotReturnProducts();
        }
    }
}
