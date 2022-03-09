package ee.taltech.iti0202.zoo;


import java.util.Random;

public class Monkey extends Animal {
    String[] arr = {"uuh", "ääh"};
    Random random = new Random();
    int select = random.nextInt(arr.length);
    private String voices = arr[select];
    private int previousDays = 0;
    private int days;


    public Monkey(String name, Integer eatTime) {
        super(name, "ääh", eatTime, Animal.Type.MAMMAL);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isHungry(int number) {
        days = number;
        if (days - previousDays > eatTime) {
            return true;
        }
        return false;
    }

    public void setVoice() {
        if (isHungry(days)) {
            voices = "BANANA";
        } else {
            String[] arr = {"uuh", "ääh"};
            Random random = new Random();
            int select = random.nextInt(arr.length);
            voices = arr[select];
        }
    }

    public void giveFood(int number, Caretaker caretaker) {
        if (caretaker.getTypeCanFeed().equals(type)) {
            previousDays = number;
        }
    }

    @Override
    public String getVoice() {
        setVoice();
        return voices;
    }

    @Override
    public Type getType() {
        return type;
    }
}
