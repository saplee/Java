package ee.taltech.iti0202.zoo;


public class Animal extends Zoo {
    protected String name;
    protected String voice;
    protected Integer eatTime;
    protected Type type;
    private int previousDays = 0;
    private int days;

    /**
     * @param name
     * @param voice
     * @param eatTime
     * @param type
     */
    public Animal(String name, String voice, Integer eatTime, Type type) {
        this.name = name;
        this.voice = voice;
        this.eatTime = eatTime;
        this.type = type;
    }

    /**
     *
     */
    enum Type {
        MAMMAL, BIRD, FISH, REPTILE, AMPHIBIAN
    }

    public String getName() {
        return name;
    }

    public boolean isHungry(int number) {
        days = number;
        if (days - previousDays > eatTime) {
            voice = "";
            return true;
        }
        return false;
    }

    public String getVoice() {
        isHungry(days);
        return voice;
    }

    public void giveFood(int number, Caretaker caretaker) {
        if (caretaker.getTypeCanFeed().equals(type)) {
            previousDays = number;
        }
    }

    public Type getType() {
        return type;
    }


    public static void main(String[] args) {
        Animal animal = new Animal("mikk", "mida sita", 2, Type.BIRD);
        Zoo zoo = new Zoo();
        zoo.nextDay();
        zoo.nextDay();
        zoo.nextDay();
        zoo.addAnimal(animal);
        System.out.println(zoo.getHungryAnimals());
    }
}
