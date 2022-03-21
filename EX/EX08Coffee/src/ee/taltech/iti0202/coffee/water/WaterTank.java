package ee.taltech.iti0202.coffee.water;

public class WaterTank {
    private final int startAmount;
    private int amountOfWater;

    /**
     *
     * @param amountOfWater
     */
    public WaterTank(int amountOfWater) {

        this.amountOfWater = amountOfWater;
        this.startAmount = amountOfWater;
    }

    /**
     *
     * @return amount of water
     */
    public int getAmountOfWater() {
        return amountOfWater;
    }

    /**
     *
     * @return boolean
     */
    public boolean noWaterInTank() {
        if (amountOfWater == 0) {
            return true;
        }
        return false;
    }

    /**
     *
     */
    public void addWaterToTank() {
        amountOfWater = startAmount;
    }

    /**
     *
     */
    public void takeWater() {
        if (!noWaterInTank()) {
            amountOfWater--;
        }
    }
}
