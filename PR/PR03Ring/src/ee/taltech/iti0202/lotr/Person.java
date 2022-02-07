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

    public void setRing(Ring ring) {
        this.ring = ring;
    }

    public String isSauron() {
        if (name.equals("Sauron") && (!ring.getType().equals("THE_ONE") || ring == null)) {
            return "No, but he's claiming to be.";
        } else if (ring.getMaterial().equals("GOLD") && ring.getType().equals("THE_ONE") && !name.equals("Sauron")) {
            return "No, he just stole the ring.";
        } else if (name.equals("Sauron") && ring.getType().equals("THE_ONE") && !ring.getMaterial().equals("GOLD")) {
            return "No, the ring is fake!";
        } else if (name.equals("Sauron") && ring.getType().equals("THE_ONE") && ring.getMaterial().equals("GOLD")) {
            return "Affirmative.";
        }
        return "No";
    }
}

