package ee.taltech.iti0202.tk0.cat;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private List<Cat> cats = new ArrayList<>();

    public Person() {

    }

    public boolean addCat(Cat cat) {
        if (cats.contains(cat)) {
            return false;
        } else {
            cats.add(cat);
            return true;
        }
    }

    public List<Cat> getCats() {
        return cats;
    }

    public boolean sellCat(Person sellTo, Cat cat) {
        if (sellTo.equals(this) || !cats.contains(cat)) {
            return false;
        } else {
            cats.remove(cat);
            sellTo.addCat(cat);
            return true;
        }
    }
}
