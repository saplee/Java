package ee.taltech.iti0202.mysticorbs.orb;

public class Orb {
    protected String creator;
    protected int energy;

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
        return "Orb by " + creator;
    }
}