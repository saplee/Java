package ee.taltech.iti0202.zoo.animal;


import ee.taltech.iti0202.zoo.caretaker.Caretaker;
import ee.taltech.iti0202.zoo.Zoo;

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
    public enum Type {
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

}
