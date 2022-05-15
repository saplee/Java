package ee.taltech.iti0202.store.client;

public class ClientBuilder {
    private String name;
    private int age;
    private double money;

    public ClientBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public ClientBuilder setAge(int age) {
        this.age = age;
        return this;
    }

    public ClientBuilder setMoney(double money) {
        this.money = money;
        return this;
    }

    public Client createClient() {
        return new Client(name, age, money);
    }
}
