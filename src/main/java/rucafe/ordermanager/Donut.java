package rucafe.ordermanager;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        Pattern pattern = Pattern.compile("^(.+)\\((\\d+)\\)$");
        Matcher matcher = pattern.matcher(string);
        if (matcher.find()) {
            String flavor = matcher.group(1);
            int quantity = Integer.parseInt(matcher.group(2));
            return this.flavor.equals(flavor) && this.quantity == quantity;
        } else {
            return false;
        }
    }
}
