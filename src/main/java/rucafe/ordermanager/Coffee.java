package rucafe.ordermanager;

import java.util.Arrays;

public class Coffee extends MenuItem {
    private CoffeeSize coffeeSize;
    private boolean[] add_ins;
    // [sweet cream, French vanilla, Irish cream, caramel, mocha]
    private int quantity;
    private static final double ADD_IN_PRICE = 0.30;

    public Coffee(CoffeeSize coffeeSize, boolean[] add_ins, int quantity) {
        this.coffeeSize = coffeeSize;
        this.add_ins = add_ins;
        this.quantity = quantity;
    }

    public CoffeeSize getCoffeeSize() {
        return coffeeSize;
    }
    public void setCoffeeSize(CoffeeSize coffeeSize) { this.coffeeSize = coffeeSize; }
    public boolean[] getAdd_ins() {
        return add_ins;
    }
    public void setAdd_ins(boolean[] add_ins) {
        this.add_ins = add_ins;
    }
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public double price() {
        int count = 0;
        for (boolean value : add_ins) {
            if (value) {
                count++;
            }
        }
        return (coffeeSize.getPrice() + (count * ADD_IN_PRICE)) * quantity;
    }

    @Override
    public boolean equals(MenuItem menuItem) {
        if (menuItem instanceof Coffee coffee) {
            return this.coffeeSize.equals(coffee.coffeeSize) && Arrays.equals(this.add_ins, coffee.add_ins);
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        String returnString = "(COFFEE) [Item Number: " + this.getItemNumber() + "]  size: " + coffeeSize + " Add-ins:";
        String add = "";
        if (add_ins[0]) add += " Sweet Cream,";
        if (add_ins[1]) add += " French Vanilla,";
        if (add_ins[2]) add += " Irish Cream,";
        if (add_ins[3]) add += " Caramel,";
        if (add_ins[4]) add += " mocha,";
        if (add.isEmpty()) add = " None,";

        returnString += add;
        returnString += " Quantity: " + quantity + " PRICE: $" + String.format("%.2f", this.price());
        return returnString;
    }
}
