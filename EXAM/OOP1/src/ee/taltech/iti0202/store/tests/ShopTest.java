package ee.taltech.iti0202.store.tests;

import ee.taltech.iti0202.store.client.Client;
import ee.taltech.iti0202.store.exceptions.CannotAddProductToShop;
import ee.taltech.iti0202.store.exceptions.NoClientCartFound;
import ee.taltech.iti0202.store.exceptions.NoProductInCart;
import ee.taltech.iti0202.store.exceptions.NoProductInShop;
import ee.taltech.iti0202.store.exceptions.NotEnoughMoney;
import ee.taltech.iti0202.store.product.Product;
import ee.taltech.iti0202.store.product.ProductType;
import ee.taltech.iti0202.store.shops.AllShop;
import ee.taltech.iti0202.store.shops.FoodShop;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static ee.taltech.iti0202.store.product.Product.resetId;
import static org.junit.jupiter.api.Assertions.fail;


class ShopTest {

    @Test
    void testGetShopProducts() throws CannotAddProductToShop {
        Product product = new Product("Apple", 1.2, ProductType.FOOD);
        Product product1 = new Product("Orange", 1.2, ProductType.FOOD);
        List<Product> result = new ArrayList<>(List.of(product, product1));
        FoodShop foodShop = new FoodShop("FoodMarket", 100);
        foodShop.addProduct(product);
        foodShop.addProduct(product1);
        Assertions.assertEquals(result, foodShop.getProducts());
        resetId();
    }

    @Test
    void testGetShopProductsAmount() throws CannotAddProductToShop {
        Product product = new Product("Apple", 1.2, ProductType.FOOD);
        Product product1 = new Product("Orange", 1.2, ProductType.FOOD);
        FoodShop foodShop = new FoodShop("FoodMarket", 100);
        foodShop.addProduct(product);
        foodShop.addProduct(product1);
        Assertions.assertEquals(2, foodShop.getProducts().size());
        resetId();
    }

    @Test
    void testGetShopProductsWhenRemovingOne() throws CannotAddProductToShop, NoProductInShop {
        Product product = new Product("Apple", 1.2, ProductType.FOOD);
        Product product1 = new Product("Orange", 1.2, ProductType.FOOD);
        List<Product> result = new ArrayList<>(List.of(product1));
        FoodShop foodShop = new FoodShop("FoodMarket", 100);
        foodShop.addProduct(product);
        foodShop.addProduct(product1);
        foodShop.removeProduct(product);
        Assertions.assertEquals(result, foodShop.getProducts());
        resetId();
    }

    @Test
    void testTryingToRemoveProductButProductNotInShop() throws CannotAddProductToShop {
        Product product = new Product("Apple", 1.2, ProductType.FOOD);
        Product product1 = new Product("Orange", 1.2, ProductType.FOOD);
        Product product2 = new Product("PC", 1000, ProductType.ELECTRONICS);
        FoodShop foodShop = new FoodShop("FoodMarket", 100);
        foodShop.addProduct(product);
        foodShop.addProduct(product1);
        try {
            foodShop.removeProduct(product2);
        } catch (NoProductInShop e) {
            e.printStackTrace();
        }
        resetId();
    }

    @Test
    void testGetShopProductsAddingMoreProducts() throws CannotAddProductToShop {
        Product product = new Product("Apple", 1.2, ProductType.FOOD);
        Product product1 = new Product("Orange", 1.2, ProductType.FOOD);
        Product product2 = new Product("Potato", 5, ProductType.FOOD);
        Product product3 = new Product("Fish", 7, ProductType.FOOD);
        FoodShop foodShop = new FoodShop("FoodMarket", 100);
        foodShop.addProduct(product);
        foodShop.addProduct(product1);
        foodShop.addProduct(product2);
        foodShop.addProduct(product3);
        Assertions.assertEquals(4, foodShop.getProducts().size());
        resetId();
    }

    @Test
    void testAddingProductToShopWhenItIsAnOtherShop() throws CannotAddProductToShop {
        Product product = new Product("Apple", 1.2, ProductType.FOOD);
        Product product1 = new Product("Orange", 1.2, ProductType.FOOD);
        Product product2 = new Product("Potato", 5, ProductType.FOOD);
        Product product3 = new Product("Fish", 7, ProductType.FOOD);
        FoodShop foodShop = new FoodShop("FoodMarket", 100);
        AllShop allShop = new AllShop("Prisma", 10000);
        foodShop.addProduct(product);
        foodShop.addProduct(product1);
        foodShop.addProduct(product2);
        foodShop.addProduct(product3);
        try {
            allShop.addProduct(product);
        } catch (CannotAddProductToShop e) {
            Assertions.assertEquals("Can't add that product to store!", e.getMessage());
        }
        resetId();
    }

    @Test
    void testAddingNotFoodTypeProductToFoodShop() throws CannotAddProductToShop {
        Product product = new Product("Apple", 1.2, ProductType.FOOD);
        Product product1 = new Product("Orange", 1.2, ProductType.FOOD);
        Product product2 = new Product("USB", 2, ProductType.ELECTRONICS);
        FoodShop foodShop = new FoodShop("FoodMarket", 100);
        foodShop.addProduct(product);
        foodShop.addProduct(product1);
        try {
            foodShop.addProduct(product2);
            fail();
        } catch (CannotAddProductToShop e) {
            Assertions.assertEquals("Can't add that product to store!", e.getMessage());
        }
        resetId();
    }

    @Test
    void testGetShopClientsWhenNoClients() throws CannotAddProductToShop {
        Product product = new Product("Apple", 1.2, ProductType.FOOD);
        Product product1 = new Product("Orange", 1.2, ProductType.FOOD);
        Product product2 = new Product("Potato", 5, ProductType.FOOD);
        Product product3 = new Product("Fish", 7, ProductType.FOOD);
        FoodShop foodShop = new FoodShop("FoodMarket", 100);
        foodShop.addProduct(product);
        foodShop.addProduct(product1);
        foodShop.addProduct(product2);
        foodShop.addProduct(product3);
        Assertions.assertEquals(0, foodShop.getClients().size());
        resetId();
    }

    @Test
    void testGetShopClients() throws CannotAddProductToShop, NoClientCartFound, NotEnoughMoney, NoProductInCart {
        Product product = new Product("Apple", 1.2, ProductType.FOOD);
        Product product1 = new Product("Orange", 1.2, ProductType.FOOD);
        Product product2 = new Product("Potato", 5, ProductType.FOOD);
        Product product3 = new Product("Fish", 7, ProductType.FOOD);
        Client client = new Client("Jaan", 19, 1000);
        Client client2 = new Client("Taavi", 28, 100);
        FoodShop foodShop = new FoodShop("FoodMarket", 100);
        foodShop.addProduct(product);
        foodShop.addProduct(product1);
        foodShop.addProduct(product2);
        foodShop.addProduct(product3);
        foodShop.addProductToClientCart(client, product3);
        foodShop.addProductToClientCart(client, product2);
        foodShop.addProductToClientCart(client2, product);
        foodShop.buyProductsWithMoney(client);
        foodShop.buyProductsWithMoney(client2);
        Assertions.assertEquals(2, foodShop.getClients().size());
        resetId();
    }
}
