package ee.taltech.iti0202.zoo.animal;

public class AnimalBuilder {
    private String name;
    private String voice;
    private Integer eatTime;
    private Animal.Type type;

    public AnimalBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public AnimalBuilder setVoice(String voice) {
        this.voice = voice;
        return this;
    }

    public AnimalBuilder setEatTime(Integer eatTime) {
        this.eatTime = eatTime;
        return this;
    }

    public AnimalBuilder setType(Animal.Type type) {
        this.type = type;
        return this;
    }

    public Animal createAnimal() {
        return new Animal(name, voice, eatTime, type);
    }
}