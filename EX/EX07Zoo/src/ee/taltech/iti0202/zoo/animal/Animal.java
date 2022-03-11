package ee.taltech.iti0202.zoo.animal;


import ee.taltech.iti0202.zoo.caretaker.Caretaker;


public class Animal {
    protected String name;
    protected String voice;
    protected Integer eatTime;
    protected Type type;
    protected int previousDays = 0;
    protected int day = 0;
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

    public void nextDay() {
        day++;
    }

    public boolean isHungry() {
        if (day - previousDays > eatTime) {
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

    public void giveFood(Caretaker caretaker) {
        if (isHungry() && caretaker.getTypeCanFeed().contains(type)) {
            previousDays = day;
        }
    }

    public Type getType() {
        return type;
    }
}
