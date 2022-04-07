package ee.taltech.iti0202.kt.chocolatefactory;

import java.util.List;

public class ChocolateFactory {

    private int chocolateBoxesMade;
    private int costSoFar;

    public enum BoxType {

        SQUARE1(4, 4),
        SQUARE2(5, 5),
        RECTANGLE1(3, 6),
        RECTANGLE2(4, 8);

        private int width;
        private int length;

        BoxType(int width, int length) {
            this.width = width;
            this.length = length;
        }

        public int getWidth() {
            return width;
        }

        public int getLength() {
            return length;
        }
    }

    /**
     * Make a box of chocolate.
     * Two chocolate types are given: chocolate1, chocolate2.
     * The box size can be taken from BoxType:
     * length indicates the first index,
     * width indicates the second index in the box.
     * <p>
     * So, BoxType.RECTANGLE1 should be an array (preferredChocolate1Count = 4, see below):
     * [[1, 2, 1],
     * [2, 2, 2],
     * [2, 2, 2],
     * [2, 2, 2],
     * [2, 2, 2],
     * [1, 2, 1]]
     * <p>
     * Depending on the preferredChocolate1Count, different boxes should be created.
     * <p>
     * In case it is 0:
     * The box will contain only chocolate2 instances.
     * For example 4x4 box:
     * [[2, 2, 2, 2],
     * [2, 2, 2, 2],
     * [2, 2, 2, 2],
     * [2, 2, 2, 2]]
     * <p>
     * In case it is 4:
     * The corners contain chocolate 1 instance, the rest is chocolate2.
     * For example 4x4 box:
     * [[1, 2, 2, 1],
     * [2, 2, 2, 2],
     * [2, 2, 2, 2],
     * [1, 2, 2, 1]]
     * <p>
     * In case it is the number of chocolates on the edges:
     * The edge contains chocolate1 instances, the rest is chocolate2.
     * For example 4x4 box (preferredChocolate1Count = 12 in that case):
     * [[1, 1, 1, 1],
     * [1, 2, 2, 1],
     * [1, 2, 2, 1],
     * [1, 1, 1, 1]]
     * <p>
     * All other cases:
     * Chocolates are places as on chessboard. The [0][0] slot is filled with chocolate1.
     * For example 4x4 box:
     * [[1, 2, 1, 2],
     * [2, 1, 2, 1],
     * [1, 2, 1, 2],
     * [2, 1, 2, 1]]
     */
    public ChocolateType[][] makeChocolateBox(ChocolateType chocolate1, ChocolateType chocolate2,
                                              Integer preferredChocolate1Count, BoxType boxType) {
        return null;
    }

    public int getChocolateBoxesMade() {
        return chocolateBoxesMade;
    }

    public int getCostSoFar() {
        return costSoFar;
    }

    public static void main(String[] args) {
        ChocolateFactory factory = new ChocolateFactory();
        ChocolateType[][] a = factory.makeChocolateBox(new ChocolateType(7, "0"),
                new ChocolateType(9, "o"), 4, BoxType.RECTANGLE1);
        System.out.println(factory.getCostSoFar());  // 154
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j].getStringForm());
            }
            System.out.println();
        }
        // first row should be: 0o0
    }
}