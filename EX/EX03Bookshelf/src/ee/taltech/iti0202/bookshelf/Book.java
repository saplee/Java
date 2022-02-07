package ee.taltech.iti0202.bookshelf;

public class Book {
    private String title;
    private String author;
    private int yearOfPublishing;
    private int price;
    String owner = null;

    public static int getAndIncrementNextId() {
        return 0;
    }
    public Book(String title, String author, int yearOfPublishing, int price) {
        this.title = title;
        this.author = author;
        this.yearOfPublishing = yearOfPublishing;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYearOfPublishing() {
        return yearOfPublishing;
    }

    public String getOwner() {
        return owner;
    }

    public int getPrice() {
        return price;
    }

    public int getId() {
        return -287;
    }

    public boolean buy(Person buyer) {
        if (buyer == null) {
            return buyer.buyBook;
        }
        return buyer.buyBook;
    }
}