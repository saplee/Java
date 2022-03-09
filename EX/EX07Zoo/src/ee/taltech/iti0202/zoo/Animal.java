package ee.taltech.iti0202.zoo;


import java.util.ArrayList;
import java.util.List;

public class Animal extends Zoo {
    protected String name;
    protected String voice;
    protected Integer eatTime;
    protected Type type;
    private int previousDays = Zoo.getDays();
    private int days;
    private String notHungryVoice;

    /**
     * @param name
     * @param voice
     * @param eatTime
     * @param type
     */
    public Animal(String name, String voice, Integer eatTime, Type type) {
        this.name = name;
        this.voice = voice;
        this.notHungryVoice = voice;
        this.eatTime = eatTime;
        this.type = type;
    }

    /**
     *
     */
    enum Type {
        MAMMAL, BIRD, FISH, REPTILE, AMPHIBIAN
    }

    public String getName() {
        return name;
    }

    public boolean isHungry() {
        days = Zoo.getDays();
        if (days - previousDays > eatTime) {
            voice = "";
            return true;
        }
        voice = notHungryVoice;
        return false;
    }

    public String getVoice() {
        isHungry();
        return voice;
    }

    public void giveFood(int number, Caretaker caretaker) {
        if (isHungry() && caretaker.getTypeCanFeed().contains(type)) {
            previousDays = number;
        }
    }

    public Type getType() {
        return type;
    }


    public static void main(String[] args) {
        Animal animal = new Animal("mikk", "mida", 2, Type.BIRD);
        Zoo zoo = new Zoo();
        List<Type> f = new ArrayList<>(List.of(Type.BIRD));
        Caretaker caretaker = new Caretaker("Mattias", f);
        zoo.addAnimal(animal);
        zoo.nextDay();
        zoo.nextDay();
        zoo.nextDay();
        Animal animal2 = new Animal("mikk", "mk", 2, Type.BIRD);
        zoo.addAnimal(animal2);
        animal.giveFood(Zoo.getDays(), caretaker);
        zoo.nextDay();
        zoo.nextDay();
        zoo.nextDay();
        animal.giveFood(Zoo.getDays(), caretaker);
        System.out.println(animal.getVoice());
    }
}
