package ee.taltech.iti0202.zoo.animal;

public class AnimalBuilder {
    private String name;
    private String voice;
    private Integer eatTime;
    private Animal.Type type;

    /**
     *
     * @param name
     * @return
     */
    public AnimalBuilder setName(String name) {
        this.name = name;
        return this;
    }

    /**
     *
     * @param voice
     * @return
     */
    public AnimalBuilder setVoice(String voice) {
        this.voice = voice;
        return this;
    }

    /**
     *
     * @param eatTime
     * @return
     */
    public AnimalBuilder setEatTime(Integer eatTime) {
        this.eatTime = eatTime;
        return this;
    }

    /**
     *
     * @param type
     * @return
     */
    public AnimalBuilder setType(Animal.Type type) {
        this.type = type;
        return this;
    }

    /**
     *
     * @return
     */
    public Animal createAnimal() {
        return new Animal(name, voice, eatTime, type);
    }
}
