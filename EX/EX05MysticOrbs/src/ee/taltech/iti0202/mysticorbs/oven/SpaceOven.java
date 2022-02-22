package ee.taltech.iti0202.mysticorbs.oven;

import ee.taltech.iti0202.mysticorbs.orb.Orb;
import ee.taltech.iti0202.mysticorbs.orb.SpaceOrb;
import ee.taltech.iti0202.mysticorbs.storage.ResourceStorage;

import java.util.Optional;

public class SpaceOven extends Oven {
    /**
     * @param name
     * @param resourceStorage
     */
    public SpaceOven(String name, ResourceStorage resourceStorage) {
        super(name, resourceStorage);
    }

    @Override
    public boolean isBroken() {
        if (counter >= 25) {
            return true;
        }
        return false;
    }

    @Override
    public Optional<Orb> craftOrb() {
        if (!isBroken() && resourceStorage.hasEnoughResource("meteorite stone", 1)
                && resourceStorage.hasEnoughResource("star fragment", 15)) {
            resourceStorage.takeResource("star fragment", 15);
            resourceStorage.takeResource("meteorite stone", 1);
            SpaceOrb spaceOrb = new SpaceOrb(name);
            spaceOrb.charge("meteorite stone", 1);
            counter += 1;
            return Optional.of(spaceOrb);
        } else if (!isBroken() && resourceStorage.hasEnoughResource("steel", 1)
                && resourceStorage.hasEnoughResource("pearl", 1)) {
            resourceStorage.takeResource("silver", 1);
            resourceStorage.takeResource("pearl", 1);
            Orb orb1 = new Orb(name);
            orb1.charge("silver", 1);
            orb1.charge("pearl", 1);
            counter += 1;
            return Optional.of(orb1);
        }
        return Optional.empty();
    }
}
