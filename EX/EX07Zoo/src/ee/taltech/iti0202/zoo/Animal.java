package ee.taltech.iti0202.zoo;


public class Animal extends Zoo {
    protected String name;
    protected String voice;
    protected Integer eatTime;
    protected Type type;
    protected int counter;

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

    public boolean isHungry() {
        if (counter > eatTime) {
            return true;
        }
        return false;
    }

    public String getVoice() {
        setVoice();
        return voice;
    }

    public void setVoice() {
        if (isHungry()) {
            voice = "";
        }
    }

    public Type getType() {
        return type;
    }


    public void giveFood(){
        counter = 0;
    }

    public static void main(String[] args) {
        Animal animal = new Animal("f", "g", 12, Type.BIRD);
        Zoo zoo = new Zoo();
        zoo.nextDay();
        zoo.nextDay();
        System.out.println(animal.getDays());
    }
}
