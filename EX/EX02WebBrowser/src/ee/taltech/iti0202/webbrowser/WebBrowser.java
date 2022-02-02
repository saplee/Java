
package ee.taltech.iti0202.webbrowser;

import java.util.*;

public class WebBrowser {
    String homePage1 = "google.com";
    String currentPage = "google.com";
    List<String> bookMarks = new ArrayList<>();
    List<String> historyPage = new ArrayList<>();
    Stack<String> backStack = new Stack<>();
    Stack<String> forwardStack = new Stack<>();
    String previousPage = "";


    /**
     * Goes to homepage.
     */
    public void homePage() {
        if (!homePage1.equals(currentPage) && previousPage.equals("")) {
            previousPage = currentPage;
            currentPage = homePage1;
            historyPage.add(previousPage);
            historyPage.add(currentPage);
        } else if (!homePage1.equals(currentPage)) {
            historyPage.add(homePage1);
            previousPage = currentPage;
            currentPage = homePage1;

        }
    }

    /**
     * Goes back to previous page.
     */
    public void back() {
        if (backStack.size() >= 1) {
            String newPage = backStack.pop();
            historyPage.add(newPage);
            currentPage = newPage;
        }
    }

    /**
     * Goes forward to next page.
     */
    public void forward() {
    }

    /**
     * Go to a webpage.
     *
     * @param url url to go to
     */
    public void goTo(String url) {
        if (!currentPage.equals(url) && previousPage.equals("")) {
            historyPage.add(currentPage);
            historyPage.add(url);
            backStack.add(currentPage);
            previousPage = currentPage;
            currentPage = url;
        } else if (!currentPage.equals(url)) {
            historyPage.add(url);
            previousPage = currentPage;
            backStack.add(previousPage);
            currentPage = url;

        }
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
        if (previousPage.equals("")) {
            historyPage.add(currentPage);
            previousPage = currentPage;
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

    public static void main(String[] args) {
        WebBrowser webBrowser = new WebBrowser();
        webBrowser.goTo("facebook");
        webBrowser.goTo("google.com");
        webBrowser.back();
        System.out.println(webBrowser.getHistory());

    }
}

