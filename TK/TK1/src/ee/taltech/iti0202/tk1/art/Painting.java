package ee.taltech.iti0202.tk1.art;

public class Painting {
    private String title;
    private String author;

    /**
     *
     * @param title
     * @param author
     */
    public Painting(String title, String author) {
        this.title = title;
        this.author = author;
    }

    /**
     *
     * @return
     */
    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    /**
     *
     * @return
     */
    public String toString() {
        if (author == null) {
            return "This is a painting named " + title + " and made by an unknown artist.";
        }
        return "This is a painting named " + title + " and made by " + author + ".";
    }
}
