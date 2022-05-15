package ee.taltech.iti0202.store.shops;

import ee.taltech.iti0202.store.cart.Cart;
import ee.taltech.iti0202.store.client.Client;
import ee.taltech.iti0202.store.exceptions.CannotAddProductToShop;
import ee.taltech.iti0202.store.exceptions.NoClientCartFound;
import ee.taltech.iti0202.store.exceptions.NoProductInCart;
import ee.taltech.iti0202.store.exceptions.NoProductInShop;
import ee.taltech.iti0202.store.exceptions.NotEnoughBonusPoints;
import ee.taltech.iti0202.store.exceptions.NotEnoughMoney;
import ee.taltech.iti0202.store.product.Product;
import ee.taltech.iti0202.store.strategy.Strategy;

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
            product.productFree();
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

    /**
     * Adding to hashmap client and client value is cart.
     *
     * @param client
     */
    protected void addCartToClient(Client client) {
        if (!clientCartHashMap.containsKey(client)) {
            clientCartHashMap.put(client, new Cart());
        }
    }

    public HashMap<Client, Cart> getClientCartHashMap() {
        return clientCartHashMap;
    }

    /**
     * Adding product to client shopping cart.
     *
     * @param client
     * @param product
     */
    public void addProductToClientCart(Client client, Product product) {
        addCartToClient(client);
        if (clientCartHashMap.containsKey(client) && products.contains(product)) {
            clientCartHashMap.get(client).addProduct(product);
            products.remove(product);
        }
    }

    /**
     * Clearing client shopping cart in this e-shop.
     *
     * @param client
     */
    public void clearClientCart(Client client) {
        if (clientCartHashMap.containsKey(client)) {
            products.addAll(clientCartHashMap.get(client).getProductList());
            clientCartHashMap.get(client).getProductList().clear();
        }
    }

    public List<Client> getClients() {
        return clients;
    }

    /**
     * Calculating client cart price.
     *
     * @param client
     * @return
     */
    private double calculateCartSum(Client client) {
        double result = 0;
        for (double number : clientCartHashMap.get(client).getProductList().stream().map(Product::getPrice).toList()) {
            result += number;
        }
        return result;
    }

    /**
     * Client buys his/her shopping cart with money.
     * After that products will go to client and shop lose them and client lose money and shop earn profit.
     * If he/she do not have enough money it will throw NotEnoughMoney.
     * If client cart is empty it will throw NoProductInCart.
     * If there is no client cart it will throw NoClientCartFound.
     * @param client
     * @throws NotEnoughMoney
     * @throws NoProductInCart
     * @throws NoClientCartFound
     */
    public void buyProductsWithMoney(Client client) throws NotEnoughMoney, NoProductInCart, NoClientCartFound {
        if (clientCartHashMap.containsKey(client) && clientCartHashMap.get(client).getProductList().size() != 0
                && client.getMoney() >= calculateCartSum(client)) {
            for (Product product : clientCartHashMap.get(client).getProductList()) {
                client.addProduct(product, this);
                client.setMoney(client.getMoney() - product.getPrice());
                this.setProfit(profit + product.getPrice());
                client.addBonusPoints((int) Math.round(product.getPrice() * bonus));
            }
            this.addClient(client);
            // Clearing client shopping cart
            clientCartHashMap.get(client).getProductList().clear();

        } else if (!clientCartHashMap.containsKey(client)) {
            throw new NoClientCartFound();
        } else if (clientCartHashMap.get(client).getProductList().size() == 0) {
            throw new NoProductInCart();
        } else if (client.getMoney() < calculateCartSum(client)) {
            throw new NotEnoughMoney();
        }
    }

    public void giveStrategy(Strategy strategy) {
        addCartToClient(strategy.getClient());
        strategy.getProducts();
    }

    /**
     * Client is trying to buy his/her shopping cart with bonus points.
     * Product price will be (product price * 2)
     * If he/she do not have enough bonus points it will throw NotEnoughBonusPoints.
     * If client cart is empty it will throw NoProductInCart.
     * If there is no client cart it will throw NoClientCartFound.
     * @param client
     * @throws NoProductInCart
     * @throws NotEnoughBonusPoints
     * @throws NoClientCartFound
     */
    public void buyProductsWithBonusPoints(Client client) throws NoProductInCart, NotEnoughBonusPoints,
            NoClientCartFound {
        double sum = calculateCartSum(client) * 2;
        if (clientCartHashMap.containsKey(client) && clientCartHashMap.get(client).getProductList().size() != 0
                && client.getBonusPoints() >= calculateCartSum(client) * 2) {
            for (Product product : clientCartHashMap.get(client).getProductList()) {
                client.addProduct(product, this);
            }
            client.setBonusPoints((int) (client.getBonusPoints() - sum));
            this.addClient(client);
            clientCartHashMap.get(client).getProductList().clear();

        } else if (!clientCartHashMap.containsKey(client)) {
            throw new NoClientCartFound();
        } else if (clientCartHashMap.get(client).getProductList().size() == 0) {
            throw new NoProductInCart();
        } else if (client.getBonusPoints() < sum) {
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

    public List<Product> searchProductsByPrice(double price) {
        return getProducts().stream().filter(product -> product.getPrice() == price).toList();
    }
}
