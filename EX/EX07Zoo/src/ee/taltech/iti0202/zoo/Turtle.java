package ee.taltech.iti0202.zoo;

public class Turtle extends Animal {
    public Turtle(String name, String voice, Integer eatTime) {
        super(name, "", eatTime, Type.AMPHIBIAN);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean animalHungryOrNot() {
        return false;
    }

    @Override
    public String getVoice() {
        return voice;
    }

    @Override
    public Type getType() {
        return type;
    }
}
