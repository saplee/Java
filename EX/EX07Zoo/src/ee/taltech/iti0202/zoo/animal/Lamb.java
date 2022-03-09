package ee.taltech.iti0202.zoo.animal;


public class Lamb extends Animal {
    public Lamb(String name, Integer eatTime) {
        super(name, "mää", eatTime, Type.MAMMAL);
    }


    @Override
    public boolean isHungry() {
        return false;
    }
}

