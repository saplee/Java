package ee.taltech.iti0202.bookshelf;

public class Person {
    public boolean sellBook;
    public boolean buyBook;
    public int money;
    public String name;

    public Person(String name, int money) {
        this.money = money;
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public String getName() {
        return name;
    }

    public boolean buyBook(Book book) {
        if (book == null || book.getPrice() > money || book.getOwner() != null) {
            return false;
        } else {
            money -= book.getPrice();
            return true;
        }
    }

    public boolean sellBook(Book book) {
        if (book == null || book.getOwner() != null) {
            return false;
        } else {
            money += book.getPrice();
            return true;
        }
    }
}