package rucafe.ordermanager;

public enum SandwichProtein {
    BEEF(10.99),
    FISH(8.99),
    CHICKEN(9.99);

    private final double price;

    SandwichProtein(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}
