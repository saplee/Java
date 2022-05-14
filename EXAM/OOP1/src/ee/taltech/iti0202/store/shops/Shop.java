package ee.taltech.iti0202.store.shops;

import ee.taltech.iti0202.store.client.Client;
import ee.taltech.iti0202.store.exceptions.CannotReturnProducts;
import ee.taltech.iti0202.store.product.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class Shop {
    protected String name;
    protected Integer profit;
    protected List<Product> products = new ArrayList<>();
    protected List<Client> clients = new ArrayList<>();

    public Shop(String name, Integer profit) {

        this.name = name;
        this.profit = profit;
    }

    public String getName() {
        return name;
    }

    public Integer getProfit() {
        return profit;
    }

    public void addProduct(Product product) {
    }

    public void removeProduct(Product product) {

    }

    public List<Product> getProducts() {
        return products;
    }

    public void addClient(Client client) {
        if (!clients.contains(client)) {
            clients.add(client);
        }
    }

    public List<Client> getClients() {
        return clients;
    }

    public Optional<Product> searchProductsById(Integer integer) {
        return products.stream().filter(product -> product.getId() == integer).findFirst();
    }

    public List<Product> searchProductsByName(String name) {
        return getProducts().stream().filter(product -> product.getName().equals(name)).toList();
    }
}
