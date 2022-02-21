package ee.taltech.iti0202.mysticorbs.factory;

import ee.taltech.iti0202.mysticorbs.orb.Orb;
import ee.taltech.iti0202.mysticorbs.oven.Oven;
import ee.taltech.iti0202.mysticorbs.storage.ResourceStorage;

import java.util.LinkedList;
import java.util.List;

public class OrbFactory {
    private ResourceStorage resourceStorage;
    private LinkedList<Oven> ovens = new LinkedList<>();

    public OrbFactory(ResourceStorage resourceStorage) {
        this.resourceStorage = resourceStorage;
    }


    public void addOven(Oven oven) {
        if (oven.getResourceStorage().equals(resourceStorage) || !ovens.contains(oven)) {
            ovens.add(oven);
        }
    }

    public List<Oven> getOvens() {
        return ovens;
    }

    public List<Orb> getAndClearProducedOrbsList() {
        return null;
    }

    public int produceOrbs() {
        return 0;
    }

    public int produceOrbs(int cycles) {
        return 0;
    }
}
