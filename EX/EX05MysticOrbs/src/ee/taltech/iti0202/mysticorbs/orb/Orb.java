package ee.taltech.iti0202.mysticorbs.orb;

public class Orb {
    private String creator;
    private int energy;

    public Orb(String creator) {
        this.creator = creator;
    }

    public void charge(String resource, int amount) {
        if (!resource.equals("dust")) {
            energy = resource.length() * amount;
        }
    }

    public int getEnergy() {
        return energy;
    }
    
    public String toString() {
        return creator.toString();
    }
}
