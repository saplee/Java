package ee.taltech.iti0202.lotr;

public class Person {
    private String race;
    private String name;
    private Ring ring;

    public Person(String race, String name, Ring ring) {
        this.race = race;
        this.name = name;
        this.ring = ring;
    }

    public Person(String race, String name) {
        this.race = race;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getRace() {
        return race;
    }

    public Ring getRing() {
        return ring;
    }

    public void setRing(Ring ring) {
        this.ring = ring;
    }

    public String isSauron() {
        if (name.equals("Sauron") && (ring == null || !ring.getType().equals(Ring.Type.THE_ONE))) {
            return "No, but he's claiming to be";
        } else if (ring != null && ring.getMaterial().equals(Ring.Material.GOLD)
                && ring.getType().equals(Ring.Type.THE_ONE)
                && !name.equals("Sauron")) {
            return "No, he just stole the ring";
        } else if (ring != null && name.equals("Sauron") && ring.getType().equals(Ring.Type.THE_ONE)
                && !ring.getMaterial().equals(Ring.Material.GOLD)) {
            return "No, the ring is fake!";
        } else if (ring != null && name.equals("Sauron") && ring.getType().equals(Ring.Type.THE_ONE)
                && ring.getMaterial().equals(Ring.Material.GOLD)) {
            return "Affirmative";
        }
        return "No";
    }
}

