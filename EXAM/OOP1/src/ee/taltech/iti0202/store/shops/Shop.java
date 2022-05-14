package ee.taltech.iti0202.store.shops;

import ee.taltech.iti0202.store.cart.Cart;
import ee.taltech.iti0202.store.client.Client;
import ee.taltech.iti0202.store.exceptions.*;
import ee.taltech.iti0202.store.product.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public abstract class Shop {
    protected String name;
    protected double profit;
    protected List<Product> products = new ArrayList<>();
    protected List<Client> clients = new ArrayList<>();
    protected HashMap<Client, Cart> clientCartHashMap = new HashMap<>();
    protected final double bonus = 0.25;

    public Shop(String name, double profit) {

        this.name = name;
        this.profit = profit;
    }

    public String getName() {
        return name;
    }

    public double getProfit() {
        return profit;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }

    public void addProduct(Product product) throws CannotAddProductToShop {
        if (!products.contains(product) && !product.productAddedToShop()) {
            products.add(product);
            product.productAddToShop();
        } else {
            throw new CannotAddProductToShop();
        }
    }

    public void removeProduct(Product product) throws NoProductInShop {
        if (products.contains(product)) {
            products.remove(product);
            product.removeFromShop();
        } else {
            throw new NoProductInShop();
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

    protected void addCartToClient(Client client) {
        clientCartHashMap.put(client, new Cart());
    }

    public HashMap<Client, Cart> getClientCartHashMap() {
        return clientCartHashMap;
    }

    public void addProductToClientCart(Client client, Product product) {
        addCartToClient(client);
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

    private double calculateCartSum(Client client) {
        double result = 0;
        for (double number : clientCartHashMap.get(client).getProductList().stream().map(Product::getPrice).toList()) {
            result += number;
        }
        return result;
    }


    public void buyProductsWithMoney(Client client) throws NotEnoughMoney, NoProductInCart, NoClientCartFound {
        if (clientCartHashMap.containsKey(client) && clientCartHashMap.get(client).getProductList().size() != 0
                && client.getMoney() >= calculateCartSum(client)) {
            for (Product product : clientCartHashMap.get(client).getProductList()) {
                client.addProduct(product, this);
                client.setMoney(client.getMoney() - product.getPrice());
                this.setProfit(profit + product.getPrice());
                client.addBonusPoints(product.getPrice() * bonus);
                product.removeFromShop();
            }
            this.addClient(client);
            clientCartHashMap.get(client).getProductList().clear();

        } else if (!clientCartHashMap.containsKey(client)) {
            throw new NoClientCartFound();
        } else if (clientCartHashMap.get(client).getProductList().size() == 0) {
            throw new NoProductInCart();
        } else if (client.getMoney() < calculateCartSum(client)) {
            throw new NotEnoughMoney();
        }
    }

    public void giveStrategy() {
    }

    ;

    public void buyProductsWithBonusPoints(Client client) throws NoProductInCart, NotEnoughBonusPoints, NoClientCartFound {
        if (clientCartHashMap.containsKey(client) && clientCartHashMap.get(client).getProductList().size() != 0
                && client.getBonusPoints() >= calculateCartSum(client)) {
            for (Product product : clientCartHashMap.get(client).getProductList()) {
                client.addProduct(product, this);
                client.setBonusPoints((int) (client.getBonusPoints() - product.getPrice()));
            }
            this.addClient(client);
            clientCartHashMap.get(client).getProductList().clear();

        } else if (!clientCartHashMap.containsKey(client)) {
            throw new NoClientCartFound();
        } else if (clientCartHashMap.get(client).getProductList().size() == 0) {
            throw new NoProductInCart();
        } else if (client.getMoney() < calculateCartSum(client)) {
            throw new NotEnoughBonusPoints();
        }
    }


    public Optional<Product> searchProductsById(Integer integer) {
        return products.stream().filter(product -> product.getId() == integer).findFirst();
    }

    public List<Product> searchProductsByName(String name1) {
        String result = name1.toLowerCase();
        return getProducts().stream().filter(product -> product.getName().toLowerCase().equals(result)).toList();
    }

    public List<Product> searchProductsByName(Integer price) {
        return getProducts().stream().filter(product -> product.getPrice() == price).toList();
    }
}
