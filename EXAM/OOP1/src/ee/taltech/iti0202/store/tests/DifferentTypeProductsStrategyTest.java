package ee.taltech.iti0202.store.tests;

import ee.taltech.iti0202.store.client.Client;
import ee.taltech.iti0202.store.client.ClientBuilder;
import ee.taltech.iti0202.store.exceptions.CannotAddProductToShop;
import ee.taltech.iti0202.store.exceptions.NoClientCartFound;
import ee.taltech.iti0202.store.exceptions.NoProductInCart;
import ee.taltech.iti0202.store.exceptions.NotEnoughMoney;
import ee.taltech.iti0202.store.product.Product;
import ee.taltech.iti0202.store.product.ProductType;
import ee.taltech.iti0202.store.shops.AllShop;

import ee.taltech.iti0202.store.strategy.DifferentTypeProductsStrategy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


class DifferentTypeProductsStrategyTest {
    @Test
    void testGetClientProductsAfterDifferentTypeStrategy() throws CannotAddProductToShop, NoClientCartFound,
            NotEnoughMoney, NoProductInCart {
        Product product = new Product("Keyboard", 55, ProductType.ELECTRONICS);
        Product product1 = new Product("Apple", 0.8, ProductType.FOOD);
        Product product2 = new Product("Lollipop", 0.2, ProductType.FOOD);
        Product product3 = new Product("Lipstick", 7, ProductType.COSMETIC);
        Product product4 = new Product("Painkiller", 4, ProductType.MEDICINE);
        AllShop allShop = new AllShop("Market", 1000);
        Client client = new ClientBuilder().setName("Ago").setAge(19).setMoney(100).createClient();
        allShop.addProduct(product);
        allShop.addProduct(product1);
        allShop.addProduct(product2);
        allShop.addProduct(product3);
        allShop.addProduct(product4);
        List<Product> result = new ArrayList<>(List.of(product, product2, product3, product4));
        DifferentTypeProductsStrategy differentTypeProductsStrategy =
                new DifferentTypeProductsStrategy(client, allShop);
        allShop.giveStrategy(differentTypeProductsStrategy);
        allShop.buyProductsWithMoney(client);
        Assertions.assertTrue(client.getProducts().containsAll(result));
    }

    @Test
    void testGetClientProductsAfterDifferentTypeStrategyAllSameTypeProducts() throws CannotAddProductToShop,
            NoClientCartFound,
            NotEnoughMoney, NoProductInCart {
        Product product = new Product("Orange", 1.4, ProductType.FOOD);
        Product product1 = new Product("Apple", 0.8, ProductType.FOOD);
        Product product2 = new Product("Lollipop", 0.2, ProductType.FOOD);
        Product product3 = new Product("Pizza", 5, ProductType.FOOD);
        Product product4 = new Product("Meat", 4, ProductType.FOOD);
        AllShop allShop = new AllShop("Market", 1000);
        Client client = new ClientBuilder().setName("Ago").setAge(19).setMoney(100).createClient();
        allShop.addProduct(product);
        allShop.addProduct(product1);
        allShop.addProduct(product2);
        allShop.addProduct(product3);
        allShop.addProduct(product4);
        DifferentTypeProductsStrategy differentTypeProductsStrategy =
                new DifferentTypeProductsStrategy(client, allShop);
        allShop.giveStrategy(differentTypeProductsStrategy);
        allShop.buyProductsWithMoney(client);
        Assertions.assertEquals(1, client.getProducts().size());
        Assertions.assertEquals("Lollipop", client.getProducts().get(0).getName());
    }
}
