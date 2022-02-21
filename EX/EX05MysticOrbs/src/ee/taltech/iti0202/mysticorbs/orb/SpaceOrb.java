package ee.taltech.iti0202.mysticorbs.orb;

import java.util.Locale;

public class SpaceOrb extends Orb {

    public SpaceOrb(String creator) {
        super(creator);
    }

    @Override
    public void charge(String resource, int amount) {
        energy = 100;
    }

    public String toString() {
        return "SpaceOrb by " + creator;
    }

    public boolean absorb(Orb orb) {
        if (orb.getEnergy() < this.energy) {
            this.energy += orb.getEnergy();
            orb.energy = 0;
            return true;
        }
        return false;
    }
}
