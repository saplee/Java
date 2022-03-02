package ee.taltech.iti0202.mysticorbs.factory;

import ee.taltech.iti0202.mysticorbs.orb.Orb;

import ee.taltech.iti0202.mysticorbs.oven.Oven;
import ee.taltech.iti0202.mysticorbs.storage.ResourceStorage;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class OrbFactory {
    private ResourceStorage resourceStorage;
    private List<Oven> ovens = new LinkedList<>();
    private List<Orb> orbs = new LinkedList<>();

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
        List<Orb> result = new LinkedList<>(orbs);
        orbs.clear();
        return result;
    }

    /**
     * @return
     */
    public int produceOrbs() {
        for (Oven oven : ovens) {
            Optional<Orb> orb = oven.craftOrb();
            if (orb.isPresent()) {
                orbs.add(orb.get());
            }
        }
        return orbs.size();
    }

    /**
     * @param cycles
     * @return
     */
    public int produceOrbs(int cycles) {
        for (int i = 0; i < cycles; i++) {
            produceOrbs();
        }
        return orbs.size();
    }

    public List<Oven> getOvensThatCannotBeFixed() {
        return null;
    }

    public void getRidOfOvensThatCannotBeFixed() {
    }

    public void optimizeOvensOrder() {
    }
}
