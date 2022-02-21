package ee.taltech.iti0202.tk0.cat;

import java.util.ArrayList;
import java.util.List;

public class Cat {
    private String name;
    private int age;
    private String color;


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
}
