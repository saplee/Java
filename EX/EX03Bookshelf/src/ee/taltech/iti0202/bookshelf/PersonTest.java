package ee.taltech.iti0202.bookshelf;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 *
 */
class PersonTest {
    final int number = 45;
    final int number2 = 400;
    final int number3 = 199;
    final int price = 200;
    final int year = 1926;

    @BeforeEach
    void setUp() {
    }

    @Test
    void getMoney() {
        Person person = new Person("Kalle", number);
        assertEquals(number, person.getMoney());
    }

    @Test
    void getName() {
        Person person = new Person("Kalle", number);
        assertEquals("Kalle", person.getName());
    }

    @Test
    void buyBook() {
        Book book = new Book("Truth and Justice", "Tammsaare", year, price);
        Person person = new Person("Kalle", number2);
        assertTrue(person.buyBook(book));
    }

    @Test
    void buyBook2() {
        Book book = new Book("Truth and Justice", "Tammsaare", year, price);
        Person person = new Person("Kalle", number3);
        assertFalse(person.buyBook(book));
    }

    @Test
    void sellBook() {
        Book book = new Book("Truth and Justice", "Tammsaare", year, price);
        Person person = new Person("Kalle", number3);
        assertFalse(person.sellBook(book));
    }

    @Test
    void sellBook2() {
        Book book = new Book("Truth and Justice", "Tammsaare", year, price);
        Person person = new Person("Kalle", number3);
        book.setOwner(person);
        assertTrue(person.sellBook(book));
    }
}
