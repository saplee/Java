package ee.taltech.iti0202.zoo;


public class Animal {
    protected String name;
    protected String voice;
    protected Integer eatTime;
    protected Type type;

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
        return false;
    }

    public String getVoice() {
        return voice;
    }

    public Type getType() {
        return type;
    }
}
