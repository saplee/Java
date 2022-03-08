package ee.taltech.iti0202.zoo;

import java.util.Random;

public class Monkey extends Animal {
    String[] arr = {"uuh", "ääh"};
    Random random = new Random();
    int select = random.nextInt(arr.length);
    String voices = arr[select];

    public Monkey(String name, String voice, Integer eatTime, Type type) {
        super(name, voice, eatTime, Type.MAMMAL);
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
        return voices;
    }

    @Override
    public Type getType() {
        return type;
    }

}
