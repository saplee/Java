
package ee.taltech.iti0202.webbrowser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;


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
            backStack.add(currentPage);
            previousPage = currentPage;
            currentPage = homePage1;
            historyPage.add(previousPage);
            historyPage.add(currentPage);
            forwardStack.clear();
        } else if (!homePage1.equals(currentPage)) {
            backStack.add(currentPage);
            historyPage.add(homePage1);
            previousPage = currentPage;
            currentPage = homePage1;
            forwardStack.clear();

        }
    }

    /**
     * Goes back to previous page.
     */
    public void back() {
        if (backStack.size() >= 1) {
            String newPage = backStack.pop();
            forwardStack.add(currentPage);
            historyPage.add(newPage);
            currentPage = newPage;
        }
    }

    /**
     * Goes forward to next page.
     */
    public void forward() {
        if (forwardStack.size() >= 1) {
            String newPage1 = forwardStack.pop();
            backStack.add(currentPage);
            historyPage.add(newPage1);
            currentPage = newPage1;
        }
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
            forwardStack.clear();
        } else if (!currentPage.equals(url)) {
            historyPage.add(url);
            previousPage = currentPage;
            backStack.add(previousPage);
            currentPage = url;
            forwardStack.clear();
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
        int number = 0;
        String word = "";
        Map<String, Integer> dict = new HashMap<>();
        List<String> result = new ArrayList<>();
        for (String page : historyPage) {
            dict.put(page, dict.getOrDefault(page, 0) + 1);
        }
        for (String key : dict.keySet()) {
            if (dict.get(key) >= number) {
                result.add(0, key);
                number = dict.get(key);
            }
        }
        for (String pages : result) {
            if (dict.get(pages) == 1) {
                word += "\n" + pages + " - " + dict.get(pages) + " visit";
            } else if (dict.get(pages) >= 2) {
                word += "\n" + pages + " - " + dict.get(pages) + " visits";
            }
        }
        return word;
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
        webBrowser.back();
        webBrowser.forward();
        System.out.println(webBrowser.getHistory());
        System.out.println(webBrowser.getTop3VisitedPages());

    }
}

