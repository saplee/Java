package ee.taltech.iti0202.zoo;

public class Lamb extends Animal {
    public Lamb(String name, String voice, Integer eatTime) {
        super(name, "mää", eatTime, Type.MAMMAL);
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
}
