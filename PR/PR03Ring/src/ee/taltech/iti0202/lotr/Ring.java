package ee.taltech.iti0202.lotr;



public class Ring {
    private final Type type;
    private final Material material;

    public Ring(Type type, Material material) {
        this.type = type;
        this.material = material;
    }
    public class Type {
        public Type getType() {
            return type;
    }
    }
    public class Material{
        public Material getMaterial() {
            return material;
        }
    }
}
