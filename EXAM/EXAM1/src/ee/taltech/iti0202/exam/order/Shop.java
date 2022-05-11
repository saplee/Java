package ee.taltech.iti0202.exam.order;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

import java.util.List;

public class Shop {
    private List<Product> products = new ArrayList<>();
    private HashMap<Integer, List<Product>> orders = new HashMap<>();
    private int orderNumber = 1;
    private List<Integer> cancelOrders = new ArrayList<>();

    public Shop() {

    }

    public boolean addProduct(Product product) {
        if (products.contains(product)) {
            return false;
        } else {
            products.add(product);
            return true;
        }
    }

    public int createNewOrder() {
        orders.put(orderNumber, new ArrayList<>());
        int result = orderNumber;
        orderNumber++;
        return result;
    }

    public boolean addProductToOrder(int orderNumber, String itemName) {
        if (!orders.containsKey(orderNumber)) {
            return false;
        } else if (getAvailableProducts().stream().map(Product::getName).toList().contains(itemName)
                && orders.containsKey(orderNumber) && !cancelOrders.contains(orderNumber)) {
            if (getAvailableProducts().stream().filter(product1 -> product1.getName().equals(itemName))
                    .sorted(Comparator.comparing(Product::getPrice)).toList().size() < 1) {
                return false;
            }
            Product product = getAvailableProducts().stream().filter(product1 -> product1.getName().equals(itemName))
                    .sorted(Comparator.comparing(Product::getPrice)).toList().get(0);
            orders.get(orderNumber).add(product);
            products.remove(product);
            return true;
        }
        return false;
    }

    public int getOrderSum(int orderNumber) {
        if (!orders.containsKey(orderNumber)) {
            return -1;
        } else if (orders.get(orderNumber).size() == 0) {
            return 0;
        } else {
            int result = 0;
            for (Product product : orders.get(orderNumber)) {
                result += product.getPrice();
            }
            return result;
        }
    }

    public boolean cancelOrder(int orderNumber) {
        if (!orders.containsKey(orderNumber)) {
            return false;
        } else if (!cancelOrders.contains(orderNumber)) {
            for (Product product : orders.get(orderNumber)) {
                products.add(product);
            }
            orders.get(orderNumber).clear();
            cancelOrders.add(orderNumber);
            return true;
        }
        return false;
    }


    public List<Product> getAvailableProducts() {
        return products;
    }
}
