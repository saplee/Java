package ee.taltech.iti0202.zoo.animal;

import ee.taltech.iti0202.zoo.Zoo;

public class Turtle extends Animal {
    private int days;
    private int previousDays = Zoo.getDays();

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
        days = Zoo.getDays();
        if (days - previousDays > eatTime) {
            return true;
        }
        return false;
    }

    @Override
    public Type getType() {
        return type;
    }
}
