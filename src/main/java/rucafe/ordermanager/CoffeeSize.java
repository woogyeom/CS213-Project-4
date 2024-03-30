package rucafe.ordermanager;

public enum CoffeeSize {
    SHORT(1.99),
    TALL(2.49),
    GRANDE(2.99),
    VENTI(3.49);

    private final double price;

    CoffeeSize(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}
