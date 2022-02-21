package ee.taltech.iti0202.mysticorbs.orb;

import java.util.Locale;

public class SpaceOrb extends Orb {
    /**
     *
     * @param creator
     */
    public SpaceOrb(String creator) {
        super(creator);
        energy = 100;
    }
    @Override
    public void charge(String resource, int amount) {
        if (!resource.toLowerCase(Locale.ROOT).equals("dust")) {
            energy = 100;
        }
    }

    /**
     *
     * @return
     */
    public String toString() {
        return "SpaceOrb by " + creator;
    }


    /**
     *
     * @param orb
     * @return
     */
    public boolean absorb(Orb orb) {
        if (orb.getEnergy() < this.energy) {
            this.energy += orb.getEnergy();
            orb.energy = 0;
            return true;
        }
        return false;
    }
}
