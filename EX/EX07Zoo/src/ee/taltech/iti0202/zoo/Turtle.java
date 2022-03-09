package ee.taltech.iti0202.zoo;

public class Turtle extends Animal {
    private int days;
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
    public boolean isHungry(int number) {
        days = number;
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
