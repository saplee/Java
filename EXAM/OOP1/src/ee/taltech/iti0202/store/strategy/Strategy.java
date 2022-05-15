package ee.taltech.iti0202.store.strategy;

import ee.taltech.iti0202.store.client.Client;
import ee.taltech.iti0202.store.shops.Shop;

public abstract class Strategy {
    protected Client client;
    protected Shop shop;

    public Strategy (Client client, Shop shop){

        this.client = client;
        this.shop = shop;
    }

    public void getProducts(){

    }

    public Client getClient() {
        return client;
    }
}
