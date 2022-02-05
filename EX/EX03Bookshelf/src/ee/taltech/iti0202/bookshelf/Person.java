package ee.taltech.iti0202.bookshelf;

import javax.swing.plaf.TreeUI;

public class Person {
    public static boolean sellBook;
    public static boolean buyBook;
    public static int money;
    public static String name;

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
        if (book == null || Book.getPrice() > money || Book.getOwner() == null) {
            return false;
        } else {
            money -= Book.getPrice();
            return true;
        }
    }

    public boolean sellBook(Book book) {
        if (book == null || Book.getOwner() != null) {
            return false;
        } else {
            money += Book.getPrice();
            return true;
        }
    }
}