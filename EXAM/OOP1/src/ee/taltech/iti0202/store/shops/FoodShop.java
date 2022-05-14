package ee.taltech.iti0202.store.shops;

import ee.taltech.iti0202.store.client.Client;
import ee.taltech.iti0202.store.exceptions.CannotAddProductToShop;
import ee.taltech.iti0202.store.product.Product;
import ee.taltech.iti0202.store.product.ProductType;

public class FoodShop extends Shop {
    public FoodShop(String name, double profit) {
        super(name, profit);
    }

    @Override
    public void addProduct(Product product) throws CannotAddProductToShop {
        if (product.getProductType().equals(ProductType.FOOD) && !product.productAddedToShop()) {
            products.add(product);
            product.productAddToShop();
        }else {
            throw new CannotAddProductToShop();
        }
    }

    public static void main(String[] args) throws CannotAddProductToShop {
        FoodShop foodShop = new FoodShop("d", 100);
        AllShop allShop = new AllShop("d", 100);
        Product product = new Product("pc", 100, ProductType.FOOD);
        Product product1 = new Product("pc", 100, ProductType.FOOD);
        Client client = new Client("k", 19, 100);
        allShop.addCartToClient(client);
        allShop.addProduct(product);
        foodShop.addCartToClient(client);
        allShop.addProductToClient(client, product);
        System.out.println(product1.getId());
    }
}
