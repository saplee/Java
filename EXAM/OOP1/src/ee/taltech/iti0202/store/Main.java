package ee.taltech.iti0202.store;

import ee.taltech.iti0202.store.client.Client;
import ee.taltech.iti0202.store.exceptions.CannotAddProductToShop;
import ee.taltech.iti0202.store.exceptions.NoClientCartFound;
import ee.taltech.iti0202.store.exceptions.NoProductInCart;
import ee.taltech.iti0202.store.exceptions.NotEnoughMoney;
import ee.taltech.iti0202.store.product.Product;
import ee.taltech.iti0202.store.product.ProductType;
import ee.taltech.iti0202.store.shops.AllShop;
import ee.taltech.iti0202.store.shops.FoodShop;

public class Main {
    private static final double PROFIT = 1000;
    private static final double SECOND_SHOP_PROFIT = 10000;
    private static final double TV_PRICE = 570;
    private static final double PAINKILLER_PRICE = 8;
    private static final int AGO_AGE = 29;
    private static final double MONEY = 1000;
    private static final int GERT_AGE = 35;
    private static final int MEELIS_AGE = 17;

    public static void main(String[] args) throws CannotAddProductToShop, NotEnoughMoney, NoClientCartFound, NoProductInCart {
        FoodShop foodShop = new FoodShop("Selver", PROFIT);
        AllShop allShop = new AllShop("Prisma", SECOND_SHOP_PROFIT);
        Product product = new Product("TV", TV_PRICE, ProductType.ELECTRONICS);
        Product product1 = new Product("Painkiller", PAINKILLER_PRICE, ProductType.MEDICINE);
        Product product2 = new Product("Spoon", 3, ProductType.HOUSE_HOLD);
        Product product3 = new Product("Apple", 1000, ProductType.FOOD);
        Client client = new Client("Ago", AGO_AGE, MONEY);
        Client client1 = new Client("Annemari", 20, MONEY);

        try {
            Client client2 = new Client("Gert", GERT_AGE, -5);
        } catch (Exception e) {
            e.printStackTrace(); //RuntimeException
        }

        try {
            Client client5 = new Client("Meelis", MEELIS_AGE, MONEY);
        } catch (Exception e) {
            e.printStackTrace(); //RuntimeException
        }

        allShop.addProduct(product);
        allShop.addProduct(product1);
        System.out.println(allShop.getProducts().get(1).getName()); // Painkiller


        try {
            foodShop.addProduct(product);
        } catch (CannotAddProductToShop e) {
            System.out.println(e.getMessage()); // Product is already in some other store
        }
        allShop.addProductToClientCart(client, product);
        allShop.buyProductsWithMoney(client);
        System.out.println(client.getProducts().get(0).getName()); // TV
        System.out.println(client.getMoney()); // 430.0

        System.out.println(allShop.getProfit()); // 10570.0

        System.out.println(allShop.getProducts().size()); // 1

        System.out.println(allShop.getClients().get(0).getName()); // Ago
        System.out.println(foodShop.getClients()); // []
    }
}
