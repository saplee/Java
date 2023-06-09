package ee.taltech.iti0202.stock.stock;

import ee.taltech.iti0202.stock.exceptions.StockException;
import ee.taltech.iti0202.stock.product.Product;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

/**
 * The stock class.
 * <p>
 * Each stock has a name, list of products that are currently stored in it
 * and the maximum amount of products that stock can store.
 * <p>
 * If adding a product to the stock is not possible, due to exceeding the maximum limit of products
 * OR stock already contains a product, a StockException must be thrown,
 * otherwise product must be added to the stock.
 * <p>
 * When getting (not removing) a product from our stock,
 * it is important to find the product with the lowest price first.
 */

public class Stock {

    private String name;
    private int maxCapacity;
    private LinkedList<Product> stockList = new LinkedList<>();
    private final int num = 10000000;

    /**
     * Create a new stock with the given name and the max capacity for the products.
     *
     * @param name        the name of the stock.
     * @param maxCapacity max amount of products allowed in the stock.
     */
    public Stock(String name, int maxCapacity) {
        this.name = name;
        this.maxCapacity = maxCapacity;
    }

    /**
     * Add a product to the stock, if stock does not contain the product and is not full yet.
     * <p>
     * Check in following order:
     * If stock already contains a product, throw an StockException with a STOCK_ALREADY_CONTAINS_PRODUCT reason.
     * If stock is full, throw a StockException with a STOCK_IS_FULL reason.
     *
     * @param product to be added
     * @throws StockException STOCK_ALREADY_CONTAINS_PRODUCT, STOCK_IS_FULL
     */

    public void addProduct(Product product) throws StockException {
        if (stockList.contains(product)) {
            throw new StockException(StockException.Reason.STOCK_ALREADY_CONTAINS_PRODUCT);
        } else if (stockList.size() == maxCapacity) {
            throw new StockException(StockException.Reason.STOCK_IS_FULL);
        } else if (!stockList.contains(product) && stockList.size() < maxCapacity) {
            stockList.add(product);
        }
    }

    /**
     * Get a product from a stock by name with the lowest price.
     * <p>
     * If there are several products with the same name and price,
     * returns the product with the lowest id.
     *
     * @param name the product's name
     * @return Optional
     */
    public Optional<Product> getProduct(String name) {
        Product result = null;
        int number = num;
        for (Product product : stockList) {
            if (product.getName().equals(name) && product.getPrice() <= number) {
                result = product;
            }
        }
        return Optional.ofNullable(result);
    }

    /**
     * Remove and return a product from a stock,
     * if stock has a given product.
     * <p>
     * Use getProduct() method to get the product.
     * <p>
     * If there is nothing to remove, return Optional.empty()
     *
     * @param name Name of the product to be removed
     * @return Optional
     */

    public Optional<Product> removeProduct(String name) {
        Product result = null;
        int number = num;
        for (Product product : stockList) {
            if (product.getName().equals(name) && product.getPrice() <= number) {
                result = product;
            }
        }
        stockList.remove(result);
        return Optional.ofNullable(result);
    }

    /**
     * Get a list of current products in the stock.
     *
     * @return List
     */
    public List<Product> getProducts() {
        return stockList;
    }

    /**
     * Get a list of current products in the stock filtered by name.
     * <p>
     * Order the products by price ascending. In case of the same price, by id ascending.
     *
     * @param name Name to be filtered.
     * @return List
     */
    public List<Product> getProducts(String name) {
        LinkedList<Product> stockList2 = new LinkedList<>();
        LinkedHashMap<Product, Integer> dict = new LinkedHashMap<>();
        LinkedHashMap<Product, Integer> sortedMap = new LinkedHashMap<>();
        LinkedHashMap<Product, Integer> dict2 = new LinkedHashMap<>();
        LinkedHashMap<Product, Integer> sortedMap2 = new LinkedHashMap<>();
        for (Product product : stockList) {
            if (product.getName().equals(name)) {
                dict.put(product, product.getId());
            }
        }
        dict.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.naturalOrder()))
                .forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));
        Set<Product> keys = sortedMap.keySet();
        for (Product key : keys) {
            dict2.put(key, key.getPrice());
        }
        dict2.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.naturalOrder()))
                .forEachOrdered(x -> sortedMap2.put(x.getKey(), x.getValue()));
        Set<Product> keys2 = sortedMap2.keySet();
        stockList2.addAll(keys2);
        return stockList2;
    }

    /**
     * Get total price of all the products.
     *
     * @return Total price.
     */
    public int getTotalPrice() {
        int result = 0;
        for (Product item : stockList) {
            result += item.getPrice();
        }
        return result;
    }

    /**
     * Check if stock is full.
     *
     * @return boolean
     */
    public boolean isFull() {
        if (stockList.size() == maxCapacity) {
            return true;
        }
        return false;
    }
}
