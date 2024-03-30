package rucafe.ordermanager;

public enum DonutType {
    YEAST(1.79),
    CAKE(1.89),
    HOLE(0.39);

    private final double price;

    DonutType(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

}
