package ee.taltech.iti0202.mysticorbs.oven;

import ee.taltech.iti0202.mysticorbs.orb.MagicOrb;
import ee.taltech.iti0202.mysticorbs.orb.Orb;
import ee.taltech.iti0202.mysticorbs.storage.ResourceStorage;

import java.util.Optional;

public class MagicOven extends Oven {
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
        if (!isBroken() && resourceStorage.hasEnoughResource("gold", 1) && resourceStorage.hasEnoughResource("dust", 3)) {
            MagicOrb magicOrb = new MagicOrb(name);
            resourceStorage.takeResource("gold", 1);
            resourceStorage.takeResource("dust", 3);
            magicOrb.charge("gold", 1);
            magicOrb.charge("dust", 3);
            counter += 1;
            return Optional.of(magicOrb);
        }
        return Optional.empty();
    }
}
