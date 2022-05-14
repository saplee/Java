package ee.taltech.iti0202.store.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import ee.taltech.iti0202.store.product.Product;
import ee.taltech.iti0202.store.product.ProductType;


import static ee.taltech.iti0202.store.product.Product.resetId;


class ProductTest {
    @Test
    void testGetProductName() {
        Product product = new Product("Apple", 1.2, ProductType.FOOD);
        Assertions.assertEquals("Apple", product.getName());
        resetId();
    }

    @Test
    void testGetProductPrice() {
        Product product = new Product("Apple", 1.2, ProductType.FOOD);
        Assertions.assertEquals(1.2, product.getPrice());
        resetId();

    }

    @Test
    void testGetProductId() {
        Product product = new Product("Apple", 1.2, ProductType.FOOD);
        Assertions.assertEquals(0, product.getId());
        resetId();
    }
    @Test
    void testGetProductIdWhenManyProducts() {
        Product product = new Product("Apple", 1.2, ProductType.FOOD);
        Product product1 = new Product("TV", 500, ProductType.ELECTRONICS);
        Product product2 = new Product("Lipstick", 7, ProductType.COSMETIC);
        Product product3 = new Product("Orange", 1.2, ProductType.FOOD);
        Product product4 = new Product("Phone", 777, ProductType.ELECTRONICS);
        Product product5 = new Product("Painkiller", 10, ProductType.FOOD);
        Product product6 = new Product("Table", 90, ProductType.HOUSE_HOLD);
        Product product7 = new Product("Towel", 12, ProductType.HOUSE_HOLD);
        Assertions.assertEquals(4, product4.getId());
        resetId();
    }
    @Test
    void testWrongProductPrice() {
        try {
            Product product = new Product("Apple", -1, ProductType.FOOD);
        }
        catch (RuntimeException e){
            e.printStackTrace();
        }
        resetId();
    }
}