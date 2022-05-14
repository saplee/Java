package ee.taltech.iti0202.store.client;

import ee.taltech.iti0202.store.cart.Cart;
import ee.taltech.iti0202.store.product.Product;
import ee.taltech.iti0202.store.product.ProductType;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private final String name;
    private final Integer age;
    private Integer money;
    private Integer bonusPoints = 0;
    private List<Product> products = new ArrayList<>();

    public Client(String name, Integer age, Integer money) {
        this.name = name;
        this.age = age;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public void addBonusPoints(Integer bonus) {
        bonusPoints += bonus;
    }

    public Integer getBonusPoints() {
        return bonusPoints;
    }


    public List<Product> getProducts() {
        return products;
    }

    public void returnProduct(Product product) {
        if (!product.getProductType().equals(ProductType.FOOD) && products.contains(product)) {
            money += product.getPrice();
            products.remove(product);
        }
    }
}
