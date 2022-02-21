package ee.taltech.iti0202.mysticorbs.orb;

import java.util.Locale;

public class Orb {
    protected String creator;
    protected int energy;

    /**
     * @param creator
     */
    public Orb(String creator) {
        this.creator = creator;
    }

    /**
     * @param resource
     * @param amount
     */
    public void charge(String resource, int amount) {
        if (!resource.toLowerCase(Locale.ROOT).equals("dust")) {
            energy = resource.length() * amount;
        }
    }

    /**
     * @return
     */
    public int getEnergy() {
        return energy;
    }

    /**
     * @return
     */
    public String toString() {
        return "Orb by " + creator;
    }
}
