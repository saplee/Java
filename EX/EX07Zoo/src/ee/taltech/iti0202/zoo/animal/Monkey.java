package ee.taltech.iti0202.zoo.animal;


import java.util.Random;

public class Monkey extends Animal {
    String[] arr = {"uuh", "ääh"};
    Random random = new Random();
    int select = random.nextInt(arr.length);
    private String voices = arr[select];


    public Monkey(String name, Integer eatTime) {
        super(name, "ääh", eatTime, Animal.Type.MAMMAL);
    }

    @Override
    public boolean isHungry() {
        if (day - previousDays > eatTime) {
            voices = "BANANA";
            return true;
        }
        String[] arr = {"uuh", "ääh"};
        Random random = new Random();
        int select = random.nextInt(arr.length);
        voices = arr[select];
        return false;
    }

    @Override
    public String getVoice() {
        isHungry();
        return voices;
    }
}
