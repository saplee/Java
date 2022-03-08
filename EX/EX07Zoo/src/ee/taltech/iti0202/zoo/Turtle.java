package ee.taltech.iti0202.zoo;

public class Turtle extends Animal {
    public Turtle(String name) {
        super(name, "",0, Type.AMPHIBIAN);
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
    public Type getType() {
        return type;
    }
}
