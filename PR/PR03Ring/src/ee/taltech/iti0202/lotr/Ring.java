package ee.taltech.iti0202.lotr;

public class Ring {
    private Type type;
    private Material material;

    public Ring(Type type, Material material) {
        this.type = type;
        this.material = material;
    }
    enum Type {
        THE_ONE, GOLDEN, NENYA, OTHER
    }
    public Type getType() {
        return type;
    }
    enum Material {
        GOLD, SILVER, BRONZE, PLASTIC, DIAMOND
    }
    public Material getMaterial() {
        return material;
    }
}

