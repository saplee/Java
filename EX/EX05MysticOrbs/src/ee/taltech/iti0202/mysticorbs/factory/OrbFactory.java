package ee.taltech.iti0202.mysticorbs.factory;

import ee.taltech.iti0202.mysticorbs.orb.Orb;
import ee.taltech.iti0202.mysticorbs.oven.Oven;
import ee.taltech.iti0202.mysticorbs.storage.ResourceStorage;

import java.util.LinkedList;
import java.util.List;

public class OrbFactory {
    private ResourceStorage resourceStorage;
    private LinkedList<Oven> ovens = new LinkedList<>();

    /**
     * @param resourceStorage
     */
    public OrbFactory(ResourceStorage resourceStorage) {
        this.resourceStorage = resourceStorage;
    }

    /**
     * @param oven
     */
    public void addOven(Oven oven) {
        if (oven.getResourceStorage().equals(resourceStorage) || !ovens.contains(oven)) {
            ovens.add(oven);
        }
    }

    /**
     * @return
     */
    public List<Oven> getOvens() {
        return ovens;
    }

    /**
     * @return
     */
    public List<Orb> getAndClearProducedOrbsList() {
        return null;
    }

    /**
     * @return
     */
    public int produceOrbs() {
        return 0;
    }

    /**
     * @param cycles
     * @return
     */
    public int produceOrbs(int cycles) {
        return 0;
    }
}
