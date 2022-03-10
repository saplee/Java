package ee.taltech.iti0202.zoo.animal;


import ee.taltech.iti0202.zoo.caretaker.Caretaker;

import java.util.Random;

public class Monkey extends Animal {
    String[] arr = {"uuh", "ääh"};
    Random random = new Random();
    int select = random.nextInt(arr.length);
    private String voices = arr[select];
    private int previousDays = 0;


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
    public void giveFood(Caretaker caretaker) {
        if (isHungry() && caretaker.getTypeCanFeed().contains(type)) {
            previousDays = day;
        }
    }

    @Override
    public String getVoice() {
        isHungry();
        return voices;
    }
}
