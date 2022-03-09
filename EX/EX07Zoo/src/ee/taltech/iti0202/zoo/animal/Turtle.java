package ee.taltech.iti0202.zoo.animal;

import ee.taltech.iti0202.zoo.Zoo;
import ee.taltech.iti0202.zoo.caretaker.Caretaker;

public class Turtle extends Animal {
    private int previousDays = 0;

    public Turtle(String name) {
        super(name, "", 0, Type.AMPHIBIAN);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getVoice() {
        return voice;
    }

    @Override
    public boolean isHungry() {
        if (day - previousDays > eatTime) {
            return true;
        }
        return false;
    }

    @Override
    public void giveFood(Caretaker caretaker) {
        if (isHungry() && caretaker.getTypeCanFeed().contains(type)) {
            previousDays = day;
        }
    }

    @Override
    public Type getType() {
        return type;
    }
}
