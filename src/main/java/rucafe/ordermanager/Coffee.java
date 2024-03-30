package rucafe.ordermanager;

public class Coffee extends MenuItem {
    private final CoffeeSize coffeeSize;
    private final Boolean[] add_ins;
    // [sweet cream, French vanilla, Irish cream, caramel, mocha]
    private static final double ADD_IN_PRICE = 0.30;

    public Coffee(CoffeeSize coffeeSize, Boolean[] add_ins) {
        this.coffeeSize = coffeeSize;
        this.add_ins = add_ins;
    }

    public CoffeeSize getCoffeeSize() {
        return coffeeSize;
    }

    public Boolean[] getAdd_ins() {
        return add_ins;
    }

    @Override
    public double price() {
        int count = 0;
        for (boolean value : add_ins) {
            if (value) {
                count++;
            }
        }
        return coffeeSize.getPrice() + (count * ADD_IN_PRICE);
    }
}
