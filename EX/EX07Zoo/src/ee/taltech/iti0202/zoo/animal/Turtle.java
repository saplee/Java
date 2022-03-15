package ee.taltech.iti0202.zoo.animal;



public class Turtle extends Animal {
    /**
     *
     * @param name
     * @param eatTime
     */
    public Turtle(String name, Integer eatTime) {
        super(name, "", eatTime, Type.AMPHIBIAN);
    }

    @Override
    public boolean isHungry() {
        if (day - previousDays > eatTime) {
            return true;
        }
        return false;
    }
}
