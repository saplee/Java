package ee.taltech.iti0202.bookshelf;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BookTest {
    final int number = 500;
    final int price = 500;
    final int price2 = 400;
    final int price3 = 800;
    final int year = 1926;

    @BeforeEach
    void setUp() {
    }

    @Test
    void setOwner() {
        Person person = new Person("Kalev", number);
        Book book = new Book("Truth and Justice", "Tammsaare", year, price);
        book.setOwner(person);
        assertEquals(number, book.getOwner().getMoney());
    }

    @Test
    void getTitle() {
        Person person = new Person("Kalev", number);
        Book book = new Book("Truth and Justice", "Tammsaare", year, price);
        book.setOwner(person);
        assertEquals("Truth and Justice", book.getTitle());
    }

    @Test
    void getAuthor() {
        Person person = new Person("Kalev", number);
        Book book = new Book("Truth and Justice", "Tammsaare", year, price);
        book.setOwner(person);
        assertEquals("Tammsaare", book.getAuthor());
    }

    @Test
    void buyBook() {
        Person person = new Person("Kalev", number);
        Book book = new Book("Truth and Justice", "Tammsaare", year, price3);
        assertFalse(book.buy(person));
    }

    @Test
    void buyBook2() {
        Person person = new Person("Kalev", number);
        Book book = new Book("Truth and Justice", "Tammsaare", year, price2);
        assertTrue(book.buy(person));
    }

    @Test
    void getPrice() {
        Person person = new Person("Kalev", number);
        Book book = new Book("Truth and Justice", "Tammsaare", year, price);
        book.setOwner(person);
        assertEquals(price, book.getPrice());
    }

    @Test
    void getOwner2() {
        Person person = new Person("Kalev", number);
        Book book = new Book("Truth and Justice", "Tammsaare", year, price);
        book.setOwner(person);
        assertEquals("Kalev", book.getOwner().getName());
    }

    @Test
    void getYearOfPublishing() {
        Person person = new Person("Kalev", number);
        Book book = new Book("Truth and Justice", "Tammsaare", year, price);
        book.setOwner(person);
        assertEquals(year, book.getYearOfPublishing());
    }

    @Test
    void buyBook3() {
        Person person = null;
        Book book = new Book("Truth and Justice", "Tammsaare", year, price3);
        assertFalse(book.buy(person));
    }

    @Test
    void buyBook4() {
        Person person = new Person("Kalev", number);
        Book book = new Book("Truth and Justice", "Tammsaare", year, price3);
        book.setOwner(person);
        assertFalse(book.buy(person));
    }
}
