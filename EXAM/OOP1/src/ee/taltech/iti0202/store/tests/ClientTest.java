package ee.taltech.iti0202.store.tests;

import ee.taltech.iti0202.store.client.Client;
import ee.taltech.iti0202.store.exceptions.CannotAddProductToShop;
import ee.taltech.iti0202.store.exceptions.CannotReturnProducts;
import ee.taltech.iti0202.store.exceptions.NoClientCartFound;
import ee.taltech.iti0202.store.exceptions.NoProductInCart;
import ee.taltech.iti0202.store.exceptions.NotEnoughMoney;
import ee.taltech.iti0202.store.product.Product;
import ee.taltech.iti0202.store.product.ProductType;
import ee.taltech.iti0202.store.shops.AllShop;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static ee.taltech.iti0202.store.product.Product.resetId;

class ClientTest {
    @Test
    void testGetClientName() {
        Client client = new Client("Ago", 25, 100);
        Assertions.assertEquals("Ago", client.getName());
    }

    @Test
    void testGetClientAge() {
        Client client = new Client("Ago", 25, 100);
        Assertions.assertEquals(25, client.getAge());
    }

    @Test
    void testGetClientMoney() {
        Client client = new Client("Ago", 25, 100);
        Assertions.assertEquals(100, client.getMoney());
    }

    @Test
    void testWrongAgeClient() {
        try {
            Client client = new Client("Ago", -1, 100);
        } catch (Exception ignored) {
        }
    }

    @Test
    void testGetClientProductsWhenNoBuy() {
        Client client = new Client("Ago", 25, 100);
        List<Product> productList = new ArrayList<>();
        Assertions.assertEquals(productList, client.getProducts());
        resetId();
    }

    @Test
    void testGetClientProductsWhenPurchasedProduct() throws CannotAddProductToShop, NoClientCartFound, NotEnoughMoney,
            NoProductInCart {
        Client client = new Client("Ago", 25, 100);
        AllShop shop = new AllShop("Prisma", 1000);
        List<Product> productList = new ArrayList<>();
        Product product = new Product("Spoon", 3, ProductType.HOUSE_HOLD);
        shop.addProduct(product);
        shop.addProductToClientCart(client, product);
        shop.buyProductsWithMoney(client);
        productList.add(product);
        Assertions.assertEquals(productList, client.getProducts());
        resetId();
    }

    @Test
    void testClientTryToBuyProductButNotEnoughMoney() throws CannotAddProductToShop, NoClientCartFound,
            NoProductInCart {
        Client client = new Client("Ago", 25, 10);
        AllShop shop = new AllShop("Prisma", 1000);
        Product product = new Product("Table", 11, ProductType.HOUSE_HOLD);
        shop.addProduct(product);
        shop.addProductToClientCart(client, product);
        try {
            shop.buyProductsWithMoney(client);
        } catch (NotEnoughMoney e) {
            e.printStackTrace();
        }
        resetId();
    }

    @Test
    void testGetClientProductsWhenPurchasedProductAndReturningIt() throws CannotAddProductToShop, NoClientCartFound,
            NotEnoughMoney, NoProductInCart, CannotReturnProducts {
        Client client = new Client("Ago", 25, 100);
        AllShop shop = new AllShop("Prisma", 1000);
        List<Product> productList = new ArrayList<>();
        Product product = new Product("Phone", 100, ProductType.ELECTRONICS);
        shop.addProduct(product);
        shop.addProductToClientCart(client, product);
        shop.buyProductsWithMoney(client);
        client.returnProduct(product);
        Assertions.assertEquals(productList, client.getProducts());
        resetId();
    }

    @Test
    void testGetClientMoneyWhenPurchasedProductAndReturningIt() throws CannotAddProductToShop, NoClientCartFound,
            NotEnoughMoney, NoProductInCart, CannotReturnProducts {
        Client client = new Client("Ago", 25, 100);
        AllShop shop = new AllShop("Prisma", 1000);
        Product product = new Product("Phone", 100, ProductType.ELECTRONICS);
        shop.addProduct(product);
        shop.addProductToClientCart(client, product);
        shop.buyProductsWithMoney(client);
        client.returnProduct(product);
        Assertions.assertEquals(100, client.getMoney());
        resetId();
    }

    @Test
    void testGetClientBonusPointsWhenPurchasedProduct() throws CannotAddProductToShop, NoClientCartFound,
            NotEnoughMoney, NoProductInCart, CannotReturnProducts {
        Client client = new Client("Ago", 25, 100);
        AllShop shop = new AllShop("Prisma", 1000);
        Product product = new Product("Phone", 100, ProductType.ELECTRONICS);
        shop.addProduct(product);
        shop.addProductToClientCart(client, product);
        shop.buyProductsWithMoney(client);
        client.returnProduct(product);
        Assertions.assertEquals(25.0, client.getBonusPoints());
        resetId();
    }

    @Test
    void testClientPurchasedProductAndTryingToReturnWrongProduct() throws CannotAddProductToShop, NoClientCartFound,
            NotEnoughMoney, NoProductInCart {
        Client client = new Client("Ago", 25, 200);
        AllShop shop = new AllShop("Prisma", 1000);
        Product product = new Product("Phone", 150, ProductType.ELECTRONICS);
        Product product1 = new Product("TV", 1000, ProductType.ELECTRONICS);
        shop.addProduct(product);
        shop.addProductToClientCart(client, product);
        shop.buyProductsWithMoney(client);
        try {
            client.returnProduct(product1);
        } catch (CannotReturnProducts e) {
            e.printStackTrace();
        }
        resetId();
    }
}
