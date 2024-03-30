package rucafe.ordermanager;

import java.util.Objects;

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

    public boolean equals(String string) {
        String[] tokens = string.split("\\(");
        String flavor = tokens[0];
        String quantityStr = tokens[1].replaceAll("[^0-9]", "");
        int quantity = Integer.parseInt(quantityStr);

        return this.flavor.equals(flavor) && this.quantity == quantity;
    }
}
