package ee.taltech.iti0202.store;

import ee.taltech.iti0202.store.client.Client;
import ee.taltech.iti0202.store.exceptions.CannotAddProductToShop;
import ee.taltech.iti0202.store.product.Product;
import ee.taltech.iti0202.store.product.ProductType;
import ee.taltech.iti0202.store.shops.AllShop;
import ee.taltech.iti0202.store.shops.FoodShop;

public class Main {
    public static void main(String[] args) throws CannotAddProductToShop {
        FoodShop foodShop = new FoodShop("Selver", 1000);
        AllShop allShop = new AllShop("Prisma", 10000);
        Product product = new Product("TV", 570, ProductType.ELECTRONICS);
        Product product1 = new Product("Painkiller", 8, ProductType.MEDICINE);
        Product product2 = new Product("Spoon", 1, ProductType.HOUSE_HOLD);
        Product product3 = new Product("Apple", 1, ProductType.FOOD);
        Client client = new Client("Ago", 29, 1000);
        Client client1 = new Client("Annemari", 20, 1000);


        try {
            Client client2 = new Client("Gert", 35, -1000);
        } catch (Exception e) {
            e.printStackTrace(); //RuntimeException
        }

        try {
            Client client5 = new Client("Meelis", 17, 1000);
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

        System.out.println(allShop.getProducts().size()); // 1

        System.out.println(allShop.getClients().get(0).getName()); // Ago
        System.out.println(foodShop.getClients()); // []
    }
}
