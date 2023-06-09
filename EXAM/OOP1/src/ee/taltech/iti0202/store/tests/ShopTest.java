package ee.taltech.iti0202.store.tests;

import ee.taltech.iti0202.store.client.Client;
import ee.taltech.iti0202.store.client.ClientBuilder;
import ee.taltech.iti0202.store.exceptions.CannotAddProductToShop;
import ee.taltech.iti0202.store.exceptions.NoClientCartFound;
import ee.taltech.iti0202.store.exceptions.NoProductInCart;
import ee.taltech.iti0202.store.exceptions.NoProductInShop;
import ee.taltech.iti0202.store.exceptions.NotEnoughBonusPoints;
import ee.taltech.iti0202.store.exceptions.NotEnoughMoney;
import ee.taltech.iti0202.store.product.Product;
import ee.taltech.iti0202.store.product.ProductType;
import ee.taltech.iti0202.store.shops.AllShop;
import ee.taltech.iti0202.store.shops.FoodShop;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static ee.taltech.iti0202.store.product.Product.resetId;
import static org.junit.jupiter.api.Assertions.fail;


class ShopTest {

    @Test
    void testGetShopName() throws CannotAddProductToShop {
        FoodShop foodShop = new FoodShop("Food Market", 100);
        Assertions.assertEquals("Food Market", foodShop.getName());
        resetId();
    }

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
    void testAddProductToShopWhenItIsAnOtherShop() throws CannotAddProductToShop {
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
    void testGetShopClientsAfterSellingProducts() throws CannotAddProductToShop, NoClientCartFound, NotEnoughMoney,
            NoProductInCart {
        Product product = new Product("Apple", 1.2, ProductType.FOOD);
        Product product1 = new Product("Orange", 1.2, ProductType.FOOD);
        Product product2 = new Product("Potato", 5, ProductType.FOOD);
        Product product3 = new Product("Fish", 7, ProductType.FOOD);
        Client client = new ClientBuilder().setName("Jaan").setAge(19).setMoney(1000).createClient();
        Client client2 = new ClientBuilder().setName("Taavi").setAge(28).setMoney(100).createClient();
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

    @Test
    void testGetClientCart() throws CannotAddProductToShop, NoClientCartFound, NotEnoughMoney, NoProductInCart {
        Product product = new Product("Apple", 1.2, ProductType.FOOD);
        Product product1 = new Product("Orange", 1.2, ProductType.FOOD);
        Product product2 = new Product("Potato", 5, ProductType.FOOD);
        Product product3 = new Product("Fish", 7, ProductType.FOOD);
        Client client = new ClientBuilder().setName("Jaan").setAge(19).setMoney(1000).createClient();
        FoodShop foodShop = new FoodShop("FoodMarket", 100);
        List<Product> cart = new ArrayList<>(List.of(product3, product2));
        foodShop.addProduct(product);
        foodShop.addProduct(product1);
        foodShop.addProduct(product2);
        foodShop.addProduct(product3);
        foodShop.addProductToClientCart(client, product3);
        foodShop.addProductToClientCart(client, product2);
        Assertions.assertEquals(cart, foodShop.getClientCartHashMap().get(client).getProductList());
        resetId();
    }

    @Test
    void testGetClientCartAfterClearingIt() throws CannotAddProductToShop {
        Product product = new Product("Apple", 1.2, ProductType.FOOD);
        Product product1 = new Product("Orange", 1.2, ProductType.FOOD);
        Product product2 = new Product("Potato", 5, ProductType.FOOD);
        Product product3 = new Product("Fish", 7, ProductType.FOOD);
        Client client = new ClientBuilder().setName("Jaan").setAge(19).setMoney(1000).createClient();
        FoodShop foodShop = new FoodShop("Food Market", 100);
        foodShop.addProduct(product);
        foodShop.addProduct(product1);
        foodShop.addProduct(product2);
        foodShop.addProduct(product3);
        foodShop.addProductToClientCart(client, product3);
        foodShop.addProductToClientCart(client, product2);
        foodShop.clearClientCart(client);
        Assertions.assertEquals(0, foodShop.getClientCartHashMap().get(client).getProductList().size());
        resetId();
    }

    @Test
    void testGetShopProductsAfterAddingToClientCartAndClearingIt() throws CannotAddProductToShop {
        Product product = new Product("Apple", 1.2, ProductType.FOOD);
        Product product1 = new Product("Orange", 1.2, ProductType.FOOD);
        Product product2 = new Product("Potato", 5, ProductType.FOOD);
        Product product3 = new Product("Fish", 7, ProductType.FOOD);
        Client client = new ClientBuilder().setName("Jaan").setAge(19).setMoney(1000).createClient();
        FoodShop foodShop = new FoodShop("Food Market", 100);
        foodShop.addProduct(product);
        foodShop.addProduct(product1);
        foodShop.addProduct(product2);
        foodShop.addProduct(product3);
        foodShop.addProductToClientCart(client, product3);
        foodShop.addProductToClientCart(client, product2);
        foodShop.clearClientCart(client);
        Assertions.assertEquals(4, foodShop.getProducts().size());
        resetId();
    }

    @Test
    void testGetShopProfit() throws CannotAddProductToShop {
        Product product = new Product("Apple", 1.2, ProductType.FOOD);
        Product product1 = new Product("Orange", 1.2, ProductType.FOOD);
        Product product2 = new Product("Potato", 5, ProductType.FOOD);
        Product product3 = new Product("Fish", 7, ProductType.FOOD);
        Client client = new ClientBuilder().setName("Jaan").setAge(19).setMoney(1000).createClient();
        AllShop allShop = new AllShop("Market", 10000);
        allShop.addProduct(product);
        allShop.addProduct(product1);
        allShop.addProduct(product2);
        allShop.addProduct(product3);
        allShop.addProductToClientCart(client, product3);
        allShop.addProductToClientCart(client, product2);
        Assertions.assertEquals(10000.0, allShop.getProfit());
    }

    @Test
    void testGetShopProfitAfterSellingTwoProducts() throws CannotAddProductToShop, NoClientCartFound, NotEnoughMoney,
            NoProductInCart {
        Product product = new Product("Apple", 1.2, ProductType.FOOD);
        Product product1 = new Product("Orange", 1.2, ProductType.FOOD);
        Product product2 = new Product("Potato", 5, ProductType.FOOD);
        Product product3 = new Product("Fish", 7, ProductType.FOOD);
        Client client = new ClientBuilder().setName("Jaan").setAge(19).setMoney(1000).createClient();
        AllShop allShop = new AllShop("Market", 10000);
        allShop.addProduct(product);
        allShop.addProduct(product1);
        allShop.addProduct(product2);
        allShop.addProduct(product3);
        allShop.addProductToClientCart(client, product3);
        allShop.addProductToClientCart(client, product2);
        allShop.buyProductsWithMoney(client);
        Assertions.assertEquals(10012.0, allShop.getProfit());
    }

    @Test
    void testClientTryingToBuyProductWithBonusPointsFails() throws CannotAddProductToShop {
        Product product = new Product("Apple", 1.2, ProductType.FOOD);
        Product product1 = new Product("Orange", 1.2, ProductType.FOOD);
        Product product2 = new Product("Painkiller", 10, ProductType.MEDICINE);
        Product product3 = new Product("Fish", 7, ProductType.FOOD);
        Client client = new ClientBuilder().setName("Jaan").setAge(19).setMoney(1000).createClient();
        AllShop allShop = new AllShop("Market", 100);
        allShop.addProduct(product);
        allShop.addProduct(product1);
        allShop.addProduct(product2);
        allShop.addProduct(product3);
        allShop.addProductToClientCart(client, product2);
        try {
            allShop.buyProductsWithBonusPoints(client);
        } catch (NotEnoughBonusPoints | NoProductInCart | NoClientCartFound e) {
            e.printStackTrace();
        }
    }

    @Test
    void testSearchProductsByName() throws CannotAddProductToShop {
        Product product = new Product("Apple", 1.2, ProductType.FOOD);
        Product product1 = new Product("Apple", 0.8, ProductType.FOOD);
        Product product2 = new Product("Potato", 5, ProductType.FOOD);
        Product product3 = new Product("Fish", 7, ProductType.FOOD);
        AllShop allShop = new AllShop("Market", 10000);
        List<Product> result = new ArrayList<>(List.of(product, product1));
        allShop.addProduct(product);
        allShop.addProduct(product1);
        allShop.addProduct(product2);
        allShop.addProduct(product3);
        Assertions.assertEquals(result, allShop.searchProductsByName("APPLE"));
    }


    @Test
    void testSearchProductsById() throws CannotAddProductToShop {
        Product product = new Product("Apple", 1.2, ProductType.FOOD);
        Product product1 = new Product("Apple", 0.8, ProductType.FOOD);
        Product product2 = new Product("Potato", 5, ProductType.FOOD);
        Product product3 = new Product("Fish", 7, ProductType.FOOD);
        AllShop allShop = new AllShop("Market", 10000);
        allShop.addProduct(product);
        allShop.addProduct(product1);
        allShop.addProduct(product2);
        allShop.addProduct(product3);
        Assertions.assertEquals(product, allShop.searchProductsById(0).get());
    }
    @Test
    void testSearchProductsByIdFailsNoThatIdProduct() throws CannotAddProductToShop {
        Product product = new Product("Apple", 1.2, ProductType.FOOD);
        Product product1 = new Product("Apple", 0.8, ProductType.FOOD);
        Product product2 = new Product("Potato", 5, ProductType.FOOD);
        Product product3 = new Product("Fish", 7, ProductType.FOOD);
        AllShop allShop = new AllShop("Market", 10000);
        allShop.addProduct(product);
        allShop.addProduct(product1);
        allShop.addProduct(product2);
        allShop.addProduct(product3);
        Assertions.assertEquals(Optional.empty(), allShop.searchProductsById(6));
    }
    @Test
    void testSearchProductsByPrice() throws CannotAddProductToShop {
        Product product = new Product("Apple", 1.2, ProductType.FOOD);
        Product product1 = new Product("Apple", 0.8, ProductType.FOOD);
        Product product2 = new Product("Potato", 7, ProductType.FOOD);
        Product product3 = new Product("Fish", 7, ProductType.FOOD);
        AllShop allShop = new AllShop("Market", 10000);
        allShop.addProduct(product);
        allShop.addProduct(product1);
        allShop.addProduct(product2);
        allShop.addProduct(product3);
        Assertions.assertEquals(2, allShop.searchProductsByPrice(7).size());
    }
}
