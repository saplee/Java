package ee.taltech.iti0202.store;

import ee.taltech.iti0202.store.client.Client;
import ee.taltech.iti0202.store.exceptions.CannotAddProductToShop;
import ee.taltech.iti0202.store.product.Product;
import ee.taltech.iti0202.store.product.ProductType;
import ee.taltech.iti0202.store.shops.AllShop;
import ee.taltech.iti0202.store.shops.FoodShop;

public class Main {
    public static void main(String[] args) throws CannotAddProductToShop {
        FoodShop foodShop = new FoodShop("Selver",1000);
        AllShop allShop = new AllShop("Prisma", 10000);
        Product product = new Product("TV", 570, ProductType.ELECTRONICS);
        Product product1 = new Product("Pa", 100, ProductType.FOOD);
        Client client = new Client("k", 19, 100);
        allShop.addProduct(product);
        allShop.addProductToClient(client, product);
        System.out.println(allShop.getClientCartHashMap().get(client).getProductList());
    }
}
