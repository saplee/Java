
package ee.taltech.iti0202.shelter.animal;

public abstract class Animal {
    private String color;

    /**
     *
     */
    public enum Type {
        HIROLA, TARANTULA, WOMBAT
    }

    /**
     * @param color
     */
    public Animal(String color) {
        this.color = color;
    }

    /**
     * @return color
     */
    public String getColor() {
        return color;
    }

    /**
     * @param color
     */
    public void setColor(String color) {
        this.color = color;
    }
}
