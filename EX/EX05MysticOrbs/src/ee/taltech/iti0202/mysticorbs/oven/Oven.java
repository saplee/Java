package ee.taltech.iti0202.mysticorbs.oven;

import ee.taltech.iti0202.mysticorbs.orb.Orb;
import ee.taltech.iti0202.mysticorbs.storage.ResourceStorage;

import java.util.Optional;

public class Oven {
    protected String name;
    protected ResourceStorage resourceStorage;
    protected int counter;

    /**
     *
     * @param name
     * @param resourceStorage
     */
    public Oven(String name, ResourceStorage resourceStorage) {
        this.name = name;
        this.resourceStorage = resourceStorage;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return
     */
    public ResourceStorage getResourceStorage() {
        return resourceStorage;
    }

    /**
     *
     * @return
     */
    public int getCreatedOrbsAmount() {
        return counter;
    }

    /**
     *
     * @return
     */
    public boolean isBroken() {
        if (counter >= 5 * 3) {
            return true;
        }
        return false;
    }

    /**
     *
     * @return
     */
    public Optional<Orb> craftOrb() {
        if (!isBroken() && resourceStorage.hasEnoughResource("silver", 1)
                && resourceStorage.hasEnoughResource("pearl", 1)) {
            Orb orb = new Orb(name);
            resourceStorage.takeResource("silver", 1);
            resourceStorage.takeResource("pearl", 1);
            orb.charge("silver", 1);
            orb.charge("pearl", 1);
            counter += 1;
            return Optional.of(orb);
        }
        return Optional.empty();
    }
}
