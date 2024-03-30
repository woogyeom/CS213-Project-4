package rucafe.ordermanager;

public class Donut extends MenuItem {
    private final DonutType type;
    private final String flavor;
    private int quantity;
    public Donut(DonutType type, String flavor, int quantity) {
        this.type = type;
        this.flavor = flavor;
        this.quantity = quantity;
    }

    public DonutType getType() {
        return type;
    }

    public String getFlavor() {
        return flavor;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public double price() {
        return type.getPrice() * quantity;
    }
}
