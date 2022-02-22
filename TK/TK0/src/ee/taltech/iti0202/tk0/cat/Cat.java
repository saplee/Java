package ee.taltech.iti0202.tk0.cat;

public class Cat {
    private String name;
    private Integer age;
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

    public String toString() {
        if (color == null && age == null) {
            return name;
        }
        return color + " " + name + " (" + age + ")";
    }
}
