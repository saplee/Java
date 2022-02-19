package ee.taltech.iti0202.tk0.cat;

import java.util.ArrayList;
import java.util.List;

public class Cat {
    private String name;
    private int age;
    private String color;
    private Person owner;


    public Cat(String name) {
        this.name = name;
    }

    public Cat(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getColor() {
        return color;
    }
    public static void main(String[] args) {
        Cat cat = new Cat("Mati");
        System.out.println(cat);
        Cat muri = new Cat("Muri", 3, "White");
        System.out.println(muri);

        Person malle = new Person();
        Person kalle = new Person();
        System.out.println(malle.addCat(cat)); // true
        System.out.println(malle.addCat(cat)); // false

        System.out.println(malle.sellCat(kalle, cat)); // true
        System.out.println(malle.getCats()); // []
        System.out.println(kalle.getCats()); // [Mati]
    }
}
