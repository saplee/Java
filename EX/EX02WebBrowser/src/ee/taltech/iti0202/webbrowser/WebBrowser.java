package ee.taltech.iti0202.webbrowser;

import java.util.ArrayList;
import java.util.List;

public class WebBrowser {
    String homePage1 = "google.com";
    String currentPage = "google.com";
    List<String> bookMarks = new ArrayList<>();
    List<String> historyPage = new ArrayList<>();
    String previousPage = "";
    int backCount = 0;
    private String homePage;

    /**
     * Goes to homepage.
     */
    public void homePage() {
        currentPage = homePage1;
    }

    /**
     * Goes back to previous page.
     */
    public void back() {
    }

    /**
     * Goes forward to next page.
     */
    public void forward() {
        if (backCount == 0) {
            currentPage = currentPage;
        }
    }

    /**
     * Go to a webpage.
     *
     * @param url url to go to
     */
    public void goTo(String url) {
        currentPage = url;
    }

    /**
     * Add a webpage as a bookmark.
     */
    public void addAsBookmark() {
        if (!bookMarks.contains(currentPage)) {
            bookMarks.add(currentPage);
        }
    }

    /**
     * Remove a bookmark.
     *
     * @param bookmark to remove
     */
    public void removeBookmark(String bookmark) {
        bookMarks.remove(bookmark);
    }

    public List<String> getBookmarks() {
        return bookMarks;
    }

    public void setHomePage(String homePage) {
        homePage1 = homePage;
    }


    /**
     * Get top 3 visited pages.
     *
     * @return a String that contains top three visited pages separated with a newline "\n"
     */
    public String getTop3VisitedPages() {
        return null;
    }

    /**
     * Returns a list of all visited pages.
     * <p>
     * Not to be confused with pages in your back-history.
     * <p>
     * For example, if you visit "facebook.com" and hit back(),
     * then the whole history would be: ["google.com", "facebook.com", "google.com"]
     *
     * @return list of all visited pages
     */
    public List<String> getHistory() {
        if (!getCurrentUrl().equals(previousPage)) {
            historyPage.add(currentPage);
            previousPage = getCurrentUrl();
        }
        return historyPage;
    }


    /**
     * Returns the active web page (string).
     *
     * @return active web page
     */
    public String getCurrentUrl() {
        return currentPage;
    }
}

