package ee.taltech.iti0202.mysticorbs.orb;

public class MagicOrb extends Orb {

    public MagicOrb(String creator) {
        super(creator);
    }
    @Override
    public void charge(String resource, int amount) {
        energy = energy * 2;
    }

    public String toString() {
        return  "MagicOrb by " + creator;
    }
}
