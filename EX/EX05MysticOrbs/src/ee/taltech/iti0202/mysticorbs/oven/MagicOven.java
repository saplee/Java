package ee.taltech.iti0202.mysticorbs.oven;

import ee.taltech.iti0202.mysticorbs.orb.MagicOrb;
import ee.taltech.iti0202.mysticorbs.orb.Orb;
import ee.taltech.iti0202.mysticorbs.storage.ResourceStorage;

import java.util.Optional;

public class MagicOven extends Oven {
    private int number = 0;

    /**
     * @param name
     * @param resourceStorage
     */
    public MagicOven(String name, ResourceStorage resourceStorage) {
        super(name, resourceStorage);
    }

    @Override
    public boolean isBroken() {
        if (counter >= 5) {
            return true;
        }
        return false;
    }

    @Override
    public Optional<Orb> craftOrb() {
        if (number % 2 == 0) {
            if (!isBroken() && resourceStorage.hasEnoughResource("silver", 1)
                    && resourceStorage.hasEnoughResource("pearl", 1)) {
                Orb orb = new Orb(name);
                resourceStorage.takeResource("dust", 3);
                resourceStorage.takeResource("gold", 1);
                orb.charge("gold", 1);
                orb.charge("dust", 1);
                counter += 1;
                number++;
                return Optional.of(orb);
            }
        } else {
            if (!isBroken() && resourceStorage.hasEnoughResource("gold", 1)
                    && resourceStorage.hasEnoughResource("dust", 3)) {
                MagicOrb magicOrb = new MagicOrb(name);
                resourceStorage.takeResource("gold", 1);
                resourceStorage.takeResource("dust", 3);
                magicOrb.charge("gold", 1);
                magicOrb.charge("dust", 3);
                counter += 1;
                number++;
                return Optional.of(magicOrb);
            }
        }
        return Optional.empty();
    }
}
