package ee.taltech.iti0202.bookshelf;

public class Person {
    private boolean sellBook;
    private boolean buyBook;
    private int money;
    private String name;

    /**
     * Person
     *
     * @param name
     * @param money
     */
    public Person(String name, int money) {
        this.money = money;
        this.name = name;
    }

    /**
     *
     * @return
     */
    public int getMoney() {
        return money;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * @param book
     * @return
     */
    public boolean buyBook(Book book) {
        if (book == null || book.getPrice() > money || book.getOwner() != null) {
            return false;
        } else {
            money -= book.getPrice();
            book.setOwner(this);
            return true;
        }
    }

    /**
     * @param book
     * @return
     */
    public boolean sellBook(Book book) {
        if (book == null || book.getOwner() == null || !book.getOwner().equals(this)) {
            return false;
        } else {
            book.setOwner(null);
            money += book.getPrice();
            return true;
        }
    }
}
