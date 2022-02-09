package ee.taltech.iti0202.bookshelf;



public class Book {
    private String title;
    private String author;
    private int yearOfPublishing;
    private int price;
    private Person owner;
    private int id;
    private static int number = -1;


    public static int getAndIncrementNextId() {
        return ++number;
    }

    /**
     * Book.
     * @param title
     * @param author
     * @param yearOfPublishing
     * @param price
     */
    public Book(String title, String author, int yearOfPublishing, int price) {
        this.title = title;
        this.author = author;
        this.yearOfPublishing = yearOfPublishing;
        this.price = price;
        this.id = getAndIncrementNextId();
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

    public void setOwner(Person newOwner) {
        owner = newOwner;
    }

    public Person getOwner() {
        return owner;
    }

    public int getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }

    /**
     *
     * @param buyer
     * @return
     */
    public boolean buy(Person buyer) {
        if (buyer != null && owner != null && (price > buyer.getMoney() || buyer.equals(owner))) {
            return false;
        } else if (buyer == null && owner != null) {
            return owner.sellBook(this);
        } else if (buyer != null && owner != null && buyer.getMoney() > price) {
            owner.sellBook(this);
            return buyer.buyBook(this);
        } else if (buyer != null && buyer.getMoney() > price) {
            return buyer.buyBook(this);
        }
        return false;
    }
}
