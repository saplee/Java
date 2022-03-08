package ee.taltech.iti0202.zoo;


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
    public String getName() {
        return name;
    }

    @Override
    public boolean isHungry() {
        if (days > eatTime) {
            return true;
        }
        return false;
    }

    public void setVoice() {
        if (!isHungry()) {
            voices = "BANANA";
        }
    }

    @Override
    public String getVoice() {
        setVoice();
        return voices;
    }

    public static void main(String[] args) {
        Monkey monkey = new Monkey("s", 4);
        System.out.println(monkey.getVoice());
    }

}
