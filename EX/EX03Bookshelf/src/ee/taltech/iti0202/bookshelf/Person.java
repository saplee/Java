package ee.taltech.iti0202.bookshelf;

public class Person {
    static String personName = "";
    int personMoney;

    public Person(String name, int money) {
        personName = name;
        personMoney = money;
    }

    public int getMoney() {
        return personMoney;
    }

    public static String getName() {
        return personName;
    }

    public boolean buyBook(Book book) {
        return false;
    }

    public boolean sellBook(Book book) {
        return false;
    }
}