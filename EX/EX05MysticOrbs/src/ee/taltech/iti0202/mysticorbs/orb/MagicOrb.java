package ee.taltech.iti0202.mysticorbs.orb;

import java.util.Locale;

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
        String word = resource.replace(" ", "");
        if (!resource.toLowerCase(Locale.ROOT).equals("dust") && word.length() != 0 && amount > 0) {
            energy = resource.length() * amount * 2;
        }
    }

    /**
     * @return
     */
    public String toString() {
        return "MagicOrb by " + creator;
    }
}
