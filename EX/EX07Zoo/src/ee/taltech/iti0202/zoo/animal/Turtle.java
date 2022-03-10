package ee.taltech.iti0202.zoo.animal;

import ee.taltech.iti0202.zoo.caretaker.Caretaker;

public class Turtle extends Animal {
    private int previousDays = 0;

    public Turtle(String name, Integer eatTime) {
        super(name, "", eatTime, Type.AMPHIBIAN);
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
}
