package ee.taltech.iti0202.bookshelf;

public class Person {
    private static int money;
    private static String name;

    public Person(String name, int money) {
        this.money = money;
        this.name = name;
    }

    public static int getMoney() {
        return money;
    }

    public static String getName() {
        return name;
    }

    public boolean buyBook(Book book) {
        return false;
    }

    public boolean sellBook(Book book) {
        return false;
    }
}