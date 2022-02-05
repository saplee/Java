package ee.taltech.iti0202.bookshelf;

public class Book {
    private final String title;
    private final String author;
    private final int yearOfPublishing;
    public static int price;
    static String owner = "";

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

    public void owner() {
        owner = Person.getName();
    }

    public static String getOwner() {
        return owner;
    }

    public static int getPrice() {
        return price;
    }

    public int getId() {
        return -287;
    }

}