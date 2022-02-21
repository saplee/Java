package ee.taltech.iti0202.mysticorbs.orb;

public class MagicOrb extends Orb {
    /**
     * @param creator
     */
    public MagicOrb(String creator) {
        super(creator);
    }

    /**
     * @param resource
     * @param amount
     */
    @Override
    public void charge(String resource, int amount) {
        energy = resource.length() * amount * 2;
    }

    /**
     * @return
     */
    public String toString() {
        return "MagicOrb by " + creator;
    }
}
