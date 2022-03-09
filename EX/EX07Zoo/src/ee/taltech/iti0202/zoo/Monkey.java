package ee.taltech.iti0202.zoo;


import java.util.Random;

public class Monkey extends Animal {
    String[] arr = {"uuh", "ääh"};
    Random random = new Random();
    int select = random.nextInt(arr.length);
    private String voices = arr[select];
    private int previousDays = Zoo.getDays();
    private int days;


    public Monkey(String name, Integer eatTime) {
        super(name, "ääh", eatTime, Animal.Type.MAMMAL);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isHungry() {
        days = Zoo.getDays();
        if (days - previousDays > eatTime) {
            voices = "BANANA";
            return true;
        }
        String[] arr = {"uuh", "ääh"};
        Random random = new Random();
        int select = random.nextInt(arr.length);
        voices = arr[select];
        return false;
    }


    public void giveFood(int number, Caretaker caretaker) {
        if (isHungry() && caretaker.getTypeCanFeed().contains(type)) {
            previousDays = number;
        }
    }

    @Override
    public String getVoice() {
        isHungry();
        return voices;
    }

    @Override
    public Type getType() {
        return type;
    }
}
