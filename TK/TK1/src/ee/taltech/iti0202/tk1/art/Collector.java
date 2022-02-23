package ee.taltech.iti0202.tk1.art;

import java.util.ArrayList;
import java.util.List;

public class Collector {
    private List<Painting> result = new ArrayList<>();

    /**
     * @param painting
     * @return
     */
    public boolean addPainting(Painting painting) {
        if (!result.contains(painting)) {
            result.add(painting);
            return true;
        }
        return false;
    }

    /**
     * @param painting
     * @param fellowCollector
     * @return
     */
    boolean sellPainting(Painting painting, Collector fellowCollector) {
        if (!fellowCollector.getPaintings().contains(painting) && result.contains(painting)) {
            fellowCollector.addPainting(painting);
            this.result.remove(painting);
            return true;
        }
        return false;
    }

    /**
     * @return
     */
    List<Painting> getPaintings() {
        return result;
    }
}
