package ee.taltech.iti0202.bookshelf;

public class Book {
    String bookTitle = "";
    String bookAuthor = "";
    int bookYearOfPublishing;
    int bookPrice;

    public static int getAndIncrementNextId() {
        return 0;
    }

    public Book(String title, String author, int yearOfPublishing, int price) {
        bookTitle = title;
        bookAuthor = author;
        bookYearOfPublishing = yearOfPublishing;
        bookPrice = price;
    }

    public String getTitle() {
        return bookTitle;
    }

    public String getAuthor() {
        return bookAuthor;
    }

    public int getYearOfPublishing() {
        return bookYearOfPublishing;
    }

    public Person getOwner() {
        return null;
    }

    public int getPrice() {
        return bookPrice;
    }

    public int getId() {
        return -287;
    }

    public boolean buy(Person buyer) {
        return false;
    }

}