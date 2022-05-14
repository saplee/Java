package ee.taltech.iti0202.store.shops;

import ee.taltech.iti0202.store.cart.Cart;
import ee.taltech.iti0202.store.client.Client;
import ee.taltech.iti0202.store.product.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public abstract class Shop {
    protected String name;
    protected Integer profit;
    protected List<Product> products = new ArrayList<>();
    protected List<Client> clients = new ArrayList<>();
    protected HashMap<Client, Cart> clientCartHashMap = new HashMap<>();

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

    public void setProfit(Integer profit) {
        this.profit = profit;
    }

    public void addProduct(Product product) {
        if (!products.contains(product) && !product.productAddedToShop()) {
            products.add(product);
            product.productAddToShop();
        }
    }

    public void removeProduct(Product product) {
        if (products.contains(product)) {
            products.remove(product);
            product.removeFromShop();
        }
    }

    public List<Product> getProducts() {
        return products;
    }

    public void addClient(Client client) {
        if (!clients.contains(client)) {
            clients.add(client);
        }
    }

    public void addCartToClient(Client client) {
        clientCartHashMap.put(client, new Cart());
    }

    public HashMap<Client, Cart> getClientCartHashMap() {
        return clientCartHashMap;
    }

    public void addProductToClient(Client client, Product product) {
        if (clientCartHashMap.containsKey(client) && products.contains(product)) {
            clientCartHashMap.get(client).addProduct(product);
            products.remove(product);
        }
    }

    public void clearClientCart(Client client) {
        if (clientCartHashMap.containsKey(client)) {
            products.addAll(clientCartHashMap.get(client).getProductList());
            clientCartHashMap.get(client).getProductList().clear();
        }
    }

    public List<Client> getClients() {
        return clients;
    }

    public Optional<Product> searchProductsById(Integer integer) {
        return products.stream().filter(product -> product.getId() == integer).findFirst();
    }

    public List<Product> searchProductsByName(String name1) {
        return getProducts().stream().filter(product -> product.getName().equals(name1)).toList();
    }

    public List<Product> searchProductsByName(Integer price) {
        return getProducts().stream().filter(product -> product.getPrice() == price).toList();
    }
}
